package com.xyw.medical.loadPicture.dao;

import java.util.List;

import com.xyw.medical.loadPicture.model.PictureMessage;
import com.xyw.medical.loadPicture.model.PictureRequest;
import com.xyw.medical.loadPicture.model.PictureResponse;
import com.xyw.medical.loadPicture.model.Pictures;
import com.xyw.medical.loadPicture.model.VPicture;

public interface PictureDao {
	PictureResponse find(PictureRequest pictureRequest);
	PictureMessage save(List<Object[]> picArrays);
    PictureMessage save(List<Object[]> picArrays,String pic02);
	PictureMessage findById(VPicture vPicture);
	PictureMessage deleteById(VPicture vPicture);
	PictureMessage formartBMP(List<Object []> picArrays);

}
