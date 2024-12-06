package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.DiscussxiaoyuanxinwenEntity;
import com.entity.view.DiscussxiaoyuanxinwenView;
import com.entity.vo.DiscussxiaoyuanxinwenVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 校园新闻评论表
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:48
 */
public interface DiscussxiaoyuanxinwenDao extends BaseMapper<DiscussxiaoyuanxinwenEntity> {

	List<DiscussxiaoyuanxinwenVO> selectListVO(@Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

	DiscussxiaoyuanxinwenVO selectVO(@Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

	List<DiscussxiaoyuanxinwenView> selectListView(@Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

	List<DiscussxiaoyuanxinwenView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

	DiscussxiaoyuanxinwenView selectView(@Param("ew") Wrapper<DiscussxiaoyuanxinwenEntity> wrapper);

}
