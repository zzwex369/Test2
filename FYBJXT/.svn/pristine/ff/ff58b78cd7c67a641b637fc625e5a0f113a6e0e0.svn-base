package com.xyw.client.fybj.upload.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.fybj.upload.model.FybjUploadRequest;
import com.xyw.client.fybj.upload.model.FybjUploadResponse;
import com.xyw.medical.etbj.model.VE601;

@Transactional
public interface FybjUploadService {
	//查询
	public FybjUploadResponse pagerLb(FybjUploadRequest fybjUploadRequest);
	//单个上传
	public FybjUploadResponse uploadLb(VE601 ve601);
	//批量上传
	public FybjUploadResponse uploadLbs(List<VE601> ve601s);

}
