package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.DiscussxiaoyuanxinwenEntity;
import com.entity.view.DiscussxiaoyuanxinwenView;
import com.entity.vo.DiscussxiaoyuanxinwenVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 校园新闻评论表
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:48
 */
public interface DiscussxiaoyuanxinwenService extends IService<DiscussxiaoyuanxinwenEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<DiscussxiaoyuanxinwenVO> selectListVO(Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

   	DiscussxiaoyuanxinwenVO selectVO(@Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

   	List<DiscussxiaoyuanxinwenView> selectListView(Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

   	DiscussxiaoyuanxinwenView selectView(@Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

}

