package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ForumEntity;
import com.entity.view.ForumView;
import com.entity.vo.ForumVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 论坛交流
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:48
 */
public interface ForumDao extends BaseMapper<ForumEntity> {

	List<ForumVO> selectListVO(@Param("ew") Wrapper<ForumEntity> wrapper);

	ForumVO selectVO(@Param("ew") Wrapper<ForumEntity> wrapper);

	List<ForumView> selectListView(@Param("ew") Wrapper<ForumEntity> wrapper);

	List<ForumView> selectListView(Pagination page, @Param("ew") Wrapper<ForumEntity> wrapper);

	ForumView selectView(@Param("ew") Wrapper<ForumEntity> wrapper);

}
