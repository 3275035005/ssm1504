package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.MingganziEntity;
import com.entity.view.MingganziView;
import com.entity.vo.MingganziVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 铭感子
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:47
 */
public interface MingganziDao extends BaseMapper<MingganziEntity> {

	List<MingganziVO> selectListVO(@Param("ew") Wrapper<MingganziEntity> wrapper);

	MingganziVO selectVO(@Param("ew") Wrapper<MingganziEntity> wrapper);

	List<MingganziView> selectListView(@Param("ew") Wrapper<MingganziEntity> wrapper);

	List<MingganziView> selectListView(Pagination page, @Param("ew") Wrapper<MingganziEntity> wrapper);

	MingganziView selectView(@Param("ew") Wrapper<MingganziEntity> wrapper);

}
