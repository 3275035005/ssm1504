package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ForumEntity;
import com.entity.view.ForumView;
import com.entity.vo.ForumVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 论坛交流
 *
 * @author
 * @email
 * @date 2021-03-31 09:07:48
 */
public interface ForumService extends IService<ForumEntity> {

    PageUtils queryPage(Map<String, Object> params);

   	List<ForumVO> selectListVO(Wrapper<ForumEntity> wrapper);

   	ForumVO selectVO(@Param("ew") Wrapper<ForumEntity> wrapper);

   	List<ForumView> selectListView(Wrapper<ForumEntity> wrapper);

   	ForumView selectView(@Param("ew") Wrapper<ForumEntity> wrapper);

   	PageUtils queryPage(Map<String, Object> params, Wrapper<ForumEntity> wrapper);

}

