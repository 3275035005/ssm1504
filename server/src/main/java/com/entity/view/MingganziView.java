package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.MingganziEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 敏感字
 */
@TableName("mingganzi")
public class MingganziView extends MingganziEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MingganziView(){
	}

 	public MingganziView(MingganziEntity yonghuEntity){
 	try {
			BeanUtils.copyProperties(this, yonghuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
