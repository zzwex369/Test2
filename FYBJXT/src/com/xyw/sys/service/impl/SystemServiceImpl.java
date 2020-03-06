package com.xyw.sys.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.xyw.sys.constant.SystemConstant;
import com.xyw.sys.dao.SystemDao;
import com.xyw.sys.flex.session.context.AMFContext;
import com.xyw.sys.model.AreaRequest;
import com.xyw.sys.model.AreaResponse;
import com.xyw.sys.model.AssistRequest;
import com.xyw.sys.model.AssistResponse;
import com.xyw.sys.model.ComboBoxDataRequest;
import com.xyw.sys.model.ComboBoxDataResponse;
import com.xyw.sys.model.D804Request;
import com.xyw.sys.model.D804Response;
import com.xyw.sys.model.D805;
import com.xyw.sys.model.D806;
import com.xyw.sys.model.InstitutionRequest;
import com.xyw.sys.model.InstitutionResponse;
import com.xyw.sys.model.LoginRequest;
import com.xyw.sys.model.LoginResponse;
import com.xyw.sys.model.MessageResponse;
import com.xyw.sys.model.NoticeRequest;
import com.xyw.sys.model.NoticeResponse;
import com.xyw.sys.model.PicDataRequest;
import com.xyw.sys.model.PicDataResponse;
import com.xyw.sys.model.RolePrivilegeRequest;
import com.xyw.sys.model.RolePrivilegeResponse;
import com.xyw.sys.model.SKLoginRequest;
import com.xyw.sys.model.SKLoginResponse;
import com.xyw.sys.model.ServiceDateRequest;
import com.xyw.sys.model.ServiceDateResponse;
import com.xyw.sys.model.SessionException;
import com.xyw.sys.model.SysView02Request;
import com.xyw.sys.model.SysView02Response;
import com.xyw.sys.model.SystemUser;
import com.xyw.sys.service.SystemService;

import flex.messaging.FlexContext;

@Transactional(rollbackFor={Exception.class})
public class SystemServiceImpl implements SystemService{

	@Resource
	private SystemDao systemDao;
	private static final Logger log = LoggerFactory.getLogger(SystemServiceImpl.class);

	@Override
	@Transactional(readOnly = true)
	public LoginResponse login(LoginRequest loginRequest) {
		LoginResponse loginResponse = this.systemDao.systemLogin(loginRequest);
		HttpSession httpSession = AMFContext.getCurrentAMFContext().getHttpSession();
		httpSession.setMaxInactiveInterval(1800);
		httpSession.setAttribute(SystemConstant.LOGIN_USER_INFO, loginResponse.getSystemUser());
		return loginResponse;
	}

	@Override
	public AreaResponse getCustomAreaComboBoxData(AreaRequest areaRequest) {
		AreaResponse areaResponse = this.systemDao.getAreaComboBoxData(areaRequest);
		return areaResponse;	
	}
	
	@Override
	public AreaResponse getCustomAreaComboBoxDataJS(AreaRequest areaRequest) {
		AreaResponse areaResponse = this.systemDao.getAreaComboBoxDataJS(areaRequest);
		return areaResponse;	
	}
	
	@Override
	public AreaResponse getCustomAreaComboBoxDataNew(AreaRequest areaRequest) {
		AreaResponse areaResponse = this.systemDao.getAreaComboBoxDataNew(areaRequest);
		return areaResponse;	
	}
	@Override
	public ComboBoxDataResponse getComboBoxData(ComboBoxDataRequest comboBoxDataRequest) {
		ComboBoxDataResponse comboBoxDataResponse = this.systemDao.getComboBoxData(comboBoxDataRequest);
		return comboBoxDataResponse;
	}

	@Override
	public MessageResponse updatePassword(SystemUser systemUser) {
		MessageResponse messageResponse = this.systemDao.updatePassword(systemUser);
		return messageResponse;
	}

	@Override
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public MessageResponse exitSystem() {
		MessageResponse messageResponse = new MessageResponse();
		try {
			HttpSession httpSession = AMFContext.getCurrentAMFContext().getHttpSession();
			SystemUser systemUser = (SystemUser)httpSession.getAttribute(SystemConstant.LOGIN_USER_INFO);
			if(systemUser!=null)
			{
				this.systemDao.exitSystem(systemUser.getUserCode());
				httpSession.removeAttribute(SystemConstant.LOGIN_USER_INFO);
			}
			
		} catch(Exception e) {
			messageResponse.setErrorMessage("退出异常!");
		}
		return messageResponse;
	}
	
	
	@Override
	public NoticeResponse setArticleB(NoticeRequest noticeRequest) {
		NoticeResponse noticeResponse = new NoticeResponse();
		String path = FlexContext.getHttpRequest().getSession().getServletContext().getRealPath(noticeRequest.getPath());
		String fileName = noticeRequest.getFileName();
		String message = noticeRequest.getMessage();
		
		if(message != null){
			FileWriter fileWriter;
			try{
				fileWriter = new FileWriter(path + File.separator + fileName + ".pro");
				fileWriter.write(message);
				fileWriter.close();
				noticeResponse.setPromptMessage("已保存!");
			}catch(Exception e){
				noticeResponse.setErrorMessage("保存失败!");
				e.printStackTrace();
			}
		}
		
		return noticeResponse;
	}
	
	@Override
	public NoticeResponse getArticleB(NoticeRequest noticeRequest) {
		StringBuffer errorMessage = new StringBuffer();
		NoticeResponse noticeResponse = new NoticeResponse();
		String path = FlexContext.getHttpRequest().getSession().getServletContext().getRealPath(noticeRequest.getPath());
		String fileName = noticeRequest.getFileName();
		
		File file = new File(path + File.separator + fileName + ".pro");
		InputStreamReader inputStreamReader = null;
		
		try{
			inputStreamReader = new InputStreamReader(new FileInputStream(file));
		}catch(Exception e){
			errorMessage.append(e.getMessage());
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = "";
		StringBuffer message = new StringBuffer("");
		try{
			while((line = bufferedReader.readLine()) != null){
				message.append(line);
			}
		}catch(Exception e){
			errorMessage.append(e.getMessage());
			e.printStackTrace();
		}
		noticeResponse.setErrorMessage(fileName);
		noticeResponse.setMessage(message.toString());
		return noticeResponse;
	}
	
	@Override
	public NoticeResponse getHelpArticleA(AssistRequest assistRequest) {
		StringBuffer errorMessage = new StringBuffer();
		NoticeResponse noticeResponse = new NoticeResponse();
		String path = FlexContext.getHttpRequest().getSession().getServletContext().getRealPath(assistRequest.getPath());
		String fileName = assistRequest.getFileName();
		
		File file = new File(path + File.separator +  fileName + ".pro");
		InputStreamReader inputStreamReader = null;
		try {
			inputStreamReader = new InputStreamReader(new FileInputStream(file));
		} catch (Exception e) {
			errorMessage.append(e.getMessage());
			e.printStackTrace();
		}
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String line = "";
		StringBuffer message = new StringBuffer("");
		try {
			while((line = bufferedReader.readLine()) != null)
			{
				message.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage.append(e.getMessage());
		}
		noticeResponse.setErrorMessage(errorMessage.toString());
		noticeResponse.setMessage(message.toString());
		
		return noticeResponse;
	}
	
	@Override
	public InstitutionResponse getInstitutionLevel(InstitutionRequest institutionRequest) {
		InstitutionResponse institutionResponse = this.systemDao.getInstitutionLevel(institutionRequest);
		return institutionResponse;
	}
	
	@Override
	public InstitutionResponse getCustomInstitutionComboBoxData(InstitutionRequest institutionRequest) {
		InstitutionResponse institutionResponse = this.systemDao.getCustomInstitutionComboBoxData(institutionRequest);
		return institutionResponse;
	}

	@Override
	public InstitutionResponse getCustomInstitutionComboBoxDataCounty(InstitutionRequest institutionRequest) {
		InstitutionResponse institutionResponse = this.systemDao.getCustomInstitutionComboBoxData(institutionRequest);
		return institutionResponse;
	}

	@Override
	public InstitutionResponse getCustomInstitutionComboBoxDataTown(InstitutionRequest institutionRequest) {
		InstitutionResponse institutionResponse = this.systemDao.getCustomInstitutionComboBoxData(institutionRequest);
		return institutionResponse;
	}

	
	@Override
	public AssistResponse getHelpArticleB(AssistRequest assistRequest) {
		AssistResponse assistResponse = this.systemDao.getHelpArticleB(assistRequest);
		return assistResponse;
	}
	
	@Override
	public AssistResponse setHelpArticleB(AssistRequest assistRequest) {
		AssistResponse assistResponse = this.systemDao.setHelpArticleB(assistRequest);
		NoticeRequest noticeRequest = new NoticeRequest();
		NoticeResponse noticeResponse = new NoticeResponse();
		if(assistResponse.getErrorMessage() == null)
		{
			noticeRequest.setFileName(assistResponse.getD807().getD80703());
			noticeRequest.setPath(assistRequest.getPath());
			noticeRequest.setMessage(assistRequest.getMessage());
			noticeResponse = this.setArticleB(noticeRequest);
			assistResponse.setPromptMessage(noticeResponse.getPromptMessage());
			assistResponse.setErrorMessage(noticeResponse.getErrorMessage());
		}
		return assistResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public AreaResponse getCustomAreaComboBoxDataCommon(AreaRequest areaRequest) {
		AreaResponse areaResponse = this.systemDao.getCustomAreaComboBoxDataCommon(areaRequest);
		return areaResponse;
	}

	@Override
	@Transactional(readOnly = true)
	public SysView02Response getAccount(SysView02Request sysView02Request) {
		SysView02Response sysView02Response = this.systemDao.queryAccount(sysView02Request);
		return sysView02Response;
	}

	@Override
	public boolean modifyAccountState(String d801_01, String flag) {
		boolean result = this.systemDao.updateD801(d801_01, flag);
		return result;
	}

	@Override
	public boolean grantRole(D806 d806) {
		boolean flagA = this.systemDao.deleteFromD806(d806);
		boolean flagB = this.systemDao.insertD806(d806);
		if(flagA && flagB) {
			return true;
		}
		return false;
	}

	@Override
	public D804Response getRoles(D804Request d804Request) {
		D804Response d804Response = this.systemDao.queryD804(d804Request);
		return d804Response;
	}

	@Override
	public boolean addPrivilegeToRole(D805 d805) {
		boolean resultA = this.systemDao.deleteD805(d805.getD805_02());
		boolean resultB = this.systemDao.insertD805(d805);
		
		if(resultA && resultB) {
			return true;
		} else {
			return false;
		}		
	}

	@Override
	public RolePrivilegeResponse getRolePrivilege(RolePrivilegeRequest rolePrivilegeRequest) {
		RolePrivilegeResponse rolePrivilegeResponse = this.systemDao.getRolePrivilege(rolePrivilegeRequest);
		return rolePrivilegeResponse;
	}
	@Override
	public boolean setNotice(String d80101,String d80118) {
		return this.systemDao.setNotice(d80101,d80118);
	}

	@Override
	public PicDataResponse changePicAttribute(PicDataRequest picDataRequest) {
		return this.systemDao.changePicAttribute( picDataRequest);
	}

	@Override
	public ServiceDateResponse getServiceDate(
			ServiceDateRequest serviceDateRequest) {
		return this.systemDao.getServiceDate(serviceDateRequest);
	}

	@Override
	public SKLoginResponse verifySoftKey(SKLoginRequest loginRequest) {
		return this.systemDao.verifySoftKey(loginRequest);
	}

	@Override
	public void saveLogError(SessionException e) {
		log.error("错误代码\n"+e.getErrorCode());
		log.error("错误信息\n"+e.getErrorMessage());
	}

}
