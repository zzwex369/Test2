package com.xyw.client.fybj.upload.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.xyw.client.fybj.upload.dao.FybjUploadDao;
import com.xyw.client.fybj.upload.model.FybjUploadRequest;
import com.xyw.client.fybj.upload.model.FybjUploadResponse;
import com.xyw.client.fybj.upload.service.FybjUploadService;
import com.xyw.medical.etbj.model.VE601;

public class FybjUploadServiceImpl implements FybjUploadService {

	@Resource
	private FybjUploadDao fybjUploadDao;
	
	@Override
	public FybjUploadResponse pagerLb(FybjUploadRequest fybjUploadRequest) {
		return fybjUploadDao.pagerLb(fybjUploadRequest);
	}

	@Override
	public FybjUploadResponse uploadLb(VE601 ve601) {
		return fybjUploadDao.uploadLb(ve601);
	}

	@Override
	public FybjUploadResponse uploadLbs(List<VE601> ve601s) {
		int success = 0;
		int fail = 0;
		FybjUploadResponse fybjUploadResponse = new FybjUploadResponse();
		if(ve601s != null && ve601s.size()>0){
			for(VE601 ve601: ve601s){
				fybjUploadResponse = fybjUploadDao.uploadLb(ve601);
				
				if(fybjUploadResponse.getErrorMessage() != null && fybjUploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				fybjUploadResponse.setPromptMessage("当前共上传"+ve601s.size()+"条数据，全部成功！");
			} else {
				fybjUploadResponse.setErrorMessage("当前共上传"+ve601s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			fybjUploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return fybjUploadResponse;
	}

}
