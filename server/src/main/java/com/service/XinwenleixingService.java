package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.XinwenleixingEntity;
import com.entity.view.XinwenleixingView;
import com.entity.vo.XinwenleixingVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 新闻类型
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:47
 */
public interface XinwenleixingService extends IService<XinwenleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<XinwenleixingVO> selectListVO(Wrapper<XinwenleixingEntity> wrapper);

   	XinwenleixingVO selectVO(@Param("ew") Wrapper<XinwenleixingEntity> wrapper);

   	List<XinwenleixingView> selectListView(Wrapper<XinwenleixingEntity> wrapper);

   	XinwenleixingView selectView(@Param("ew") Wrapper<XinwenleixingEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<XinwenleixingEntity> wrapper);

}

