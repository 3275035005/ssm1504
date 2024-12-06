package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.MingganziEntity;
import com.entity.view.MingganziView;
import com.entity.vo.MingganziVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 敏感字
 */
public interface MingganziService extends IService<MingganziEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<MingganziVO> selectListVO(Wrapper<MingganziEntity> wrapper);

   	MingganziVO selectVO(@Param("ew") Wrapper<MingganziEntity> wrapper);

   	List<MingganziView> selectListView(Wrapper<MingganziEntity> wrapper);

   	MingganziView selectView(@Param("ew") Wrapper<MingganziEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<MingganziEntity> wrapper);

}

