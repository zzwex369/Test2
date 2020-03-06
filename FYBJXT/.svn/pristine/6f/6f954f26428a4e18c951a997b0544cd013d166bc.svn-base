package com.xyw.medical.fnbj.fnbjwcdj.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyw.medical.fnbj.fnbjwcdj.dao.F606Dao;
import com.xyw.medical.fnbj.fnbjwcdj.service.F606Service;
import com.xyw.medical.fnbj.model.F606;
import com.xyw.medical.fnbj.model.F606Request;
import com.xyw.medical.fnbj.model.F606Response;
import com.xyw.medical.fnbj.model.Vf606s;
import com.xyw.sys.util.StringUtil;


@Service
public class F606ServiceImpl implements F606Service{

	@Autowired
	private F606Dao wcjDao;
	
	@Override
	public F606Response saveF606(F606 f606) {
		F606Response res = new F606Response();
		try {
			String f05 = f606.getF606_05();
			int i = wcjDao.findByIdFromF605(f05);
			int a = wcjDao.findByIdFromF606(f05);
			
			if(i==1||a==1) {
				res.setState(false);
				res.setErrorMessage("已经注册过了");
				return res;
			}
			
			Date date = new Date();
			f606.setF606_70(date);
			wcjDao.saveF606(f606);
			res.setState(true);
		} catch (Exception e) {
			res.setState(false);
			res.setErrorMessage("请稍后重试");
			return res;
		}
		return res;
	}

//	select count(f606_01) from F606 where 
//	select * from (select rownum r,e. * from D101 e where  rownum<=15) where r>=1
	
	@Override
	public F606Response queryf606(F606Request request) {
		F606Response res = new F606Response();
		try {
			String f606_67 = request.getF606_67();
			String f606_05 = request.getF606_05();
			String f606_03 = request.getF606_03();
			Date timeStr = request.getTimeStr();
			Date timeEnd = request.getTimeEnd();
			Integer parameterPageindex = request.getParameterPageindex();
			Integer parameterPagesize = request.getParameterPagesize();
			StringBuilder strcoun = new StringBuilder();
			strcoun.append("select count(f606_01) from F606 where ");
			StringBuilder str = new StringBuilder();
			str.append("select g.*,S301_10.s_02 vf606_02,D101.D101_02 vf606_01 from (select rownum r,e.* from F606 e where ");
			if(!StringUtil.isBlankString(f606_03)) {
				strcoun.append("f606_03='"+f606_03+"' and ");
				str.append("e.f606_03='"+f606_03+"' and ");
			}
			if(!StringUtil.isBlankString(f606_05)) {
				strcoun.append("f606_05='"+f606_05+"' and ");
				str.append("e.f606_05='"+f606_05+"' and ");
			}
			if(!StringUtil.isBlankString(f606_67)) {
				strcoun.append("f606_67 like '"+f606_67+"%' and ");
				str.append("e.f606_67 like '"+f606_67+"%' and ");
			}
			
		//	System.out.println("++++|"+timeStr);
		//	System.out.println("'++++|'"+timeEnd);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(timeStr!=null) {
				  
				String s1 = format.format(timeStr);
				strcoun.append("to_char(f606_70,'yyyy-mm-dd')>= '"+s1+"' and ");
				str.append("to_char(e.f606_70,'yyyy-mm-dd')>= '"+s1+"' and ");
			}
			if(timeEnd!=null) {
				String s2 = format.format(timeEnd);
				strcoun.append("to_char(f606_70,'yyyy-mm-dd')<= '"+s2+"' and ");
				str.append("to_char(e.f606_70,'yyyy-mm-dd')<= '"+s2+"' and ");
			}
			strcoun.append("1=1");
			//select g.*,S301_10.s_02 from (select rownum r,e.* from F606 e where to_char(e.f606_70,'yyyy-mm-dd')>= '2019-08-02' and rownum<=20) g left join S301_10 on g.f606_69=S301_10.s_01 where r>=1
// select g.*,S301_10.s_02,D101.D101_02 from (select rownum r,e.* from F606 e where to_char(e.f606_70,'yyyy-mm-dd')>= '2019-08-02' and rownum<=20) g left join S301_10 on g.f606_69=S301_10.s_01  left join D101 on g.f606_68=D101.d101_01 where r>=1

			str.append("rownum<="+(parameterPageindex+parameterPagesize-1)+")"+" g left join S301_10 on g.f606_69=S301_10.s_01  left join D101 on g.f606_67=D101.d101_01 where r>="+parameterPageindex);
			String sqlcoun = strcoun.toString();
			String sql = str.toString();
		//	System.out.println(sqlcoun);
		//	System.out.println(sql);
			long count = wcjDao.querySum(sqlcoun);
			if(count==0) {
				res.setState(true);
				res.setErrorMessage("没有数据");
				res.setRowCount(0);
				res.setVf606s(null);
				return res;
			}
			List<Vf606s> list = wcjDao.queryList(sql);
			res.setRowCount(count);
			res.setState(true);
			res.setVf606s(list);
		} catch (Exception e) {
			res.setState(false);
			res.setErrorMessage("请稍后重试");
			return res;
			
		}
		return res;
	}

	@Override
	public F606Response deletef606(F606Request request) {
	//	System.out.println("delete");
		F606Response res = new F606Response();
		try {
			String sid = request.getZhujian();
			int a = wcjDao.deletef606(sid);
			if(a==0) {
				res.setState(false);
				res.setErrorMessage("数据已经不存在");
			}else {
				res.setState(true);
			}
		} catch (Exception e) {
			res.setState(false);
			res.setErrorMessage("请稍后重试");
		}
		return res;
	}

	@Override
	public F606Response updatef606(F606 f606) {
		F606Response res = new F606Response();
		try {
			Date date = new Date();
			f606.setF606_70(date);
			wcjDao.updatef606(f606);
			res.setState(true);
		} catch (Exception e) {
			res.setState(false);
			res.setErrorMessage("请稍后重试");
		}
		return res;
	}

}
