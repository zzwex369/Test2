package com.xyw.client.upload.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.client.upload.dao.UploadDao;
import com.xyw.client.upload.model.UploadRequest;
import com.xyw.client.upload.model.UploadResponse;
import com.xyw.client.upload.service.UploadService;
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.model.VD304;
import com.xyw.medical.birth.model.VD305;
import com.xyw.medical.birth.model.VD401;
import com.xyw.medical.birth.model.VD501;
import com.xyw.medical.birth.model.VD502;
import com.xyw.medical.birth.model.VD601;

@Transactional
public class UploadServiceImpl implements UploadService {
	
	@Resource
	private UploadDao uploadDao;
	
	@Override
	public UploadResponse uploadFp(VD501 vd501) {
		return uploadDao.uploadFp(vd501);
	}

	@Override
	public UploadResponse uploadRk(VD502 vd502) {
		return uploadDao.uploadRk(vd502);
	}

	@Override
	public UploadResponse uploadFm(VD601 vd601) {
		return uploadDao.uploadFm(vd601);
	}

	@Override
	public UploadResponse uploadSfb(VD304 vd304) {
		return uploadDao.uploadSfb(vd304);
	}

	@Override
	public UploadResponse uploadDj(VD301 vd301) {
		return uploadDao.uploadDj(vd301);
	}

	@Override
	public UploadResponse uploadBfb(VD305 vd305) {
		return uploadDao.uploadBfb(vd305);
	}

	@Override
	public UploadResponse uploadFz(VD401 vd401) {
		return uploadDao.uploadFz(vd401);
	}

	@Override
	public UploadResponse uploadFzcl(VD401 vd401) {
		return uploadDao.uploadFzcl(vd401);
	}

	@Override
	public UploadResponse pagerFp(UploadRequest uploadRequest) {
		UploadResponse uploadResponse = uploadDao.pagerFp(uploadRequest);
		return uploadResponse;
	}

	@Override
	public UploadResponse pagerRk(UploadRequest uploadRequest) {
		return uploadDao.pagerRk(uploadRequest);
	}

	@Override
	public UploadResponse pagerFm(UploadRequest uploadRequest) {
		return uploadDao.pagerFm(uploadRequest);
	}

	@Override
	public UploadResponse pagerSfb(UploadRequest uploadRequest) {
		return uploadDao.pagerSfb(uploadRequest);
	}

	@Override
	public UploadResponse pagerDj(UploadRequest uploadRequest) {
		return uploadDao.pagerDj(uploadRequest);
	}

	@Override
	public UploadResponse pagerBfb(UploadRequest uploadRequest) {
		return uploadDao.pagerBfb(uploadRequest);
	}

	@Override
	public UploadResponse pagerFz(UploadRequest uploadRequest) {
		return uploadDao.pagerFz(uploadRequest);
	}

	@Override
	public UploadResponse pagerFzcl(UploadRequest uploadRequest) {
		return uploadDao.pagerFzcl(uploadRequest);
	}

	@Override
	public UploadResponse uploadFms(List<VD601> vd601s) {
		int success = 0;
		int fail = 0;
		UploadResponse uploadResponse = new UploadResponse();
		if(vd601s != null && vd601s.size()>0){
			for(VD601 vd601: vd601s){
				uploadResponse = uploadDao.uploadFm(vd601);
				
				if(uploadResponse.getErrorMessage() != null && uploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				uploadResponse.setPromptMessage("当前共上传"+vd601s.size()+"条数据，全部成功！");
			} else {
				uploadResponse.setErrorMessage("当前共上传"+vd601s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			uploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadSfbs(List<VD304> vd304s) {
		int success = 0;
		int fail = 0;
		UploadResponse uploadResponse = new UploadResponse();
		if(vd304s != null && vd304s.size()>0){
			for(VD304 vd304: vd304s){
				uploadResponse = uploadDao.uploadSfb(vd304);
				
				if(uploadResponse.getErrorMessage() != null && uploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				uploadResponse.setPromptMessage("当前共上传"+vd304s.size()+"条数据，全部成功！");
			} else {
				uploadResponse.setErrorMessage("当前共上传"+vd304s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			uploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadDjs(List<VD301> vd301s) {
		int success = 0;
		int fail = 0;
		UploadResponse uploadResponse = new UploadResponse();
		if(vd301s != null && vd301s.size()>0){
			for(VD301 vd301: vd301s){
				uploadResponse = uploadDao.uploadDj(vd301);
				
				if(uploadResponse.getErrorMessage() != null && uploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				uploadResponse.setPromptMessage("当前共上传"+vd301s.size()+"条数据，全部成功！");
			} else {
				uploadResponse.setErrorMessage("当前共上传"+vd301s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			uploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadBfbs(List<VD305> vd305s) {
		int success = 0;
		int fail = 0;
		UploadResponse uploadResponse = new UploadResponse();
		if(vd305s != null && vd305s.size()>0){
			for(VD305 vd305: vd305s){
				uploadResponse = uploadDao.uploadBfb(vd305);
				
				if(uploadResponse.getErrorMessage() != null && uploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				uploadResponse.setPromptMessage("当前共上传"+vd305s.size()+"条数据，全部成功！");
			} else {
				uploadResponse.setErrorMessage("当前共上传"+vd305s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			uploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadRks(List<VD502> vd502s) {
		int success = 0;
		int fail = 0;
		UploadResponse uploadResponse = new UploadResponse();
		if(vd502s != null && vd502s.size()>0){
			for(VD502 vd502: vd502s){
				uploadResponse = uploadDao.uploadRk(vd502);
				
				if(uploadResponse.getErrorMessage() != null && uploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				uploadResponse.setPromptMessage("当前共上传"+vd502s.size()+"条数据，全部成功！");
			} else {
				uploadResponse.setErrorMessage("当前共上传"+vd502s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			uploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return uploadResponse;
	}

	@Override
	public UploadResponse uploadZfs(List<VD401> vd401s) {
		int success = 0;
		int fail = 0;
		UploadResponse uploadResponse = new UploadResponse();
		if(vd401s != null && vd401s.size()>0){
			for(VD401 vd401: vd401s){
				uploadResponse = uploadDao.uploadFz(vd401);
				
				if(uploadResponse.getErrorMessage() != null && uploadResponse.getErrorMessage().length()>0){
					fail ++;
				} else {
					success ++;
				}
			}
			if(fail == 0){
				uploadResponse.setPromptMessage("当前共上传"+vd401s.size()+"条数据，全部成功！");
			} else {
				uploadResponse.setErrorMessage("当前共上传"+vd401s.size()+"条数据，"+success+"条成功，"+fail+"条失败");
			}
		} else {
			uploadResponse.setErrorMessage("没有要上传的数据！");
		}
		return uploadResponse;
	}

}
