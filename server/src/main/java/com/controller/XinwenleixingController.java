package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.XinwenleixingEntity;
import com.entity.view.XinwenleixingView;
import com.service.XinwenleixingService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


/**
 * 新闻类型
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31 09:07:47
 */
@RestController
@RequestMapping("/xinwenleixing")
public class XinwenleixingController {
    @Autowired
    private XinwenleixingService xinwenleixingService;



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinwenleixingEntity xinwenleixing,
		HttpServletRequest request){
        EntityWrapper<XinwenleixingEntity> ew = new EntityWrapper<XinwenleixingEntity>();
		PageUtils page = xinwenleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinwenleixing), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinwenleixingEntity xinwenleixing, HttpServletRequest request){
        EntityWrapper<XinwenleixingEntity> ew = new EntityWrapper<XinwenleixingEntity>();
		PageUtils page = xinwenleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinwenleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinwenleixingEntity xinwenleixing){
       	EntityWrapper<XinwenleixingEntity> ew = new EntityWrapper<XinwenleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinwenleixing, "xinwenleixing"));
        return R.ok().put("data", xinwenleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinwenleixingEntity xinwenleixing){
        EntityWrapper< XinwenleixingEntity> ew = new EntityWrapper< XinwenleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinwenleixing, "xinwenleixing"));
		XinwenleixingView xinwenleixingView =  xinwenleixingService.selectView(ew);
		return R.ok("查询新闻类型成功").put("data", xinwenleixingView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinwenleixingEntity xinwenleixing = xinwenleixingService.selectById(id);
        return R.ok().put("data", xinwenleixing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinwenleixingEntity xinwenleixing = xinwenleixingService.selectById(id);
        return R.ok().put("data", xinwenleixing);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinwenleixingEntity xinwenleixing, HttpServletRequest request){
    	xinwenleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinwenleixing);
        xinwenleixingService.insert(xinwenleixing);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinwenleixingEntity xinwenleixing, HttpServletRequest request){
    	xinwenleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xinwenleixing);
        xinwenleixingService.insert(xinwenleixing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody XinwenleixingEntity xinwenleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinwenleixing);
        xinwenleixingService.updateById(xinwenleixing);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinwenleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);

		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}

		Wrapper<XinwenleixingEntity> wrapper = new EntityWrapper<XinwenleixingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = xinwenleixingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
