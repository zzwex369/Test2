package com.xyw.medical.loadPicture.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xyw.medical.loadPicture.dao.PictureDao;
import com.xyw.medical.loadPicture.model.PictureMessage;
import com.xyw.medical.loadPicture.model.PictureRequest;
import com.xyw.medical.loadPicture.model.PictureResponse;
import com.xyw.medical.loadPicture.model.VPicture;
import com.xyw.medical.loadPicture.service.PictureService;

public class PictureServiceImpl implements PictureService {
	@Resource
	private PictureDao pictureDao;

	public PictureMessage save(List<Object[]> picArrays) {
		// TODO Auto-generated method stub
		return pictureDao.save(picArrays);
	}

	public PictureResponse queryVPicture(PictureRequest pictureRequest) {
		// TODO Auto-generated method stub
		return pictureDao.find(pictureRequest);
	}

	public PictureMessage queryVPictureByte(VPicture vPicture) {
		// TODO Auto-generated method stub
		return pictureDao.findById(vPicture);
	}

	public PictureMessage delbyId(VPicture vPicture) {
		// TODO Auto-generated method stub
		return pictureDao.deleteById(vPicture);
	}

	@Override
	public PictureMessage formartBMP(List<Object[]> picArrays) {
		// TODO Auto-generated method stub
		return pictureDao.formartBMP(picArrays);
	}

}
