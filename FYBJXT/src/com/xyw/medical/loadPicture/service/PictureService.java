package com.xyw.medical.loadPicture.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.loadPicture.model.PictureMessage;
import com.xyw.medical.loadPicture.model.PictureRequest;
import com.xyw.medical.loadPicture.model.PictureResponse;
import com.xyw.medical.loadPicture.model.VPicture;

@Transactional
public interface PictureService {
	PictureMessage  save(List<Object[]> picArrays);

	PictureResponse queryVPicture(PictureRequest pictureRequest);

	PictureMessage queryVPictureByte(VPicture vPicture);

	PictureMessage delbyId(VPicture vPicture);

	PictureMessage formartBMP(List<Object[]> picArrays);
}
