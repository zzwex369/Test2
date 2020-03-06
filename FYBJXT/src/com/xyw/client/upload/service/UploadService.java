package com.xyw.client.upload.service;

import java.util.List;

import com.xyw.client.upload.model.UploadRequest;
import com.xyw.client.upload.model.UploadResponse;
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.model.VD304;
import com.xyw.medical.birth.model.VD305;
import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.model.VD501;
import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.model.VD601;

public interface UploadService {
	public UploadResponse pagerFp(UploadRequest uploadRequest);
	public UploadResponse pagerRk(UploadRequest uploadRequest);
	public UploadResponse pagerFm(UploadRequest uploadRequest);
	public UploadResponse pagerSfb(UploadRequest uploadRequest);
	public UploadResponse pagerDj(UploadRequest uploadRequest);
	public UploadResponse pagerBfb(UploadRequest uploadRequest);
	public UploadResponse pagerFz(UploadRequest uploadRequest);
	public UploadResponse pagerFzcl(UploadRequest uploadRequest);
	
	public UploadResponse uploadFp(VD501 vd501);
	public UploadResponse uploadRk(VD502 vd502);
	public UploadResponse uploadFm(VD601 vd601);
	public UploadResponse uploadSfb(VD304 vd304);
	public UploadResponse uploadDj(VD301 vd301);
	public UploadResponse uploadBfb(VD305 vd305);
	public UploadResponse uploadFz(VD401 vd401);
	public UploadResponse uploadFzcl(VD401 vd401);
	
	public UploadResponse uploadRks(List<VD502> vd502s);
	public UploadResponse uploadFms(List<VD601> vd601s);
	public UploadResponse uploadSfbs(List<VD304> vd304s);
	public UploadResponse uploadDjs(List<VD301> vd301s);
	public UploadResponse uploadBfbs(List<VD305> vd305s);
	public UploadResponse uploadZfs(List<VD401> vd401s);
	
}
