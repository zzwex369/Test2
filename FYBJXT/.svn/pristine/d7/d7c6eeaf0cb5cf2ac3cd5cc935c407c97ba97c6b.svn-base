package com.xyw.medical.jsywh.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.jsywh.dao.JsywhDao;
import com.xyw.medical.jsywh.model.S30109Request;
import com.xyw.medical.jsywh.model.S30109Response;
import com.xyw.medical.jsywh.service.JsywhService;

@Transactional
public class JsywhServiceImpl implements JsywhService {
	@Resource
	private JsywhDao jsywhDao;
	
	public S30109Response query(S30109Request s30109Request){
		
		S30109Response s30109Response=jsywhDao.find(s30109Request);
		
		return s30109Response;
	}
    public S30109Response add(S30109Request s30109Request){
		
		S30109Response s30109Response=jsywhDao.save(s30109Request);
		
		return s30109Response;
	}
    public S30109Response remove(S30109Request s30109Request){
		
		S30109Response s30109Response=jsywhDao.del(s30109Request);
		
		return s30109Response;
	}
    public S30109Response modify(S30109Request s30109Request){
		
		S30109Response s30109Response=jsywhDao.update(s30109Request);
		
		return s30109Response;
	}

}
