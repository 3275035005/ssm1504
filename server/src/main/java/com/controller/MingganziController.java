package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.MingganziEntity;
import com.entity.view.MingganziView;
import com.service.MingganziService;
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
 * 敏感字管理
 */
@RestController
@RequestMapping("/mingganzi")
public class MingganziController {
    @Autowired
    private MingganziService mingganziService;



    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MingganziEntity mingganzi,
		HttpServletRequest request){
        EntityWrapper<MingganziEntity> ew = new EntityWrapper<MingganziEntity>();
		PageUtils page = mingganziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingganzi), params), params));

        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MingganziEntity mingganzi, HttpServletRequest request){
        EntityWrapper<MingganziEntity> ew = new EntityWrapper<MingganziEntity>();
		PageUtils page = mingganziService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mingganzi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MingganziEntity mingganzi){
       	EntityWrapper<MingganziEntity> ew = new EntityWrapper<MingganziEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mingganzi, "mingganzi"));
        return R.ok().put("data", mingganziService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MingganziEntity mingganzi){
        EntityWrapper< MingganziEntity> ew = new EntityWrapper< MingganziEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mingganzi, "mingganzi"));
		MingganziView mingganziView =  mingganziService.selectView(ew);
		return R.ok("查询新闻类型成功").put("data", mingganziView);
    }

    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MingganziEntity mingganzi = mingganziService.selectById(id);
        return R.ok().put("data", mingganzi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MingganziEntity mingganzi = mingganziService.selectById(id);
        return R.ok().put("data", mingganzi);
    }




    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MingganziEntity mingganzi, HttpServletRequest request){
    	mingganzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mingganzi);
        mingganziService.insert(mingganzi);
        return R.ok();
    }

    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MingganziEntity mingganzi, HttpServletRequest request){
    	mingganzi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mingganzi);
        mingganziService.insert(mingganzi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MingganziEntity mingganzi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mingganzi);
        mingganziService.updateById(mingganzi);//全部更新
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mingganziService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


}
