package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.DiscussxiaoyuanxinwenEntity;
import com.entity.view.DiscussxiaoyuanxinwenView;
import com.service.DiscussxiaoyuanxinwenService;
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
 * 校园新闻评论表
 * 后端接口
 * @author
 * @email
 * @date 2021-03-31 09:07:48
 */
@RestController
@RequestMapping("/discussxiaoyuanxinwen")
public class DiscussxiaoyuanxinwenController {
    @Autowired
    private DiscussxiaoyuanxinwenService discussxiaoyuanxinwenService;



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen,
		HttpServletRequest request){
        EntityWrapper<DiscussxiaoyuanxinwenEntity> ew = new EntityWrapper<DiscussxiaoyuanxinwenEntity>();
		PageUtils page = discussxiaoyuanxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiaoyuanxinwen), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen, HttpServletRequest request){
        EntityWrapper<DiscussxiaoyuanxinwenEntity> ew = new EntityWrapper<DiscussxiaoyuanxinwenEntity>();
		PageUtils page = discussxiaoyuanxinwenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxiaoyuanxinwen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen){
       	EntityWrapper<DiscussxiaoyuanxinwenEntity> ew = new EntityWrapper<DiscussxiaoyuanxinwenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxiaoyuanxinwen, "discussxiaoyuanxinwen"));
        return R.ok().put("data", discussxiaoyuanxinwenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen){
        EntityWrapper< DiscussxiaoyuanxinwenEntity> ew = new EntityWrapper< DiscussxiaoyuanxinwenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxiaoyuanxinwen, "discussxiaoyuanxinwen"));
		DiscussxiaoyuanxinwenView discussxiaoyuanxinwenView =  discussxiaoyuanxinwenService.selectView(ew);
		return R.ok("查询校园新闻评论表成功").put("data", discussxiaoyuanxinwenView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen = discussxiaoyuanxinwenService.selectById(id);
        return R.ok().put("data", discussxiaoyuanxinwen);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen = discussxiaoyuanxinwenService.selectById(id);
        return R.ok().put("data", discussxiaoyuanxinwen);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen, HttpServletRequest request){
    	discussxiaoyuanxinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiaoyuanxinwen);
        discussxiaoyuanxinwenService.insert(discussxiaoyuanxinwen);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen, HttpServletRequest request){
    	discussxiaoyuanxinwen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxiaoyuanxinwen);
        discussxiaoyuanxinwenService.insert(discussxiaoyuanxinwen);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody DiscussxiaoyuanxinwenEntity discussxiaoyuanxinwen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxiaoyuanxinwen);
        discussxiaoyuanxinwenService.updateById(discussxiaoyuanxinwen);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxiaoyuanxinwenService.deleteBatchIds(Arrays.asList(ids));
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

		Wrapper<DiscussxiaoyuanxinwenEntity> wrapper = new EntityWrapper<DiscussxiaoyuanxinwenEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = discussxiaoyuanxinwenService.selectCount(wrapper);
		return R.ok().put("count", count);
	}



}
