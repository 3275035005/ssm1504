package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.XiaoyuanxinwenEntity;
import com.entity.view.XiaoyuanxinwenView;
import com.entity.vo.XiaoyuanxinwenVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 校园新闻
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:48
 */
public interface XiaoyuanxinwenDao extends BaseMapper<XiaoyuanxinwenEntity> {

	List<XiaoyuanxinwenVO> selectListVO(@Param("ew") Wrapper<XiaoyuanxinwenEntity> wrapper);

	XiaoyuanxinwenVO selectVO(@Param("ew") Wrapper<XiaoyuanxinwenEntity> wrapper);

	List<XiaoyuanxinwenView> selectListView(@Param("ew") Wrapper<XiaoyuanxinwenEntity> wrapper);

	List<XiaoyuanxinwenView> selectListView(Pagination page, @Param("ew") Wrapper<XiaoyuanxinwenEntity> wrapper);

	XiaoyuanxinwenView selectView(@Param("ew") Wrapper<XiaoyuanxinwenEntity> wrapper);

}
