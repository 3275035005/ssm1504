package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.MingganziDao;
import com.entity.MingganziEntity;
import com.entity.view.MingganziView;
import com.entity.vo.MingganziVO;
import com.service.MingganziService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("mingganziService")
public class MingganziServiceImpl extends ServiceImpl<MingganziDao, MingganziEntity> implements MingganziService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MingganziEntity> page = this.selectPage(
                new Query<MingganziEntity>(params).getPage(),
                new EntityWrapper<MingganziEntity>()
        );
        return new PageUtils(page);
    }

    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MingganziEntity> wrapper) {
		  Page<MingganziView> page =new Query<MingganziView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    @Override
	public List<MingganziVO> selectListVO(Wrapper<MingganziEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}

	@Override
	public MingganziVO selectVO(Wrapper<MingganziEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}

	@Override
	public List<MingganziView> selectListView(Wrapper<MingganziEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MingganziView selectView(Wrapper<MingganziEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
