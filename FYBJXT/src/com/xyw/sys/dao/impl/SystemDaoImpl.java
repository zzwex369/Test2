package com.xyw.sys.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import net.coobird.thumbnailator.Thumbnails;
import nl.bitwalker.useragentutils.Browser;
import nl.bitwalker.useragentutils.OperatingSystem;
import nl.bitwalker.useragentutils.UserAgent;
import nl.bitwalker.useragentutils.Version;
import oracle.jdbc.OracleTypes;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyw.softkey.SM2SM3;
import com.xyw.sys.annotation.VerifySession;
import com.xyw.sys.dao.SystemDao;
import com.xyw.sys.flex.session.context.AMFContext;
import com.xyw.sys.model.AreaRequest;
import com.xyw.sys.model.AreaResponse;
import com.xyw.sys.model.AssistRequest;
import com.xyw.sys.model.AssistResponse;
import com.xyw.sys.model.ComboBoxData;
import com.xyw.sys.model.ComboBoxDataRequest;
import com.xyw.sys.model.ComboBoxDataResponse;
import com.xyw.sys.model.D801;
import com.xyw.sys.model.D802;
import com.xyw.sys.model.D804;
import com.xyw.sys.model.D804Request;
import com.xyw.sys.model.D804Response;
import com.xyw.sys.model.D805;
import com.xyw.sys.model.D806;
import com.xyw.sys.model.D807;
import com.xyw.sys.model.InstitutionRequest;
import com.xyw.sys.model.InstitutionResponse;
import com.xyw.sys.model.LoginRequest;
import com.xyw.sys.model.LoginResponse;
import com.xyw.sys.model.MessageResponse;
import com.xyw.sys.model.PicDataRequest;
import com.xyw.sys.model.PicDataResponse;
import com.xyw.sys.model.RolePrivilegeRequest;
import com.xyw.sys.model.RolePrivilegeResponse;
import com.xyw.sys.model.SKLoginRequest;
import com.xyw.sys.model.SKLoginResponse;
import com.xyw.sys.model.ServiceDateRequest;
import com.xyw.sys.model.ServiceDateResponse;
import com.xyw.sys.model.SysView02;
import com.xyw.sys.model.SysView02Request;
import com.xyw.sys.model.SysView02Response;
import com.xyw.sys.model.SystemUser;
import com.xyw.sys.util.AddressUtil;
import com.xyw.sys.util.IpUtils;
import com.xyw.sys.util.StringUtil;

public class SystemDaoImpl implements SystemDao {

	@Resource
	private SessionFactory sessionFactory;

	@Resource
	private DataSource dataSource;

	private StringBuffer sql = null;
	private StringBuffer promptMessage = null;
	private StringBuffer errorMessage = null;

	private LoginResponse loginResponse = null;
	private AreaResponse areaResponse = null;

	private List<Integer> ints;
	private static final Logger log = LoggerFactory.getLogger(SystemDaoImpl.class);
	/**
	 * 验证信息
	 * 
	 * @return
	 */
	private Object[] verifySK(String[][] param, SQLQuery sqlQuery) {
		String errMessage = null;// 错误信息
		for (int i = 0; i < param.length; i++) {
			if (!StringUtil.isBlankString(param[i][0])) {
				sqlQuery.setString(0, param[i][0]);
			} else {
				errMessage = param[i][1];
			}
		}

		return new Object[] { errMessage, sqlQuery };
	}

	@Override
	public SKLoginResponse verifySoftKey(SKLoginRequest loginRequest) {
		String errMessage = null;// 错误信息
		boolean state = false;
		SKLoginResponse loginResponse = new SKLoginResponse();
		Session session = sessionFactory.getCurrentSession();

		String name = loginRequest.getName();
		String pwd = loginRequest.getPwd();
		String skID = loginRequest.getSKID();// 加密狗id
		String ranTime = loginRequest.getRanTime();// 加密狗随机数
		String permission = loginRequest.getPermission();
		String clientResult = loginRequest.getClientResult();// 客户端加密结果

		this.sql = new StringBuffer(
				"select d801_02,d801_29,d801_30,d801_31 from d801 where  d801_23 = ? and d801_24 = ? and d801_27 = ?");
		SQLQuery sqlQuery = session.createSQLQuery(this.sql.toString());
		Object[] result = verifySK(new String[][] { { name, "用户名无效!" },
				{ pwd, "密码无效!" }, { skID, "加密狗ID无效!" } }, sqlQuery);
		errMessage = result[0].toString();
		sqlQuery = (SQLQuery) result[1];
		List<String[]> d801List = null;
		try {
			d801List = (List<String[]>) sqlQuery.list();
			if (d801List.size() == 0)
				errMessage = "非法加密狗!";
			else
				state = true;

		} catch (HibernateException e) {
			errMessage = "系统异常!";
		}

		if (state) {
			String[] resultStrings = (String[]) d801List.get(0);
			String d80102 = resultStrings[0]; // 用户名
			String d80129 = resultStrings[1]; // 加密狗公钥X
			String d80130 = resultStrings[2]; // 加密狗公钥Y
			String d80131 = resultStrings[3]; // 加密狗用户身份

			try {
				if (new SM2SM3().YtVerfiy(d80131, ranTime, d80129, d80130,
						clientResult)) {
					loginResponse.setName(d80102);
					loginResponse.setPromptMessage("该用户是合法用户！");
				} else {
					state = false;
					errMessage = "该加密狗用户不是合法用户";
				}
			} catch (Exception e) {
				e.printStackTrace();
				state = false;
				errMessage = "验证加密狗发生异常！";
			}

		}
		loginResponse.setStates(state);
		loginResponse.setErrorMessage(errMessage);
		return loginResponse;
	}
	
	private LoginResponse  setErrorMessage(String error) {
		loginResponse.setErrorMessage(error);
		return loginResponse;
	}

	@Override
	@VerifySession
	@SuppressWarnings("unchecked")
	public LoginResponse systemLogin(LoginRequest loginRequest) {
		this.errorMessage = new StringBuffer();// 错误信息
		this.promptMessage = new StringBuffer();// 提示信息
		loginResponse = new LoginResponse();
		Session session = sessionFactory.getCurrentSession();

		String time = loginRequest.getModifyTime();
		String username = loginRequest.getUsername();
		String password = loginRequest.getPassword();
		String quanxian = loginRequest.getQuanxian();
		//0 是否提示强制更新  1强制更新字符串
		Object  c101= session.createSQLQuery("select c101_14 from " +
						"c101 t where c101_01>6 and c101_12='1' and c101_02=?")
						.setParameter(0, quanxian).uniqueResult();
		if(c101!=null){
			if(!c101.equals(time))
				return setErrorMessage("当前登录的系统不是最新版本，\n请清理浏览器缓存!\n" +
				"清除浏览器缓存方法参考网址:\nhttps://jingyan.baidu.com/article/8065f87fc59f1723312498f1.html");
		}
		
		this.sql = new StringBuffer(
				"select t.* from sys_view_01_backup t where t.d801_02 = ? and t.d801_03 = ?");
		SQLQuery sqlQuery = session.createSQLQuery(this.sql.toString());
		if (!StringUtil.isBlankString(username)) {
			sqlQuery.setString(0, username);
		} else 
			return setErrorMessage("用户名无效!");
		
		if (!StringUtil.isBlankString(password)) {
			sqlQuery.setString(1, password);
		} else 
			return setErrorMessage("密码无效!");

		List<Object[]> d801List;
		try {
			d801List = (List<Object[]>) sqlQuery.list();
		} catch (HibernateException e) {
			return setErrorMessage("系统异常!");
		}

		if (d801List.size() > 1) 
			return setErrorMessage("账户异常!");
		 else if (d801List.size() == 0) 
			return setErrorMessage("用户名或密码不正确!");
		
		SystemUser systemUser = new SystemUser();
		Object[] resultStrings = (Object[]) d801List.get(0);
		String d801_01 = (String) resultStrings[0]; // 用户编码
		String d801_03 = (String) resultStrings[2]; // 密码
		String d101_04 = (String) resultStrings[3]; // 地区编码
		String d101_02 = (String) resultStrings[4]; // 机构名称
		String d101_01 = (String) resultStrings[5]; // 机构编码
		String d101_05 = (String) resultStrings[6]; // 机构类型
		Date d101_12 = (Date) resultStrings[7]; // 服务到期时间
		Object d801_09Obj = resultStrings[8]; // 用户账户状态
		String d801_10 = (String) resultStrings[9]; // 新增读卡权限
		String d801_11 = (String) resultStrings[12];// 读卡器安全模块编码
		String d801_12 = (String) resultStrings[13];// 新增打印权限
		String d801_13 = (String) resultStrings[14];// 新增权限
		String d101_07 = (String) resultStrings[15];// 营业执照
		Date d801_15 = (Date) resultStrings[16]; // 用户服务到期时间
		String d801_16 = (String) resultStrings[17];// 读卡父母信息输入框 0不变；1灰色不可编辑
		// --ggz09/07
		String d801_18 = (String) resultStrings[19];// 更新公告
		String d801_19 = (String) resultStrings[20];// 修改公告权限
		String d801_20 = (String) resultStrings[21]; // 卫计委待续费
		Date d801_21 = (Date) resultStrings[22]; // 系统更新时间

		systemUser.setVerifyRc((String) resultStrings[23]);// 验证插读卡器安全模块
		systemUser.setVerifySk((String) resultStrings[24]);// 验证插入加密狗
		systemUser.setSkName((String) resultStrings[25]);// 加密狗账号
		systemUser.setSkPwd((String) resultStrings[26]);// 加密狗密码
		systemUser.setSkReplacePmn((String)resultStrings[27]);// 是否覆盖加密狗权限
		systemUser.setSkPmn((String) resultStrings[28]);// 加密狗 登录权限
		systemUser.setSkID((String) resultStrings[29]);// 加密狗ID (芯片出厂唯一ID)
		systemUser.setSkP((String) resultStrings[30]);// 加密狗公钥X
		systemUser.setSkPX((String) resultStrings[31]);// 加密狗公钥X
		systemUser.setSkPY((String) resultStrings[32]);// 加密狗公钥Y
		systemUser.setSkCard((String) resultStrings[33]);// 用户身份
		systemUser.setModifyTime((Date) resultStrings[34]);// 上次修改密码时间
		systemUser.setTimeRange((String) resultStrings[35]);// 限制修改密码间隔(小时)

		if ("9".equals(d801_13)) {
			d801_13 = quanxian;
		}
		if (!quanxian.equals(d801_13)) 
			return setErrorMessage("该账户不能登陆此系统\n，请尝试其他登录其他系统或更换账号!");

		
		if (d801_09Obj != null) {
			String d801_09 = d801_09Obj.toString();
			if (d801_09.equals("0")) 
				return setErrorMessage("该账户已注销!");
			
		} else 
			return setErrorMessage("该账户状态不正常!");
		Object[] result=getCharge(quanxian,d101_12,d801_15);
		boolean isNext=(Boolean) result[0];
		String resultStr=result[1]!=null?result[1].toString():null;
		if(isNext&&!StringUtil.isBlankString(resultStr))
			this.loginResponse.setPromptMessage(resultStr);
		else if(!isNext)
			return setErrorMessage(resultStr);
		
		StringBuffer menuXMLString = new StringBuffer("<menus>");
		String str = this.getXMLMenu(d801_01, d801_13, "0");
		if (str == null) 
			return setErrorMessage("系统异常!");
		
		List<String> permission = loadPermissionList(d801_01, d801_13);// 加载按钮权限
		menuXMLString.append(str);
		menuXMLString.append("</menus>");

		systemUser.setUsername(username);
		systemUser.setOldPassword(d801_03);
		systemUser.setUserCode(d801_01);
		systemUser.setAreaCode(d101_04);
		systemUser.setInstitution(d101_02);
		systemUser.setInstitutionCode(d101_01);
		systemUser.setInstitutionType(d101_05);
		systemUser.setDuka(d801_10);
		systemUser.setRcCode(d801_11);
		systemUser.setDayin(d801_12);
		systemUser.setButtonPermission(permission);
		systemUser.setXmlMenu(menuXMLString.toString());
		systemUser.setQuanxian(d801_13);
		systemUser.setYingye(d101_07);
		systemUser.setFumuDuka(d801_16);
		systemUser.setGonggao(d801_18);
		systemUser.setAlterNotice(d801_19);
		systemUser.setJiwei(d801_20);
		systemUser.setSysModify(d801_21);
		saveClientLogin(d801_01);
		loginResponse.setSystemUser(systemUser);
		return loginResponse;
	}

	@SuppressWarnings("unchecked")
	public List<String> loadPermissionList(String userCode, String quanxian) {
		String sqlString = "select d803.d803_03 from D803 d803 where d803.d803_01 in(select d805.d805_03 from D805 d805 where d805.d805_02 in (select d806.d806_03 from D806 d806 where d806.d806_02 = ? and d806.d806_04=?)) and d803.d803_07 = ?";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlString.toString());
		sqlQuery.setString(0, userCode);
		sqlQuery.setString(1, quanxian);
		sqlQuery.setString(2, "2");
		List<String> list = null;
		try {
			list = (List<String>) sqlQuery.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}
	
	@VerifySession
	public void saveClientLogin(String userCode) {
		Session session = sessionFactory.getCurrentSession();
		try {
			D802 d802=(D802) session.get(D802.class, userCode);
			HttpServletRequest request = AMFContext.getCurrentAMFContext().getHttpServletRequest();
			String ip=IpUtils.getIpAddr(request);
			String address [] = AddressUtil.getRealAddressByIP(ip);
			//获取浏览器信息
			String ua = request.getHeader("User-Agent");
			//转成UserAgent对象
			UserAgent userAgent = UserAgent.parseUserAgentString(ua); 
			//获取浏览器信息
			Browser browser = userAgent.getBrowser();  
			
			Version version=userAgent.getBrowserVersion();
			//获取系统信息
			OperatingSystem os = userAgent.getOperatingSystem();
			//系统名称
			String system = os.getName();
			//浏览器名称
			String browserName = browser.getName();
			d802.setD80202(userAgent!=null?userAgent.toString():null);
			d802.setD80203(address[1]);
			d802.setD80204(ip);
			d802.setD80205(address[0]);
			d802.setD80206(system);
			d802.setD80207(version!=null?version.getVersion():null);
			d802.setD80208(browserName);
			d802.setD80211(d802.getD80209());
			d802.setD80209(new Date());
			session.update(d802);
			session.flush();
			session.refresh(d802);
		} catch (Exception e) {
			log.error("saveClientLogin"+userCode,e);
		}
	}
	

	@SuppressWarnings("unchecked")
	public String getXMLMenu(String userCode, String quanxian,
			String parentMenuId) {
		// String sqlString =
		// "select d803.d803_01, d803.d803_02, d803.d803_03, d803.d803_04, d803.d803_05, d803.d803_06 from D803 d803 where d803.d803_01 in(select d805.d805_03 from D805 d805 where d805.d805_02 in (select d806.d806_03 from D806 d806 where d806.d806_02 = ?)) and d803.d803_04 = ? order by to_number(d803.d803_06)";
		String sqlString = "select d803.d803_01, d803.d803_02, d803.d803_03, d803.d803_04, d803.d803_05, d803.d803_06 from D803 d803 where d803.d803_01 in(select d805.d805_03 from D805 d805 where d805.d805_02 in (select d806.d806_03 from D806 d806 where d806.d806_02 = ? and d806.d806_04=?)) and d803.d803_04 = ? and d803.d803_07 = ? order by to_number(d803.d803_06)";
		// String sqlString =
		// "select d802.d802_01, d802.d802_02, d802.d802_04, d802.d802_05, d802.d802_06 from D802 d802 where d802.d802_01 in(select d805.d805_03 from D805 d805 where d805.d805_02 in (select d806.d806_03 from D806 d806 where d806.d806_02 = ?)) and d802.d802_05 = ? order by d802.d802_06";
		StringBuffer xmlMenuString = new StringBuffer();
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlString.toString());
		sqlQuery.setString(0, userCode);
		sqlQuery.setString(1, quanxian);
		sqlQuery.setString(2, parentMenuId);
		sqlQuery.setString(3, "1");
		List<Object[]> levels;
		try {
			levels = (List<Object[]>) sqlQuery.list();
		} catch (HibernateException e) {
			return null;
		}
		for (int j = 0; j < levels.size(); j++) {
			Object[] levelSingleRow = levels.get(j);
			String d803_01 = levelSingleRow[0].toString();
			String d803_02 = levelSingleRow[1].toString();
			String d803_04 = levelSingleRow[2] + "";
			// String d801_05 = levelSingleRow[2].toString();
			xmlMenuString.append("<menuitem label='");
			xmlMenuString.append(d803_02);
			xmlMenuString.append("' path='");
			xmlMenuString.append(d803_04);
			xmlMenuString.append("'>");
			String str = this.getXMLMenu(userCode, quanxian, d803_01);
			xmlMenuString.append(str);
			xmlMenuString.append("</menuitem>");
		}
		String result = xmlMenuString.toString();
		return result;
	}
	
	
	@SuppressWarnings("unchecked")
	public AreaResponse getAreaComboBoxDataJS(AreaRequest areaRequest) {
		String areaCode = areaRequest.getAreaCode();
		boolean showPrompt = areaRequest.getShowPrompt();
		String areaFlag = areaRequest.getAreaFlag();
		Session session = this.sessionFactory.getCurrentSession();
		this.areaResponse = new AreaResponse();
		this.sql = new StringBuffer(
				"select t.D201_01, t.D201_04 from D201_JS t where t.D201_01 like '");

		if (!"".equals(areaCode) && showPrompt) {
			this.sql.append(areaCode);
			if (areaFlag.equals("county")) {
				this.sql.append("___");
			} else if (areaFlag.equals("town")) {
				this.sql.append("___");
			} else {
				this.sql.append("__");
			}
		} else if ("defaultValue".equals(areaCode)) {
			this.sql.append("__");
		} else {
			this.sql.append(areaCode);
			if (("city".equals(areaFlag) && areaCode.length() == 2)
					|| ("county".equals(areaFlag) && areaCode.length() == 4)) {
				this.sql.append("__");
			} else if ("town".equals(areaFlag) && areaCode.length() == 6) {
				this.sql.append("___");
			} else if ("country".equals(areaFlag) && areaCode.length() == 9) {
				this.sql.append("___");
			}
		}

		this.sql.append("'");
		SQLQuery sqlQuery = session.createSQLQuery(this.sql.toString());
		List<Object[]> list = (List<Object[]>) sqlQuery.list();
		Iterator<Object[]> iterator = list.iterator();
		List<ComboBoxData> comboBoxDataList = new ArrayList<ComboBoxData>();

		if (showPrompt) {
			ComboBoxData comboBoxDataPrompt = new ComboBoxData();
			comboBoxDataPrompt.setLabel("选择");
			comboBoxDataPrompt.setData("");
			comboBoxDataList.add(comboBoxDataPrompt);
		}
		while (iterator.hasNext()) {
			Object[] objects = iterator.next();
			ComboBoxData comboBoxData = new ComboBoxData();
			comboBoxData.setData(objects[0].toString());
			comboBoxData.setLabel(objects[1].toString());
			comboBoxDataList.add(comboBoxData);
		}
		this.areaResponse.setAreaFlag(areaFlag);
		this.areaResponse.setShowPrompt(showPrompt);
		this.areaResponse.setComboBoxDataList(comboBoxDataList);
		return this.areaResponse;
	}
	

	@SuppressWarnings("unchecked")
	public AreaResponse getAreaComboBoxData(AreaRequest areaRequest) {
		String table = areaRequest.getTable();
		String areaCode = areaRequest.getAreaCode();
		table = (table != null) ? table : "D201";
		boolean showPrompt = areaRequest.getShowPrompt();
		String areaFlag = areaRequest.getAreaFlag();
		Session session = this.sessionFactory.getCurrentSession();
		this.areaResponse = new AreaResponse();
		this.sql = new StringBuffer("select t.D201_01, t.D201_04 from " + table
				+ " t where t.D201_01 like '");

		if (!"".equals(areaCode) && showPrompt) {
			this.sql.append(areaCode);
			if (areaFlag.equals("county")) {
				this.sql.append("___");
			} else if (areaFlag.equals("town")) {
				this.sql.append("___");
			} else {
				this.sql.append("__");
			}
		} else if ("defaultValue".equals(areaCode)) {
			this.sql.append("__");
		} else {
			this.sql.append(areaCode);
			if (("city".equals(areaFlag) && areaCode.length() == 2)
					|| ("county".equals(areaFlag) && areaCode.length() == 4)) {
				this.sql.append("__");
			} else if ("town".equals(areaFlag) && areaCode.length() == 6) {
				this.sql.append("___");
			} else if ("country".equals(areaFlag) && areaCode.length() == 9) {
				this.sql.append("___");
			}
		}

		this.sql.append("' order by t.d201_01");
		SQLQuery sqlQuery = session.createSQLQuery(this.sql.toString());
		List<Object[]> list = (List<Object[]>) sqlQuery.list();
		Iterator<Object[]> iterator = list.iterator();
		List<ComboBoxData> comboBoxDataList = new ArrayList<ComboBoxData>();

		if (showPrompt) {
			ComboBoxData comboBoxDataPrompt = new ComboBoxData();
			comboBoxDataPrompt.setLabel("选择");
			comboBoxDataPrompt.setData("");
			comboBoxDataList.add(comboBoxDataPrompt);
		}
		while (iterator.hasNext()) {
			Object[] objects = iterator.next();
			ComboBoxData comboBoxData = new ComboBoxData();
			comboBoxData.setData(objects[0].toString());
			comboBoxData.setLabel(objects[1].toString());
			comboBoxDataList.add(comboBoxData);
		}
		this.areaResponse.setAreaFlag(areaFlag);
		this.areaResponse.setShowPrompt(showPrompt);
		this.areaResponse.setComboBoxDataList(comboBoxDataList);
		return this.areaResponse;
	}
	

	@SuppressWarnings("unchecked")
	public AreaResponse getAreaComboBoxDataNew(AreaRequest areaRequest) {
		String areaCode = areaRequest.getAreaCode();
		boolean showPrompt = areaRequest.getShowPrompt();
		String areaFlag = areaRequest.getAreaFlag();
		Session session = this.sessionFactory.getCurrentSession();
		this.areaResponse = new AreaResponse();
		this.sql = new StringBuffer(
				"select t.D201_01, t.D201_04 from D201_js t where t.D201_01 like '");

		if (!"".equals(areaCode) && showPrompt) {
			this.sql.append(areaCode);
			if (areaFlag.equals("county")) {
				this.sql.append("___");
			} else if (areaFlag.equals("town")) {
				this.sql.append("___");
			} else {
				this.sql.append("__");
			}
		} else if ("defaultValue".equals(areaCode)) {
			this.sql.append("__");
		} else {
			this.sql.append(areaCode);
			if (("city".equals(areaFlag) && areaCode.length() == 2)
					|| ("county".equals(areaFlag) && areaCode.length() == 4)) {
				this.sql.append("__");
			} else if ("town".equals(areaFlag) && areaCode.length() == 6) {
				this.sql.append("___");
			} else if ("country".equals(areaFlag) && areaCode.length() == 9) {
				this.sql.append("___");
			}
		}
		this.sql.append("'");
		SQLQuery sqlQuery = session.createSQLQuery(this.sql.toString());
		List<Object[]> list = (List<Object[]>) sqlQuery.list();
		Iterator<Object[]> iterator = list.iterator();
		List<ComboBoxData> comboBoxDataList = new ArrayList<ComboBoxData>();

		if (showPrompt) {
			ComboBoxData comboBoxDataPrompt = new ComboBoxData();
			comboBoxDataPrompt.setLabel("选择");
			comboBoxDataPrompt.setData("");
			comboBoxDataList.add(comboBoxDataPrompt);
		}
		while (iterator.hasNext()) {
			Object[] objects = iterator.next();
			ComboBoxData comboBoxData = new ComboBoxData();
			comboBoxData.setData(objects[0].toString());
			comboBoxData.setLabel(objects[1].toString());
			comboBoxDataList.add(comboBoxData);
		}
		this.areaResponse.setAreaFlag(areaFlag);
		this.areaResponse.setShowPrompt(showPrompt);
		this.areaResponse.setComboBoxDataList(comboBoxDataList);
		return this.areaResponse;
	}

	@Override
	@SuppressWarnings("unchecked")
	public ComboBoxDataResponse getComboBoxData(
			ComboBoxDataRequest comboBoxDataRequest) {
		String sql = comboBoxDataRequest.getSql();
		String flag = comboBoxDataRequest.getFlag();
		boolean showPrompt = comboBoxDataRequest.getShowPrompt();

		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		List<Object[]> list = (List<Object[]>) sqlQuery.list();
		Iterator<Object[]> iterator = list.iterator();
		ComboBoxDataResponse comboBoxDataResponse = new ComboBoxDataResponse();
		List<ComboBoxData> comboBoxDataList = new ArrayList<ComboBoxData>();
		if (showPrompt) {
			ComboBoxData comboBoxDataPrompt = new ComboBoxData();
			comboBoxDataPrompt.setLabel("选择");
			comboBoxDataPrompt.setData("");
			comboBoxDataList.add(comboBoxDataPrompt);
		}
		while (iterator.hasNext()) {
			Object[] results = iterator.next();
			ComboBoxData comboBoxData = new ComboBoxData();
			String data = results[0].toString();
			String label = results[1].toString();
			comboBoxData.setLabel(label);
			comboBoxData.setData(data);
			comboBoxDataList.add(comboBoxData);
		}
		comboBoxDataResponse.setComboBoxDataList(comboBoxDataList);
		comboBoxDataResponse.setFlag(flag);
		comboBoxDataResponse.setShowPrompt(showPrompt);

		return comboBoxDataResponse;
	}

	/**
	 * 修改用户名密码和加密狗密码
	 */
	@Override
	@SuppressWarnings("unchecked")
	public MessageResponse updatePassword(SystemUser systemUser) {
		MessageResponse messageResponse = new MessageResponse();
		String username = systemUser.getUsername();
		String userCode = systemUser.getUserCode();
		String oldPassword = systemUser.getOldPassword();
		String password = systemUser.getPassword();// 修改密码时的新密码
		String skID = systemUser.getSkID();
		String skName = systemUser.getSkName();
		String skPwd = systemUser.getSkPwd();// 修改密码时的新密码
		boolean modifySK = systemUser.isModifySk();
		int idx = modifySK ? 1 : 0;// 修改账号密码 0 加密狗密码 1
		Session session = this.sessionFactory.getCurrentSession();
		String[] queryParam = { "d801_02 = ? and d801_03 = ?",
				"d801_23 = ? and d801_24 = ? and d801_27 = ?" };
		String[] setPwd = { "d801_03 = ? where d801_01 = ? and d801_02 = ?",
				"d801_24 = ? where d801_23 = ? and d801_27 = ?" };
		String sqlA = "select count(t.d801_01) from sys_view_01 t where "
				+ queryParam[idx];
		SQLQuery sqlQueryA = session.createSQLQuery(sqlA);
		sqlQueryA.setString(0, modifySK ? skName : username);
		sqlQueryA.setString(1, oldPassword);
		if (modifySK)
			sqlQueryA.setString(2, skID);
		List<Object> objects = (List<Object>) sqlQueryA.list();

		int result = ((BigDecimal) objects.get(0)).intValue();
		if (result > 1 && !modifySK) {
			messageResponse.setErrorMessage("系统异常!");
			return messageResponse;
		} else if (result <= 0) {
			messageResponse.setErrorMessage("原始密码不正确!");
			return messageResponse;
		}

		String sql = "update d801 t set " + setPwd[idx];

		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, modifySK ? skPwd : password);
		sqlQuery.setString(1, modifySK ? skName : userCode);
		sqlQuery.setString(2, modifySK ? skID : username);

		int updateResult = sqlQuery.executeUpdate();

		if (updateResult <= 0) {
			messageResponse.setErrorMessage("修改密码失败!");
			return messageResponse;
		}

		messageResponse.setPromptMessage("修改密码成功!");

		return messageResponse;
	}

	@Override
	public InstitutionResponse getInstitutionLevel(
			InstitutionRequest institutionRequest) {
		String institutionCode = institutionRequest.getInstitutionCode();
		String sql = "select count(1) depth from (SELECT D101.D101_01, D101.D101_02 FROM D101 where D101.D101_01 != ? START WITH D101.D101_01 = ? CONNECT BY PRIOR D101.D101_11 = D101.D101_01)";

		InstitutionResponse institutionResponse = new InstitutionResponse();

		Session session = this.sessionFactory.getCurrentSession();

		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, institutionCode);
		sqlQuery.setString(1, institutionCode);

		Object obj = null;
		try {
			obj = sqlQuery.uniqueResult();
		} catch (HibernateException e) {
			institutionResponse.setErrorMessage("系统异常!");
			e.printStackTrace();
		}

		String depthStr = obj + "";

		int depth = Integer.valueOf(depthStr);

		String institutionFlag = String.valueOf(depth);
		institutionResponse.setInstitutionFlag(institutionFlag);

		return institutionResponse;
	}

	@Override
	public InstitutionResponse getCustomInstitutionComboBoxData(
			InstitutionRequest institutionRequest) {

		String institutionCode = institutionRequest.getInstitutionCode();
		String institutionFlag = institutionRequest.getInstitutionFlag();

		Connection connection = null;
		CallableStatement callableStatement = null;

		InstitutionResponse institutionResponse = new InstitutionResponse();
		institutionResponse.setInstitutionFlag(institutionFlag);

		List<ComboBoxData> comboBoxDataList = new ArrayList<ComboBoxData>();

		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call institution_procedure(?, ?, ?)}");
			callableStatement.setString(1, institutionCode);
			callableStatement.setString(2, institutionRequest.getFlag() + "");
			callableStatement.registerOutParameter(3, OracleTypes.CURSOR);
			callableStatement.execute();
			ResultSet resultSet = (ResultSet) callableStatement.getObject(3);

			while (resultSet.next()) {
				ComboBoxData comboBoxData = new ComboBoxData();
				String data = resultSet.getString("D101_01");
				String label = resultSet.getString("D101_02");
				comboBoxData.setLabel(label);
				comboBoxData.setData(data);
				comboBoxDataList.add(comboBoxData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		institutionResponse.setComboBoxDataList(comboBoxDataList);

		return institutionResponse;
	}

	@Override
	public AssistResponse getHelpArticleB(AssistRequest assistRequest) {
		AssistResponse assistResponse = new AssistResponse();

		String d80704 = assistRequest.getD80704();

		int parameterPageindex = assistRequest.getParameterPageindex();
		int parameterPagesize = assistRequest.getParameterPagesize();

		StringBuffer parameterConditionwhere = new StringBuffer();
		parameterConditionwhere.append(" and t.d807_04 = '");
		parameterConditionwhere.append(d80704);
		parameterConditionwhere.append("'");

		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);

			callableStatement.setString(3, "D807");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D807_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);

			assistResponse.setRowCount(rowCount);
			resultSet = (ResultSet) callableStatement.getObject(7);

			D807 d807 = null;
			List<D807> listD807 = new ArrayList<D807>();

			while (resultSet.next()) {
				long d80701 = resultSet.getLong("D807_01");
				String d80702 = resultSet.getString("D807_02");
				String d80703 = resultSet.getString("D807_03");
				Date d80705 = resultSet.getDate("D807_05");

				d807 = new D807();
				d807.setD80701(d80701);
				d807.setD80702(d80702);
				d807.setD80703(d80703);
				d807.setD80704(d80704);
				d807.setD80705(d80705);

				listD807.add(d807);
			}
			assistResponse.setListD807(listD807);
		} catch (Exception e) {
			assistResponse.setErrorMessage("查询失败");
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
				if (resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assistResponse;
	}

	@Override
	public AssistResponse setHelpArticleB(AssistRequest assistRequest) {
		AssistResponse assistResponse = new AssistResponse();
		D807 d807 = assistRequest.getD807();
		String d80702 = d807.getD80702();
		String d80704 = d807.getD80704();

		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call insert_d807_procedure(?, ?, ?)}");
			callableStatement.setString(1, d80702);
			callableStatement.setString(2, d80704);

			callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
			callableStatement.execute();

			String d80703 = callableStatement.getString(3);

			d807.setD80703(d80703);
			assistResponse.setD807(d807);

		} catch (Exception e) {
			assistResponse.setErrorMessage("保存失败!");
		} finally {
			try {
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (connection != null) {
					connection.close();
					connection = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return assistResponse;
	}

	@Override
	@SuppressWarnings("unchecked")
	public AreaResponse getCustomAreaComboBoxDataCommon(AreaRequest areaRequest) {
		String areaCode = areaRequest.getAreaCode();
		Session session = this.sessionFactory.getCurrentSession();
		this.areaResponse = new AreaResponse();
		this.sql = new StringBuffer(
				"select t.D201_01, t.D201_04 from D201 t where t.D201_02 like '");

		this.sql.append(areaCode);

		this.sql.append("%'");
		SQLQuery sqlQuery = session.createSQLQuery(this.sql.toString());
		List<Object[]> list = (List<Object[]>) sqlQuery.list();
		Iterator<Object[]> iterator = list.iterator();
		List<ComboBoxData> comboBoxDataList = new ArrayList<ComboBoxData>();

		while (iterator.hasNext()) {
			Object[] objects = iterator.next();
			ComboBoxData comboBoxData = new ComboBoxData();
			comboBoxData.setData(objects[0].toString());
			comboBoxData.setLabel(objects[1].toString());
			comboBoxDataList.add(comboBoxData);
		}
		this.areaResponse.setComboBoxDataList(comboBoxDataList);
		return this.areaResponse;
	}

	@Override
	public SysView02Response queryAccount(SysView02Request sysView02Request) {
		SysView02Response sysView02Response = new SysView02Response();

		this.promptMessage = new StringBuffer();
		this.errorMessage = new StringBuffer();
		StringBuffer parameterConditionwhere = new StringBuffer();

		int parameterPageindex = sysView02Request.getParameterPageindex();
		int parameterPagesize = sysView02Request.getParameterPagesize();

		String d801_08_p = sysView02Request.getSysView02().getD801_08();
		if (!StringUtil.isBlankString(d801_08_p)) {
			parameterConditionwhere.append(" and t.d801_08 like '");
			parameterConditionwhere.append(d801_08_p);
			parameterConditionwhere.append("%'");
		}

		List<SysView02> sysView02List = new ArrayList<SysView02>();
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;

		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);

			callableStatement.setString(3, "sys_view_02");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D801_01");

			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);

			sysView02Response.setRowCount(rowCount);
			resultSet = (ResultSet) callableStatement.getObject(7);
			SysView02 sysView02 = null;
			while (resultSet.next()) {
				sysView02 = new SysView02();
				String d801_01 = resultSet.getString("D801_01");
				String d801_02 = resultSet.getString("D801_02");
				String d801_04 = resultSet.getString("D801_04");
				String d801_06 = resultSet.getString("D801_06");
				String d801_09 = resultSet.getString("D801_09");
				String d801_07 = resultSet.getString("D801_07");
				String d801_08 = resultSet.getString("D801_08");
				String d804_02 = resultSet.getString("D804_02");
				String d806_03 = resultSet.getString("D806_03");
				String d101_02 = resultSet.getString("D101_02");
				String d101_12 = resultSet.getString("D101_12");
				String d201_05 = resultSet.getString("D201_05");

				sysView02.setD801_01(d801_01);
				sysView02.setD801_02(d801_02);
				sysView02.setD801_04(d801_04);
				sysView02.setD801_06(d801_06);
				sysView02.setD801_09(d801_09);
				sysView02.setD801_07(d801_07);
				sysView02.setD801_08(d801_08);
				sysView02.setD804_02(d804_02);
				sysView02.setD806_03(d806_03);
				sysView02.setD101_02(d101_02);
				sysView02.setD101_12(d101_12);
				sysView02.setD201_05(d201_05);
				sysView02List.add(sysView02);
			}
			sysView02Response.setSysView02List(sysView02List);
		} catch (Exception e) {
			this.errorMessage.append("查询失败");
			sysView02Response.setErrorMessage(this.errorMessage.toString());
		} finally {
			try {
				if (connection != null) {
					connection.close();
					connection = null;
				}
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				if (resultSet != null) {
					resultSet.close();
					resultSet = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysView02Response;
	}

	@Override
	public boolean updateD801(String d801_01, String flag) {

		try {
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = session
					.createSQLQuery("update D801 t set t.D801_09 = ? where t.D801_01 = ?");
			sqlQuery.setString(0, flag);
			sqlQuery.setString(1, d801_01);
			int result = sqlQuery.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteFromD806(D806 d806) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = session
					.createSQLQuery("delete from D806 t where t.D806_02 = ?");
			sqlQuery.setString(0, d806.getD806_02());
			sqlQuery.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean insertD806(D806 d806) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = session
					.createSQLQuery("insert into D806(D806_02, D806_03) values(?, ?)");
			List<ComboBoxData> d806_03s = d806.getD806_03s();
			for (ComboBoxData d806_03 : d806_03s) {
				sqlQuery.setString(0, d806.getD806_02());
				sqlQuery.setString(1, d806_03.getData());
				sqlQuery.executeUpdate();
			}

		} catch (Exception e) {
			return false;
		}
		return true;

	}

	@Override
	@SuppressWarnings("unchecked")
	public D804Response queryD804(D804Request d804Request) {
		List<D804> d804s = new ArrayList<D804>();
		D804Response d804Response = new D804Response();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = session
					.createSQLQuery("select a.d804_01,a.d804_02, b.d201_05 D804_03 from D804 a, D201 b where b.d201_01 = a.d804_03");
			List<Object[]> objs = sqlQuery.list();
			D804 d804 = null;
			for (int i = 0; i < objs.size(); i++) {
				d804 = new D804();
				Object[] objss = objs.get(i);

				int d804_01 = Integer.valueOf(objss[0] + "");
				String d804_02 = String.valueOf(objss[1] + "");
				String d804_03 = String.valueOf(objss[2] + "");

				d804.setD804_01(d804_01);
				d804.setD804_02(d804_02);
				d804.setD804_03(d804_03);

				d804s.add(d804);
			}
			d804Response.setD804s(d804s);
		} catch (Exception e) {
			d804Response.setErrorMessage("查询失败!");
		}

		return d804Response;
	}

	@Override
	public boolean deleteD805(int d805_02) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = session
					.createSQLQuery("delete from D805 where d805_02 = ?");
			sqlQuery.setInteger(0, d805_02);
			sqlQuery.executeUpdate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean insertD805(D805 d805) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			List<Integer> d805_03s = d805.getD805_03s();
			for (int i = 0; i < d805_03s.size(); i++) {
				SQLQuery sqlQuery = session
						.createSQLQuery("insert into D805 values(D805_01_SEQ.nextval, ?, ?)");
				sqlQuery.setInteger(0, d805.getD805_02());
				sqlQuery.setInteger(1, Integer.valueOf(d805_03s.get(i) + ""));
				sqlQuery.executeUpdate();
			}
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public RolePrivilegeResponse getRolePrivilege(
			RolePrivilegeRequest rolePrivilegeRequest) {

		RolePrivilegeResponse rolePrivilegeResponse = new RolePrivilegeResponse();
		int roleId = rolePrivilegeRequest.getD804_01();
		this.getRolePrivilege(roleId);

		String xmlMenuString = "<menus>" + this.roleDefaultPrivilege(0)
				+ "</menus>";
		rolePrivilegeResponse.setXmlMenuString(xmlMenuString);

		return rolePrivilegeResponse;
	}

	@SuppressWarnings("unchecked")
	public String roleDefaultPrivilege(int parentId) {

		Session session = this.sessionFactory.getCurrentSession();
		String sqlA = "select c.d803_01, c.d803_02, decode(instr(c.d803_03, '.swf', 1, 1), 0, '0', '1') d803_03, c.d803_04 from D803 c where c.d803_04 = ? order by to_number(c.d803_06)";
		SQLQuery sqlQuery = session.createSQLQuery(sqlA);
		sqlQuery.setInteger(0, parentId);
		List<Object[]> objs = sqlQuery.list();
		StringBuffer xmlMenuString = new StringBuffer();
		for (int i = 0; i < objs.size(); i++) {
			Object[] objss = objs.get(i);
			BigDecimal d803_01 = (BigDecimal) objss[0];
			String d803_02 = String.valueOf(objss[1] + "");
			String d803_03 = String.valueOf(objss[2] + "");
			// Integer d803_04 = Integer.valueOf(objss[3] + "");

			xmlMenuString.append("<menuitem label='");
			xmlMenuString.append(d803_02);
			xmlMenuString.append("' data='");
			xmlMenuString.append(d803_01);
			xmlMenuString.append("'");

			if (d803_03.equals("1")) {
				xmlMenuString.append(" leaf='1'");
				if (ints.contains(d803_01)) {
					xmlMenuString.append(" checked='1'");
				} else {
					xmlMenuString.append(" checked='0'");
				}
			} else {
				xmlMenuString.append(" leaf='0'");
				xmlMenuString.append(" checked='2'");
			}

			xmlMenuString.append(">");
			String str = this.roleDefaultPrivilege(d803_01.intValue());
			xmlMenuString.append(str);
			xmlMenuString.append("</menuitem>");

		}
		return xmlMenuString.toString();
	}

	@SuppressWarnings("unchecked")
	public void getRolePrivilege(int roleId) {
		String sqlA = "select distinct b.d805_03 from D805 b where b.d805_02 = ?";
		Session session = this.sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sqlA);
		sqlQuery.setInteger(0, roleId);
		ints = (List<Integer>) sqlQuery.list();
	}

	@Override
	public boolean setNotice(String d80101, String d80118) {
		String sql = "select t.* from D801 t where t.d801_01 = ?";
		Session session = this.sessionFactory.getCurrentSession();
		D801 d801 = (D801) session.createSQLQuery(sql).addEntity(D801.class)
				.setParameter(0, d80101).uniqueResult();
		if (d801 != null) {
			d801.setD80118(d80118);
			session.save(d801);
			session.flush();
			return true;
		}
		return false;
	}

	@Override
	public PicDataResponse changePicAttribute(PicDataRequest picDataRequest) {
		Object[] picParam = new Object[3];
		PicDataResponse picDataResponse = new PicDataResponse();
		List<HashMap<String, Object>> picByteList = picDataRequest.getPicList();// 图片字符数组集合
		List<String> picParams = picDataRequest.getPicParams();// 图片参数 0 sql条件 1
		// 缩放比例 2质量参数
		// 3图片格式
		String param = picParams.get(0);

		if (!StringUtil.isBlankString(param)) {
			Session session = this.sessionFactory.getCurrentSession();
			picParam = (Object[]) session.createSQLQuery(
					"select * from la302_00 t " + "where t.la_04='" + param
							+ "'").uniqueResult();
		} else {
			picParam[0] = picParams.get(1);
			picParam[1] = picParams.get(2);
			picParam[2] = picParams.get(3);
		}
		try {
			List<HashMap<String, Object>> resPicByteList = new ArrayList<HashMap<String, Object>>();
			for (HashMap<String, Object> picMap : picByteList) {
				// picByte 0 图片字节数组 1 图片名称 2 图片大小 3图片格式 例 .jpg 4图片类型 例 宫颈 代码 1 5
				// 图片序号
				String picName = picMap.get("name").toString();
				String picType = picParam[2].toString();
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				Thumbnails.of(
						new ByteArrayInputStream((byte[]) picMap.get("data")))
						.scale(Float.valueOf(picParam[0].toString()))
						.outputQuality(Float.valueOf(picParam[1].toString()))
						.outputFormat(picType).toOutputStream(out);
				picMap.put("name", picName.replace(picMap.get("type")
						.toString(), "." + picType));
				picMap.put("type", picType);
				picMap.put("data", out.toByteArray());
				picMap.put("size", out.toByteArray().length);
				resPicByteList.add(picMap);
			}
			picDataResponse.setPicByteList(resPicByteList);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return picDataResponse;
	}

	/**
	 * dateType 1 date 2 字符串
	 */
	@Override
	@VerifySession
	public ServiceDateResponse getServiceDate(
			ServiceDateRequest serviceDateRequest) {
		Object date = null;
		Date now = new Date();
		boolean state = false;
		ServiceDateResponse serviceDateResponse = new ServiceDateResponse();
		String dateType = serviceDateRequest.getDateType();
		try {
			if ("1".equals(dateType))
				date = now;
			else {
				String formatDateStr = serviceDateRequest.getFormatDateStr();
				formatDateStr = StringUtil.isBlankString(formatDateStr) ? "yyyy-MM-dd"
						: formatDateStr;
				date = new SimpleDateFormat(formatDateStr).format(now);
			}
			state = true;
		} catch (Exception e) {
			serviceDateResponse.setErrorMessage("系统错误，请联系客服！" + e.getMessage());
		}
		serviceDateResponse.setDate(date);
		serviceDateResponse.setState(state);
		serviceDateResponse.setDateType(dateType);
		return serviceDateResponse;
	}

	@Override
	@VerifySession
	public void exitSystem(String userCode) {
		Session session = sessionFactory.getCurrentSession();
		D802 d802=(D802) session.load(D802.class, userCode);
		d802.setD80210(new Date());
	}
/**
 * 收费提示信息
 * 
 * @param pm 权限
 * @param d101_12  服务到期时间
 * @param d801_15  用户服务到期时间
 * @return Object [] 返回参数 0 是否需要继续进行下一步(true 是  false 否) 1返回的字符串提示
 */
	private Object [] getCharge(String d80113,Date d101_12,Date d801_15){
		int pmr=Integer.parseInt(d80113);
		Object [] result={true,null};//返回参数 0 是否需要继续进行下一步 1返回的字符串提示
		if(pmr==1||pmr>5)
			return result;
		StringBuffer sb=new StringBuffer();
		long gap = 0l;
		long endTime = d101_12.getTime();
		long nowTime = new Date().getTime();
		gap = endTime - nowTime;
		gap = gap / 1000 / 60 / 60 / 24;

		long yhgap = 0l;
		long yhEndTime = d801_15.getTime();
		yhgap = yhEndTime - nowTime;
		yhgap = yhgap / 1000 / 60 / 60 / 24;//天
		boolean isAdd=false;
		//gap  d101 到期时间 差  yhgap  d801 到期时间 差 
		if(gap>10&&yhgap>10)
			return result;	
	    else if(gap<0||yhgap<0)	{
	    	isAdd=true;
	    	result[0]=false;
	    	sb.append("服务费已经到期 请缴费!请联系郑州威尔信科技有限公司缴费后使用!");
	    }
	    else if ((gap <= 10 && gap >= 0)||(yhgap <= 10 && yhgap >= 0)) {
			isAdd=true;
			sb.append("距服务费到期时间仅剩 "+(gap<yhgap?gap:yhgap)+ "天，请及时缴费!");
		}
		if(isAdd){
			sb.append("\n联系人:郭威，联系电话:15837123134。  " +
					" \n打款方式一   户名：郑州威尔信科技有限公司 \n开户行：中国民生银行郑州建设路支行 \n 账户：696679261 "
					+ "\n打款方式二   加微信转账 微信号：15837123134 \n打款方式三   支付宝：15837123134  " 
					+"\n打款后请与郭威联系15837123134  \n收费标准：");
			if(pmr==3||pmr==4)
				sb.append("乡级医院：分娩登记系统：750元 出生证系统：" +
							"750元 合计：1500元   \n县级医院：分娩登记系统：1250元 出生证系统：1250元 合计：2500元   " +
							"\n市级医院：分娩登记系统：2000元 出生证系统：2000元 合计：4000元 ");
			else if(pmr==2||pmr==5) 
				sb.append("妇保儿保：2000元");
			
		}
		result[1]=sb.toString();
		return result;
	}
	
}