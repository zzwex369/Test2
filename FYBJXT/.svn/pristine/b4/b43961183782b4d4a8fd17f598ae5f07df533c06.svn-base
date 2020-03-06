package com.xyw.medical.birth.certificate.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.xyw.medical.birth.certificate.dao.BirthCertificateDao;
import com.xyw.medical.birth.model.D301;
import com.xyw.medical.birth.model.D302;
import com.xyw.medical.birth.model.D303;
import com.xyw.medical.birth.model.D304;
import com.xyw.medical.birth.model.D305;
import com.xyw.medical.birth.model.D306;
import com.xyw.medical.birth.model.D307;
import com.xyw.medical.birth.model.D601;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.VD301;
import com.xyw.medical.birth.model.VD303;
import com.xyw.medical.birth.model.VD505;
import com.xyw.sys.util.StringUtil;

public class BirthCertificateDaoImpl implements BirthCertificateDao {
	@Resource
	private SessionFactory sessionFactory;
	
	private StringBuffer hql;
    private StringBuffer errorMessage;
    
    @Resource
	private DataSource dataSource;
	
	@Override
	@SuppressWarnings("unchecked")
	public QueryBirthResponse saveBirthCertificate(D301 d301) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		this.errorMessage = new StringBuffer();
		Session session = sessionFactory.getCurrentSession();
		
		String d301_10 = d301.getD30110().trim();
		String first = d301_10.substring(0, 1);
		long d30110 = Long.valueOf(d301_10.substring(1,d301_10.length()));
		boolean state = true;
		List<Object> listD501 = null;
		//验证是否分配
		if(state)
		{
			StringBuffer sql = new StringBuffer("select t.d501_01 from d501 t where t.d501_02 = ? and t.d501_06 = ? and ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08)");
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			sqlQuery.setString(0, d301.getD30126());
			sqlQuery.setString(1, first);
			sqlQuery.setLong(2, d30110); 
			sqlQuery.setLong(3, d30110);
			
			listD501 = sqlQuery.list();
			if(listD501.size() != 1)
			{
				errorMessage.append("该证号未分配!");
				state = false;
			}
			long d30141 = Long.valueOf(listD501.get(0) + "");
			d301.setD30141(d30141);
		}
		
		//换发补发处理
/*		if("1".equals(d301.getD30142()) || "2".equals(d301.getD30142())){
			if(state){
				try {
					StringBuffer sb = new StringBuffer("select t.* from D301 t where t.d301_10 like \'" + d301.getD30152() + "\'");
					List<D301> d301s = session.createSQLQuery(sb.toString()).addEntity(D301.class).list();
					D301 d301_ = (D301)d301s.get(0);
					d301.setD30101(d301_.getD30101());
					session.clear();
				} catch (Exception e) {
					errorMessage.append("换发/补发失败!");
					e.printStackTrace();
					state = false;
				}
			}
		}*/
		//保存数据
		if(state){
			try {
				session.saveOrUpdate(d301);
			} catch (Exception e) {
				e.printStackTrace();
				errorMessage.append(e.getMessage());
				state = false;
			}
		}
		//更新d505状态
		if(state){
			String d505Sql = "update D505 t set t.D505_05 = ? ,t.D505_09 = ? where t.D505_03 = ?";
			SQLQuery query = session.createSQLQuery(d505Sql);
			if("2".equals(d301.getD30142()) || "4".equals(d301.getD30142())){
				query.setString(0, "3");
			}else if("1".equals(d301.getD30142()) || "3".equals(d301.getD30142())){
				query.setString(0, "4");
			}else if("0".equals(d301.getD30142()) || "5".equals(d301.getD30142())){
				query.setString(0, "2");
			}

			query.setString(1,new SimpleDateFormat("yyyyMMdd").format(d301.getD30128()));
			query.setString(2, d301_10);
			
			int row = query.executeUpdate();
			if(row <= 0)
			{
				errorMessage.append("状态更新失败!");
				state = false;
			}
		}

		//更新分娩登记和首发登记表
		if(state){
			if("0".equals(d301.getD30142())){    //机构内首次签发时，更新分娩登记和首发登记表;其他则不更新
				String sql="select t.d201_06 from D201 t where t.d201_01=?";
				String d30163 = d301.getD30163();
				String d30160 = d301.getD30160();
				String d30164 = d301.getD30164();
				String d30161 = d301.getD30161();
				try {
					if (d30163 !=null && !"".equals(d30163)) {
						d30163 = (String)session.createSQLQuery(sql).setParameter(0, d30163).uniqueResult();
					}
				} catch (Exception e) {
					d30163 = null;
				}
				try {
					if (d30160 !=null && !"".equals(d30160)) {
						d30160 = (String)session.createSQLQuery(sql).setParameter(0, d30160).uniqueResult();
					}
				} catch (Exception e) {
					d30160 = null;
				}
				try {
					if (d30164 !=null && !"".equals(d30164)) {
						d30164 = (String)session.createSQLQuery(sql).setParameter(0, d30164).uniqueResult();
					}
				} catch (Exception e) {
					d30164 = null;
				}
				try {
					if (d30161 !=null && !"".equals(d30161)) {
						d30161 = (String)session.createSQLQuery(sql).setParameter(0, d30161).uniqueResult();
					}
				} catch (Exception e) {
					d30161 = null;
				}
				updateD601(d301,session,d30160,d30161,d30163,d30164);
				updateD304(d301,session);
			}else if("1".equals(d301.getD30142()) || "3".equals(d301.getD30142())){  // 换发：1  换发    3  以往年度换发
				updateD306(d301,session);
			}else if("2".equals(d301.getD30142()) || "4".equals(d301.getD30142())){  //补发：2  补发     4 以往年度补发
				updateD305(d301,session);
			}else if("5".equals(d301.getD30142()) ){  // 5机构外首发
				updateD307(d301,session);
			}
		}
		
		queryBirthResponse.setErrorMessage(errorMessage.toString());
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	//更新分娩登记D601
	@SuppressWarnings("unchecked")
	public void updateD601(D301 d301,Session session,String d30160,String d30161,String d30163,String d30164){
		long d60101 = d301.getD30156();
		String d30167 =d301.getD30167();
		if(d60101 != 0){
			try{
				SQLQuery query = session.createSQLQuery("select * from D601 t where t.D601_01 = " + d60101);
				List<D601> d601s = query.addEntity(D601.class).list();
				if(d601s.size() == 1){
					D601 d601 = d601s.get(0);
					if("1".equals(d30167)){        //单亲  1父亲  2母亲
						d601.setD60172(d301.getD30116());
						d601.setD60175(d301.getD30117());
						d601.setD60177(d301.getD30119());
						d601.setD60174(d301.getD30120());
						d601.setD60187(d301.getD30135());
						d601.setD60176(d301.getD30148());
						d601.setD60198(d30161);
						d601.setD60197(d30164);
						
						d601.setD60105(d601.getD60105());
						d601.setD60165(d601.getD60165());
						d601.setD60185(d601.getD60185());
						d601.setD60109(d601.getD60109());
						d601.setD60167(d601.getD60167());
						d601.setD60186(d601.getD60186());
						d601.setD60196(d601.getD60196());
						d601.setD60195(d601.getD60195());
					}else if("2".equals(d30167)){
						d601.setD60105(d301.getD30111());
						d601.setD60165(d301.getD30112());
						d601.setD60185(d301.getD30114());
						d601.setD60109(d301.getD30115());
						d601.setD60167(d301.getD30121());
						d601.setD60186(d301.getD30134());
						d601.setD60196(d30160);
						d601.setD60195(d30163);
						
						d601.setD60172(d601.getD60172());
						d601.setD60175(d601.getD60175());
						d601.setD60177(d601.getD60177());
						d601.setD60174(d601.getD60174());
						d601.setD60187(d601.getD60187());
						d601.setD60176(d601.getD60176());
						d601.setD60198(d601.getD60198());
						d601.setD60197(d601.getD60197());
					}else{
						d601.setD60172(d301.getD30116());
						d601.setD60175(d301.getD30117());
						d601.setD60177(d301.getD30119());
						d601.setD60174(d301.getD30120());
						d601.setD60187(d301.getD30135());
						d601.setD60176(d301.getD30148());
						d601.setD60198(d30161);
						d601.setD60197(d30164);
						
						d601.setD60105(d301.getD30111());
						d601.setD60165(d301.getD30112());
						d601.setD60185(d301.getD30114());
						d601.setD60109(d301.getD30115());
						d601.setD60167(d301.getD30121());
						d601.setD60186(d301.getD30134());
						d601.setD60196(d30160);
						d601.setD60195(d30163);
					}
					d601.setD60155(d301.getD30102());
					d601.setD60140(d301.getD30103());
					d601.setD60121(d301.getD30107());
					d601.setD60144(d301.getD30108());
					d601.setD60149(d301.getD30109());
					d601.setD60156(d301.getD30110());
					
					d601.setD60102(d301.getD30124());
					d601.setD60164(d301.getD30125());
					d601.setD60157(d301.getD30126());
					d601.setD60158(d301.getD30127());
					d601.setD60160(d301.getD30128());
					d601.setD60143(d301.getD30129());
/*					try{
						//将d301里的字符类型的病历号转成long类型
						d601.setD60104(Long.getLong(d301.getD30132())); 
					}catch(Exception e){
						e.printStackTrace();
					}*/
					d601.setD60159(d301.getD30136());
					d601.setD60122(d301.getD30147());
					d601.setD60169(d301.getD30143());
					
					session.saveOrUpdate(d601);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//更新首发登记表D304
	@SuppressWarnings("unchecked")
	public void updateD304(D301 d301,Session session){
		long d30401 = d301.getD30157();//首发登记表主键
		String d30167 =d301.getD30167();
		if(d30401 != 0){
			try{
				SQLQuery query = session.createSQLQuery("select * from D304 t where t.D304_01 = " + d30401);
				List<D304> d304s = query.addEntity(D304.class).list();
				if(d304s.size() == 1){
					D304 d304 = d304s.get(0);
					if("1".equals(d30167) ){     //单亲  1父亲  2母亲
						d304.setD30422(d301.getD30116());
						d304.setD30424(d301.getD30117());
						d304.setD30435(d301.getD30118());
						d304.setD30425(d301.getD30119());
						d304.setD30426(d301.getD30120());
						d304.setD30423(d301.getD30135());
						d304.setD30427(d301.getD30148());
					}else if("2".equals(d30167)){
						d304.setD30416(d301.getD30111());
						d304.setD30418(d301.getD30112());
						d304.setD30434(d301.getD30113());
						d304.setD30419(d301.getD30114());
						d304.setD30420(d301.getD30115());
						d304.setD30421(d301.getD30121());
						d304.setD30417(d301.getD30134());
					}else{
						d304.setD30422(d301.getD30116());
						d304.setD30424(d301.getD30117());
						d304.setD30435(d301.getD30118());
						d304.setD30425(d301.getD30119());
						d304.setD30426(d301.getD30120());
						d304.setD30423(d301.getD30135());
						d304.setD30427(d301.getD30148());
						
						d304.setD30416(d301.getD30111());
						d304.setD30418(d301.getD30112());
						d304.setD30434(d301.getD30113());
						d304.setD30419(d301.getD30114());
						d304.setD30420(d301.getD30115());
						d304.setD30421(d301.getD30121());
						d304.setD30417(d301.getD30134());
					}
					d304.setD30402(d301.getD30102());
					d304.setD30403(d301.getD30103());
					d304.setD30404(d301.getD30104());
					d304.setD30405(d301.getD30105());
					d304.setD30406(d301.getD30107());
					d304.setD30408(d301.getD30108());
					d304.setD30433(d301.getD30109());
					
					d304.setD30411(d301.getD30124());
					d304.setD30412(d301.getD30125());
					d304.setD30409(d301.getD30129());
					d304.setD30410(d301.getD30132());//病历号
					d304.setD30413(d301.getD30133());
					
					d304.setD30428(d301.getD30136());
					d304.setD30429(d301.getD30137());
					d304.setD30430(d301.getD30138());
					d304.setD30431(d301.getD30139());
					try{
						d304.setD30407(Integer.parseInt(d301.getD30147()));
					}catch(Exception e){
					}
					
					d304.setD30414(d301.getD30153());
					d304.setD30415(d301.getD30154());
					
					d304.setD30445(d30167);
					session.saveOrUpdate(d304);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//更新补发登记表D305
	@SuppressWarnings("unchecked")
	public void updateD305(D301 d301,Session session){
		long d30501 = d301.getD30157();//首发登记表主键
		String d30167 =d301.getD30167();
		if(d30501 != 0){
			try{
				SQLQuery query = session.createSQLQuery("select * from D305 t where t.D305_01 = " + d30501);
				List<D305> d305s = query.addEntity(D305.class).list();
				if(d305s.size() == 1){
					D305 d305 = d305s.get(0);
					if("1".equals(d30167)){ //单亲  1父亲  2母亲
						d305.setD30522(d301.getD30116());
						d305.setD30523(d301.getD30135());
						d305.setD30524(d301.getD30117());
						d305.setD30525(d301.getD30119());
						d305.setD30526(d301.getD30120());
						d305.setD30527(d301.getD30148());
					}else if("2".equals(d30167)){
						d305.setD30516(d301.getD30111());
						d305.setD30517(d301.getD30134());
						d305.setD30518(d301.getD30112());
						d305.setD30519(d301.getD30114());
						d305.setD30520(d301.getD30115());
						d305.setD30521(d301.getD30121());
					}else{
						d305.setD30522(d301.getD30116());
						d305.setD30523(d301.getD30135());
						d305.setD30524(d301.getD30117());
						d305.setD30525(d301.getD30119());
						d305.setD30526(d301.getD30120());
						d305.setD30527(d301.getD30148());
						
						d305.setD30516(d301.getD30111());
						d305.setD30517(d301.getD30134());
						d305.setD30518(d301.getD30112());
						d305.setD30519(d301.getD30114());
						d305.setD30520(d301.getD30115());
						d305.setD30521(d301.getD30121());
					}
					d305.setD30502(d301.getD30102());
					d305.setD30503(d301.getD30103());
					d305.setD30504(d301.getD30104());
					d305.setD30505(d301.getD30105());
					d305.setD30506(d301.getD30107());
					try {
						d305.setD30507(Integer.parseInt(d301.getD30147()));
					} catch (Exception e) {
					}
					d305.setD30508(d301.getD30108());
					d305.setD30509(d301.getD30129());
					d305.setD30510(d301.getD30132());
					d305.setD30511(d301.getD30124());
					d305.setD30512(d301.getD30125());
					d305.setD30513(d301.getD30140());
					d305.setD30514(d301.getD30153());
					d305.setD30515(d301.getD30154());
					
					d305.setD30528(d301.getD30136());
					d305.setD30529(d301.getD30137());
					d305.setD30530(d301.getD30138());
					d305.setD30531(d301.getD30139());
					d305.setD30532(d301.getD30150());
					d305.setD30533(d301.getD30152());
					d305.setD30534(d301.getD30110());
					d305.setD30535(d305.getD30535());
					d305.setD30536(d301.getD30126());
					d305.setD30537(d301.getD30128());
					d305.setD30538(d305.getD30538());
					d305.setD30539(d305.getD30539());
					d305.setD30540(d305.getD30540());
					d305.setD30541(d305.getD30541());
					d305.setD30542(d301.getD30155());
					//d305.setD30543(d305.getD30543());
					//d305.setD30544(d305.getD30544());
					d305.setD30545(d30167);
					session.saveOrUpdate(d305);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//更新换发登记表D306
	@SuppressWarnings("unchecked")
	public void updateD306(D301 d301,Session session){
		long d30601 = d301.getD30157();//首发登记表主键
		String d30167 =d301.getD30167();
		if(d30601 != 0){	
			try{	
				SQLQuery query = session.createSQLQuery("select * from D306 t where t.D306_01 = " + d30601);	
				List<D306> d306s = query.addEntity(D306.class).list();
				if(d306s.size() == 1){
					D306 d306 = d306s.get(0);
					d306.setD30602(d306.getD30602());
					d306.setD30603(d306.getD30603());
					d306.setD30604(d306.getD30604());
					d306.setD30605(d306.getD30605());
					d306.setD30606(d306.getD30606());
					d306.setD30607(d306.getD30607());
					d306.setD30608(d306.getD30608());
					d306.setD30609(d306.getD30609());
					d306.setD30610(d306.getD30610());
					d306.setD30611(d306.getD30611());
					d306.setD30612(d306.getD30612());
					d306.setD30613(d301.getD30150());
					d306.setD30614(d306.getD30614());
					d306.setD30615(d306.getD30615());
					d306.setD30616(d306.getD30616());
					d306.setD30617(d306.getD30617());
					d306.setD30618(d306.getD30618());
					d306.setD30619(d306.getD30619());
					d306.setD30620(d306.getD30620());
					d306.setD30621(d306.getD30621());
					d306.setD30622(d301.getD30126());
					d306.setD30623(d301.getD30128());
					//d306.setD30624();
					//d306.setD30625();
					session.saveOrUpdate(d306);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//更新机构外登记表D307
	@SuppressWarnings("unchecked")
	public void updateD307(D301 d301,Session session){
		long d30701 = d301.getD30157();//首发登记表主键
		String d30167 =d301.getD30167();
		if(d30701 != 0){	
			try{	
				SQLQuery query = session.createSQLQuery("select * from D307 t where t.D307_01 = " + d30701);	
				List<D307> d307s = query.addEntity(D307.class).list();
				if(d307s.size() == 1){
					D307 d307 = d307s.get(0);
					if("1".equals(d30167)){ //单亲  1父亲  2母亲
						d307.setD30712(d301.getD30116());
						d307.setD30713(d301.getD30135());
						d307.setD30714(d301.getD30117());
						d307.setD30715(d301.getD30119());
						d307.setD30716(d301.getD30120());
						d307.setD30717(d301.getD30148());
					}else if("2".equals(d30167)){
						d307.setD30706(d301.getD30111());
						d307.setD30707(d301.getD30134());
						d307.setD30708(d301.getD30112());
						d307.setD30709(d301.getD30114());
						d307.setD30710(d301.getD30115());
						d307.setD30711(d301.getD30121());
					}else{
						d307.setD30712(d301.getD30116());
						d307.setD30713(d301.getD30135());
						d307.setD30714(d301.getD30117());
						d307.setD30715(d301.getD30119());
						d307.setD30716(d301.getD30120());
						d307.setD30717(d301.getD30148());
						
						d307.setD30706(d301.getD30111());
						d307.setD30707(d301.getD30134());
						d307.setD30708(d301.getD30112());
						d307.setD30709(d301.getD30114());
						d307.setD30710(d301.getD30115());
						d307.setD30711(d301.getD30121());
					}
					d307.setD30702(d301.getD30102());
					d307.setD30703(d301.getD30103());
					d307.setD30704(d301.getD30104());
					d307.setD30705(d301.getD30105());
					
					d307.setD30718(d301.getD30136());
					d307.setD30719(d301.getD30137());
					d307.setD30720(d301.getD30138());
					d307.setD30721(d301.getD30139());
					d307.setD30722(d307.getD30722());
					d307.setD30723(d301.getD30128());
					d307.setD30724(d301.getD30126());
					d307.setD30725(d307.getD30725());
					d307.setD30726(d307.getD30726());
					d307.setD30727(d307.getD30727());
					d307.setD30728(d307.getD30728());
					d307.setD30729(d307.getD30729());
					d307.setD30730(d307.getD30730());
					
					d307.setD30731(d30167);
					session.saveOrUpdate(d307);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public QueryBirthResponse validateBirth(QueryBirthRequest queryBirthRequest) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		String d30102 = queryBirthRequest.getD301_02();
		String d30110 = queryBirthRequest.getD301_10();
		String d30126 = queryBirthRequest.getD301_26();
		
		this.errorMessage = new StringBuffer();
		this.hql = new StringBuffer("from VD301 t where 1=1 ");
		if(!StringUtil.isBlankString(d30102))
		{
			this.hql.append(" and t.d30102 = '");
			this.hql.append(d30102);
			this.hql.append("'");
		}
		if(!StringUtil.isBlankString(d30110))
		{
			this.hql.append(" and t.d30110= '");
			this.hql.append(d30110);
			this.hql.append("'");
		}
		if(!StringUtil.isBlankString(d30126))
		{
			this.hql.append(" and t.d30126= '");
			this.hql.append(d30126);
			this.hql.append("'");
		}
		Query query = null;
		Session session = null;
		VD301 vd301 = null;
		try {
			session = sessionFactory.getCurrentSession();
			query = session.createQuery(this.hql.toString());
			vd301 = (VD301)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			this.errorMessage.append("查询失败!");
		}
		
		if(vd301 != null)
		{
			queryBirthResponse.setVd301(vd301);
			queryBirthResponse.setState(true);
		}else
		{
			this.errorMessage.append("证号不存在或者状态不正常!");
		}
		queryBirthResponse.setErrorMessage(this.errorMessage.toString());
		return queryBirthResponse;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public QueryBirthResponse reissueBirthCertificate(D303 d303) {
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		this.errorMessage = new StringBuffer();
		boolean state = true;
		String d303_10 = d303.getD30310();
		String first = d303_10.substring(0, 1);
		long d30310 = Long.valueOf(d303_10.substring(1,d303_10.length()));
		
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = null;
		
		if(state)
		{
			StringBuffer d501Sql = new StringBuffer("select t.d501_01 from d501 t where t.d501_02 = ? and t.d501_06 = ? and ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08)");
			
			SQLQuery sqlQuery = session.createSQLQuery(d501Sql.toString());
			
			sqlQuery.setString(0, d303.getD30326());
			sqlQuery.setString(1, first);
			sqlQuery.setLong(2, d30310);
			sqlQuery.setLong(3, d30310);
			
			list = sqlQuery.list();
			if(list.size() != 1)
			{
				errorMessage.append("该证号不在申领范围!");
				state = false;
			}
		}
		if(state)
		{
			String d303_45 = list.get(0) + "";
			long d30345 = Long.valueOf(d303_45);
			d303.setD30345(d30345);
			
			long d30101 = d303.getD30329();
			if(d30101 != 0)
			{
				String d301Sql = "update d301 t set t.d301_42 = '2' where t.d301_01 = ?";
				SQLQuery query = session.createSQLQuery(d301Sql);
				query.setLong(0, d30101);
				int row = query.executeUpdate();
				
				if(row <= 0)
				{
					errorMessage.append("补发失败!");
					state = false;
				}
			}
		}
		
		if(state)
		{
			String d505Sql = "update D505 t set t.D505_05 = '3' where t.D505_03 = ?";
			SQLQuery query = session.createSQLQuery(d505Sql);
			query.setString(0, d303_10);
			
			int row = query.executeUpdate();
			if(row <= 0)
			{
				errorMessage.append("补发失败!");
				state = false;
			}
		}
		if(state)
		{
				try {
					session.save(d303);
					session.flush();
				} catch (Exception e) {
					e.printStackTrace();
					errorMessage.append("补发失败!");
					state = false;
				}
		}
		queryBirthResponse.setErrorMessage(errorMessage.toString());
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public QueryBirthResponse renewBirthCertificate(D301 d301) {

		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		this.errorMessage = new StringBuffer();
		boolean state = true;
		String d301_10 = d301.getD30110();
		String first = d301_10.substring(0, 1);
		long d30110 = Long.valueOf(d301_10.substring(1,d301_10.length()));
		D302 d302 = new D302();
		
		Session session = sessionFactory.getCurrentSession();
		List<Object> list = null;
		
		if(state)
		{
			StringBuffer sql = new StringBuffer("select t.d501_01 from d501 t where t.d501_02 = ? and t.d501_06 = ? and ? >= to_number(t.d501_07) and ? <= to_number(t.d501_08)");
			
			SQLQuery sqlQuery = session.createSQLQuery(sql.toString());
			
			sqlQuery.setString(0, d301.getD30126());
			sqlQuery.setString(1, first);
			sqlQuery.setLong(2, d30110);
			sqlQuery.setLong(3, d30110);
			
			list = sqlQuery.list();
			if(list.size() != 1)
			{
				errorMessage.append("该证号不在申领范围!");
				state = false;
			}
		}
		if(state)
		{
			long d30141 = Long.valueOf(list.get(0) + "");
			d301.setD30141(d30141);
			try {
				StringBuffer sb = new StringBuffer("select t.* from D301 t where t.d301_10 like \'" + d301.getD30152() + "\'");
				List<D301> d301s = session.createSQLQuery(sb.toString()).addEntity(D301.class).list();
				D301 d301_ = (D301)d301s.get(0);
				d301.setD30101(d301_.getD30101());
				d301.setD30142("1");
				session.clear();
				session.saveOrUpdate(d301);
				d302.setD30202(d301_.getD30102());
				d302.setD30203(d301_.getD30103());
				d302.setD30204(d301_.getD30104());
				d302.setD30205(d301_.getD30105());
				d302.setD30206(d301_.getD30106());
				d302.setD30207(d301_.getD30107());
				d302.setD30208(d301_.getD30108());
				d302.setD30209(d301_.getD30109());
				d302.setD30210(d301_.getD30110());
				d302.setD30211(d301_.getD30111());
				d302.setD30212(d301_.getD30112());
				d302.setD30213(d301_.getD30113());
				d302.setD30214(d301_.getD30114());
				d302.setD30215(d301_.getD30115());
				d302.setD30216(d301_.getD30116());
				d302.setD30217(d301_.getD30117());
				d302.setD30218(d301_.getD30118());
				d302.setD30219(d301_.getD30119());
				d302.setD30220(d301_.getD30120());
				d302.setD30221(d301_.getD30121());
				d302.setD30222(d301_.getD30122());
				d302.setD30223(d301_.getD30123());
				d302.setD30224(d301_.getD30124());
				d302.setD30225(d301_.getD30125());
				d302.setD30226(d301_.getD30126());
				d302.setD30227(d301_.getD30127());
				d302.setD30228(d301_.getD30128());
				d302.setD30229(d301_.getD30129());
				d302.setD30230(d301_.getD30130());
				d302.setD30231(d301_.getD30131());
				d302.setD30232(d301_.getD30132());
				d302.setD30233(d301_.getD30133());
				d302.setD30234(d301_.getD30134());
				d302.setD30235(d301_.getD30135());
				d302.setD30236(d301_.getD30136());
				d302.setD30237(d301_.getD30137());
				d302.setD30238(d301_.getD30138());
				d302.setD30239(d301_.getD30139());
				d302.setD30240(d301_.getD30140());
				d302.setD30241(d301_.getD30141());
				d302.setD30242(d301_.getD30142());
				d302.setD30243(d301_.getD30143());
				d302.setD30244(d301_.getD30144());
				d302.setD30245(d301_.getD30145());
				d302.setD30246(d301_.getD30146());
				d302.setD30247(d301_.getD30147());
				d302.setD30248(d301_.getD30148());
				d302.setD30249(d301_.getD30149());
				d302.setD30250(d301_.getD30150());
				d302.setD30251(d301_.getD30151());
				d302.setD30252(d301_.getD30152());
				d302.setD30253(d301_.getD30153());
				d302.setD30254(d301_.getD30154());
				d302.setD30255(d301_.getD30155());
				
			} catch (Exception e) {
				errorMessage.append("换发失败!");
				e.printStackTrace();
				state = false;
			}
		}
		
		if(state)
		{
			String d505Sql = "update D505 t set t.D505_05 = '4' where t.D505_03 = ?";
			SQLQuery query = session.createSQLQuery(d505Sql);
			query.setString(0, d301_10);
			
			int row = query.executeUpdate();
			if(row <= 0)
			{
				errorMessage.append("换发失败!");
				state = false;
			}
		}
		
		if(state)
		{	
			try {
				session.save(d302);
				session.flush();
			} catch (Exception e) {
				e.printStackTrace();
				errorMessage.append("换发失败!");
				state = false;
			}
		}
		
		queryBirthResponse.setErrorMessage(errorMessage.toString());
		queryBirthResponse.setState(state);
		return queryBirthResponse;
	}
	
	@Override
	public boolean validateSaveBirthCertiticate(
			QueryBirthRequest queryBirthRequest) {
		
		String d30110 = queryBirthRequest.getD301_10();
		
		this.hql = new StringBuffer("select * from D301 t where 0=0 ");
		if(!StringUtil.isBlankString(d30110))
		{
			this.hql.append(" and t.d301_10= '");
			this.hql.append(d30110);
			this.hql.append("'");
		}
		SQLQuery query = null;
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
			query = session.createSQLQuery(this.hql.toString());
			if(query.list().size() >0){
				return false;
			}
		} catch (Exception e) {
		}
		return true;
	}
	
	@Override
	public QueryBirthResponse queryBirthCertificate(QueryBirthRequest queryBirthRequest) {
		String _d301_02 = queryBirthRequest.getD301_02();
		String _d301_05 = queryBirthRequest.getD301_05();
		String _d301_10 = queryBirthRequest.getD301_10();
		String _d301_11 = queryBirthRequest.getD301_11();
		String _d301_12 = queryBirthRequest.getD301_12();
		String _d301_16 = queryBirthRequest.getD301_16();
		String _d301_17 = queryBirthRequest.getD301_17();
		String _d301_26 = queryBirthRequest.getD301_26();
		Date _d301_28Start = queryBirthRequest.getD301_28Start();
		Date _d301_28End = queryBirthRequest.getD301_28End();
		String _d301_30 = queryBirthRequest.getD301_30();   //1.代表机构内  2.代表机构外
		String _d301_31 = queryBirthRequest.getD301_31();
		long _d301_41 = queryBirthRequest.getD301_41();
		String _d301_55 = queryBirthRequest.getD301_55();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		int parameterPageindex = queryBirthRequest.getParameterPageindex();
		int parameterPagesize = queryBirthRequest.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		String d301_42 = queryBirthRequest.getD301_42();
		if(!StringUtil.isBlankString(d301_42)){
			parameterConditionwhere.append(" and t.d301_42 = '" + d301_42 +"'");
		}
		if(!StringUtil.isBlankString(_d301_02)){
			parameterConditionwhere.append(" and t.d301_02 like '");
			parameterConditionwhere.append(_d301_02);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(_d301_05))
		{
			parameterConditionwhere.append(" and t.d301_05 like '");
			parameterConditionwhere.append(_d301_05);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(_d301_10))
		{
			parameterConditionwhere.append(" and t.d301_10 = '");
			parameterConditionwhere.append(_d301_10);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d301_11))
		{
			parameterConditionwhere.append(" and t.d301_11 = '");
			parameterConditionwhere.append(_d301_11);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d301_12))
		{
			parameterConditionwhere.append(" and t.d301_12 = '");
			parameterConditionwhere.append(_d301_12);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d301_16))
		{
			parameterConditionwhere.append(" and t.d301_16 = '");
			parameterConditionwhere.append(_d301_16);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d301_17))
		{
			parameterConditionwhere.append(" and t.d301_17 = '");
			parameterConditionwhere.append(_d301_17);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d301_26))
		{
			if(_d301_26.length() == 14)
			{
				parameterConditionwhere.append(" and t.d301_26 = '");
				parameterConditionwhere.append(_d301_26);
				parameterConditionwhere.append("'");
			}else
			{
				parameterConditionwhere.append(" and t.d301_26 like '");
				parameterConditionwhere.append(_d301_26);
				parameterConditionwhere.append("%'");
			}
		}
		if(_d301_28Start != null)
		{
			String d30128Start = simpleDateFormat.format(_d301_28Start);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') >= to_date('" + d30128Start + "', 'yyyy-mm-dd')");
		}
		if(_d301_28End != null)
		{
			String d30128End = simpleDateFormat.format(_d301_28End);
			parameterConditionwhere.append(" and to_date(t.d301_28,'yyyy-mm-dd') <= to_date('" + d30128End + "', 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(_d301_30))
		{
			parameterConditionwhere.append(" and t.d301_30 = '");
			parameterConditionwhere.append(_d301_30);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d301_31))
		{
			parameterConditionwhere.append(" and t.d301_31 like '");
			parameterConditionwhere.append(_d301_31);
			parameterConditionwhere.append("%'");
		}
		
		if(_d301_41 > 0) {
			parameterConditionwhere.append(" and t.d301_41 = ");
			parameterConditionwhere.append(_d301_41);
		}
		
		if(!StringUtil.isBlankString(_d301_55))
		{
			parameterConditionwhere.append(" and t.d301_55 ='");
			parameterConditionwhere.append(_d301_55);
			parameterConditionwhere.append("'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			
			callableStatement.setString(3, "V_D301");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D301_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			
			queryBirthResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD301 vD301 =null;
			List<VD301> listVD301 = new ArrayList<VD301>();
			
			while (resultSet.next()) {
				long d30101 = resultSet.getLong("D301_01");
				String d30102 = resultSet.getString("D301_02");
				String d30103 = resultSet.getString("D301_03");
				String d30104 = resultSet.getString("D301_04");
				String d30105 = resultSet.getString("D301_05");
				String d30106 = resultSet.getString("D301_06");
				int d30107 = resultSet.getInt("D301_07");
				double d30108 = resultSet.getDouble("D301_08");
				String d30109 = resultSet.getString("D301_09");
				String d30110 = resultSet.getString("D301_10");
				String d30111 = resultSet.getString("D301_11");
				String d30112 = resultSet.getString("D301_12");
				String d30113 = resultSet.getString("D301_13");
				String d30114 = resultSet.getString("D301_14");
				String d30115 = resultSet.getString("D301_15");
				String d30116 = resultSet.getString("D301_16");
				String d30117 = resultSet.getString("D301_17");
				String d30118 = resultSet.getString("D301_18");
				String d30119 = resultSet.getString("D301_19");
				String d30120 = resultSet.getString("D301_20");
				String d30121 = resultSet.getString("D301_21");
				String d30122 = resultSet.getString("D301_22");
				String d30123 = resultSet.getString("D301_23");
				String d30124 = resultSet.getString("D301_24");
				String d30125 = resultSet.getString("D301_25");
				String d30126 = resultSet.getString("D301_26");
				String d30127 = resultSet.getString("D301_27");
				String d30128 = resultSet.getString("d301_28");
				double d30129 = resultSet.getDouble("D301_29");
				String d30130 = resultSet.getString("D301_30");
				String d30131 = resultSet.getString("D301_31");
				String d30152 = resultSet.getString("D301_52");
				String d30103Zh = resultSet.getString("D301_03_ZH");
				String d30105Zh = resultSet.getString("D301_05_ZH");
				String d30109Zh = resultSet.getString("D301_09_ZH");
				String d30114Zh = resultSet.getString("D301_14_ZH");
				String d30115Zh = resultSet.getString("D301_15_ZH");
				String d30119Zh = resultSet.getString("D301_19_ZH");
				String d30120Zh = resultSet.getString("D301_20_ZH");
				String d30122Zh = resultSet.getString("D301_22_ZH");
				String d30124Zh = resultSet.getString("D301_24_ZH");
				String d30126Zh = resultSet.getString("D301_26_ZH");
				String d30130Zh = resultSet.getString("D301_30_ZH");
				String d30131Zh = resultSet.getString("D301_31_Zh");
				String d30150Zh = resultSet.getString("D301_50_Zh");
				String d30155Zh = resultSet.getString("D301_55_Zh");
				
				String d30132 = resultSet.getString("D301_32");
				String d30133 = resultSet.getString("D301_33");
				String d30134 = resultSet.getString("D301_34");
				String d30134Zh = resultSet.getString("D301_34_Zh");
				String d30135 = resultSet.getString("D301_35");
				String d30135Zh = resultSet.getString("D301_35_Zh");
				String d30136 = resultSet.getString("D301_36");
				String d30137 = resultSet.getString("D301_37");
				String d30137Zh = resultSet.getString("D301_37_Zh");
				String d30138 = resultSet.getString("D301_38");
				String d30138Zh = resultSet.getString("D301_38_Zh");
				String d30139 = resultSet.getString("D301_39");
				String d30140 = resultSet.getString("D301_40");
				//add
//				String d30121Zh = resultSet.getString("D301_21_Zh");
				String d30143 = resultSet.getString("D301_43");
//				String d30148Zh = resultSet.getString("D301_48_Zh");
				
				vD301 = new VD301();
				
				vD301.setD30101(d30101);
				vD301.setD30102(d30102);
				vD301.setD30103(d30103);
				vD301.setD30104(d30104);
				vD301.setD30105(d30105);
				vD301.setD30106(d30106);
				vD301.setD30107(d30107);
				vD301.setD30108(d30108);
				vD301.setD30109(d30109);
				vD301.setD30110(d30110);
				vD301.setD30111(d30111);
				vD301.setD30112(d30112);
				vD301.setD30113(d30113);
				vD301.setD30114(d30114);
				vD301.setD30115(d30115);
				vD301.setD30116(d30116);
				vD301.setD30117(d30117);
				vD301.setD30118(d30118);
				vD301.setD30119(d30119);
				vD301.setD30120(d30120);
				vD301.setD30121(d30121);
				vD301.setD30122(d30122);
				vD301.setD30123(d30123);
				vD301.setD30124(d30124);
				vD301.setD30125(d30125);
				vD301.setD30126(d30126);
				vD301.setD30127(d30127);
				vD301.setD30128(d30128);
				vD301.setD30129(d30129);
				vD301.setD30130(d30130);
				vD301.setD30131(d30131);
				vD301.setD30152(d30152);
				vD301.setD30103Zh(d30103Zh);
				vD301.setD30105Zh(d30105Zh);
				vD301.setD30109Zh(d30109Zh);
				vD301.setD30114Zh(d30114Zh);
				vD301.setD30115Zh(d30115Zh);
				vD301.setD30119Zh(d30119Zh);
				vD301.setD30120Zh(d30120Zh);
				vD301.setD30122Zh(d30122Zh);
				vD301.setD30124Zh(d30124Zh);
				vD301.setD30126Zh(d30126Zh);
				vD301.setD30130Zh(d30130Zh);
				vD301.setD30131Zh(d30131Zh);
				vD301.setD30150Zh(d30150Zh);
				vD301.setD30155Zh(d30155Zh);
				vD301.setD30132(d30132);
				vD301.setD30133(d30133);
				vD301.setD30134(d30134);
				vD301.setD30134Zh(d30134Zh);
				vD301.setD30135(d30135);
				vD301.setD30135Zh(d30135Zh);
				vD301.setD30136(d30136);
				vD301.setD30137(d30137);
				vD301.setD30137Zh(d30137Zh);
				vD301.setD30138(d30138);
				vD301.setD30138Zh(d30138Zh);
				vD301.setD30139(d30139);
				vD301.setD30140(d30140);
				//add
//				vD301.setD30121Zh(d30121Zh);
				vD301.setD30143(d30143);
//				vD301.setD30148Zh(d30148Zh);
				
				
				
			    listVD301.add(vD301);
			}
			queryBirthResponse.setListVD301(listVD301);
		} catch (Exception e) {
			e.printStackTrace();
			queryBirthResponse.setErrorMessage("查询失败!");
		}finally{
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

			}
		}
		return queryBirthResponse;
	}
	
	@Override
	public QueryBirthResponse queryBirthCertificatehf(
			QueryBirthRequest queryBirthRequest) {
		/*
		String _d302_02 = queryBirthRequest.getD302_02();
		String _d302_05 = queryBirthRequest.getD302_05();
		String _d302_10 = queryBirthRequest.getD302_10();
		String _d302_26 = queryBirthRequest.getD302_26();
		
		//xiugai
		String _d302_11 = queryBirthRequest.getD302_11();
		String _d302_12 = queryBirthRequest.getD302_12();
		String _d302_16 = queryBirthRequest.getD302_16();
		String _d302_17 = queryBirthRequest.getD302_17();
		
		Date _d302_28Start = queryBirthRequest.getD302_28Start();
		Date _d302_28End = queryBirthRequest.getD302_28End();
		String _d302_33 = queryBirthRequest.getD302_33();
		long _d302_45 = queryBirthRequest.getD302_45();
		String _d302_47 = queryBirthRequest.getD302_47();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		int parameterPageindex = queryBirthRequest.getParameterPageindex();
		int parameterPagesize = queryBirthRequest.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(_d302_02)){
			parameterConditionwhere.append(" and t.d302_02 like '");
			parameterConditionwhere.append(_d302_02);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(_d302_05))
		{
			parameterConditionwhere.append(" and t.d302_05 like '");
			parameterConditionwhere.append(_d302_05);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(_d302_10))
		{
			parameterConditionwhere.append(" and t.d302_10 = '");
			parameterConditionwhere.append(_d302_10);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d302_11))
		{
			parameterConditionwhere.append(" and t.d302_11 = '");
			parameterConditionwhere.append(_d302_11);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d302_12))
		{
			parameterConditionwhere.append(" and t.d302_12 = '");
			parameterConditionwhere.append(_d302_12);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d302_16))
		{
			parameterConditionwhere.append(" and t.d302_16 = '");
			parameterConditionwhere.append(_d302_16);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d302_17))
		{
			parameterConditionwhere.append(" and t.d302_17 = '");
			parameterConditionwhere.append(_d302_17);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d302_26))
		{
			if(_d302_26.length() == 14) {
				parameterConditionwhere.append(" and t.d302_26 = '");
				parameterConditionwhere.append(_d302_26);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.d302_26 like '");
				parameterConditionwhere.append(_d302_26);
				parameterConditionwhere.append("%'");
			}
		}
		if(_d302_28Start != null)
		{
			String d30228Start = simpleDateFormat.format(_d302_28Start);
			parameterConditionwhere.append("and t.d302_28 >= to_date('" + d30228Start + "', 'yyyy-mm-dd')");
		}
		if(_d302_28End != null)
		{
			String d30228End = simpleDateFormat.format(_d302_28End);
			parameterConditionwhere.append(" and t.d302_28 <= to_date('" + d30228End + "', 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(_d302_33))
		{
			parameterConditionwhere.append(" and t.d302_33 like '");
			parameterConditionwhere.append(_d302_33);
			parameterConditionwhere.append("%'");
		}

		if(_d302_45 > 0) {
			parameterConditionwhere.append(" and t.d302_45 = ");
			parameterConditionwhere.append(_d302_45);
		}
		if(!StringUtil.isBlankString(_d302_47))
		{
			parameterConditionwhere.append(" and t.d302_47 = '");
			parameterConditionwhere.append(_d302_47);
			parameterConditionwhere.append("'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			
			callableStatement.setString(3, "V_D302");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D302_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			
			queryBirthResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD302 vD302 =null;
			List<VD302> listVD302 = new ArrayList<VD302>();
			
//			SimpleDateFormat simpleDateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm");;
			SimpleDateFormat simpleDateFormatShort = new SimpleDateFormat("yyyy-MM-dd");
			while (resultSet.next()) {
				long d30201 = resultSet.getLong("D302_01");
				String d30202 = resultSet.getString("D302_02");
				String d30203 = resultSet.getString("D302_03");
				String d30204 = resultSet.getString("D302_04");
//				Date d30204Date = resultSet.getDate("D302_04");
//				String d30204 = "";
//				if(d30204Date != null)
//				{
//					d30204 = simpleDateFormatFull.format(d30204Date);
//				}
				String d30205 = resultSet.getString("D302_05");
				String d30206 = resultSet.getString("D302_06");
				int d30207 = resultSet.getInt("D302_07");
				double d30208 = resultSet.getDouble("D302_08");
				String d30209 = resultSet.getString("D302_09");
				String d30210 = resultSet.getString("D302_10");
				String d30211 = resultSet.getString("D302_11");
				String d30212 = resultSet.getString("D302_12");
				Date d30213Date = resultSet.getDate("D302_13");
				String d30213 = "";
				if(d30213Date != null)
				{
					d30213 = simpleDateFormatShort.format(d30213Date);
				}
				String d30214 = resultSet.getString("D302_14");
				String d30215 = resultSet.getString("D302_15");
				String d30216 = resultSet.getString("D302_16");
				String d30217 = resultSet.getString("D302_17");
				Date d30218Date = resultSet.getDate("D302_18");
				String d30218 = "";
				if(d30218Date != null)
				{
					d30218 = simpleDateFormatShort.format(d30218Date);
				}
				String d30219 = resultSet.getString("D302_19");
				String d30220 = resultSet.getString("D302_20");
				String d30221 = resultSet.getString("D302_21");
				String d30222 = resultSet.getString("D302_22");
				String d30223 = resultSet.getString("D302_23");
				String d30224 = resultSet.getString("D302_24");
				String d30225 = resultSet.getString("D302_25");
				String d30226 = resultSet.getString("D302_26");
				String d30227 = resultSet.getString("D302_27");
				Date d30228Date = resultSet.getDate("d302_28");
				String d30228 = "";
				if(d30228Date != null)
				{
					d30228 = simpleDateFormatShort.format(d30228Date);
				}
				double d30229 = resultSet.getDouble("D302_29");
				String d30230 = resultSet.getString("D302_30");
				String d30231 = resultSet.getString("D302_31");
				String d30232 = resultSet.getString("D302_32");
				String d30233 = resultSet.getString("D302_33");
				String d30234 = resultSet.getString("D302_34");
				String d30235 = resultSet.getString("D302_35");
				String d30236 = resultSet.getString("D302_36");
				String d30237 = resultSet.getString("D302_37");
				String d30238 = resultSet.getString("D302_38");
				String d30239 = resultSet.getString("D302_39");
				String d30240 = resultSet.getString("D302_40");
				String d30241 = resultSet.getString("D302_41");
				String d30242 = resultSet.getString("D302_42");
				String d30243 = resultSet.getString("D302_43");
				String d30244 = resultSet.getString("D302_44");
				String d30203Zh = resultSet.getString("D302_03_ZH");
				String d30205Zh = resultSet.getString("D302_05_ZH");
				String d30209Zh = resultSet.getString("D302_09_ZH");
				String d30214Zh = resultSet.getString("D302_14_ZH");
				String d30215Zh = resultSet.getString("D302_15_ZH");
				String d30219Zh = resultSet.getString("D302_19_ZH");
				String d30220Zh = resultSet.getString("D302_20_ZH");
				String d30222Zh = resultSet.getString("D302_22_ZH");
				String d30224Zh = resultSet.getString("D302_24_ZH");
				String d30226Zh = resultSet.getString("D302_26_ZH");
				String d30232Zh = resultSet.getString("D302_32_ZH");
				String d30233Zh = resultSet.getString("D302_33_ZH");
				String d30236Zh = resultSet.getString("D302_36_ZH");
				String d30237Zh = resultSet.getString("D302_37_ZH");
				String d30239Zh = resultSet.getString("D302_39_ZH");
				String d30240Zh = resultSet.getString("D302_40_ZH");
				String d30243Zh = resultSet.getString("D302_43_ZH");
				//add
//				String d30221Zh = resultSet.getString("D302_21_ZH");
				String d30246 = resultSet.getString("D302_46");
//				String d30252Zh = resultSet.getString("D302_52_ZH");
				
				vD302 = new VD302();
				
				vD302.setD30201(d30201);
				vD302.setD30202(d30202);
				vD302.setD30203(d30203);
				vD302.setD30204(d30204);
				vD302.setD30205(d30205);
				vD302.setD30206(d30206);
				vD302.setD30207(d30207);
				vD302.setD30208(d30208);
				vD302.setD30209(d30209);
				vD302.setD30210(d30210);
				vD302.setD30211(d30211);
				vD302.setD30212(d30212);
				vD302.setD30213(d30213);
				vD302.setD30214(d30214);
				vD302.setD30215(d30215);
				vD302.setD30216(d30216);
				vD302.setD30217(d30217);
				vD302.setD30218(d30218);
				vD302.setD30219(d30219);
				vD302.setD30220(d30220);
				vD302.setD30221(d30221);
				vD302.setD30222(d30222);
				vD302.setD30223(d30223);
				vD302.setD30224(d30224);
				vD302.setD30225(d30225);
				vD302.setD30226(d30226);
				vD302.setD30227(d30227);
				vD302.setD30228(d30228);
				vD302.setD30229(d30229);
				vD302.setD30230(d30230);
				vD302.setD30231(d30231);
				vD302.setD30232(d30232);
				vD302.setD30233(d30233);
				vD302.setD30234(d30234);
				vD302.setD30235(d30235);
				vD302.setD30236(d30236);
				vD302.setD30237(d30237);
				vD302.setD30238(d30238);
				vD302.setD30239(d30239);
				vD302.setD30240(d30240);
				vD302.setD30241(d30241);
				vD302.setD30242(d30242);
				vD302.setD30243(d30243);
				vD302.setD30244(d30244);
				vD302.setD30203Zh(d30203Zh);
				vD302.setD30205Zh(d30205Zh);
				vD302.setD30209Zh(d30209Zh);
				vD302.setD30214Zh(d30214Zh);
				vD302.setD30215Zh(d30215Zh);
				vD302.setD30219Zh(d30219Zh);
				vD302.setD30220Zh(d30220Zh);
				vD302.setD30222Zh(d30222Zh);
				vD302.setD30224Zh(d30224Zh);
				vD302.setD30226Zh(d30226Zh);
				vD302.setD30232Zh(d30232Zh);
				vD302.setD30233Zh(d30233Zh);
				vD302.setD30236Zh(d30236Zh);
				vD302.setD30237Zh(d30237Zh);
				vD302.setD30239Zh(d30239Zh);
				vD302.setD30240Zh(d30240Zh);
				vD302.setD30243Zh(d30243Zh);
				//add
//				vD302.setD30221Zh(d30221Zh);
				vD302.setD30246(d30246);
//				vD302.setD30252Zh(d30252Zh);
				
			    listVD302.add(vD302);
			}
			queryBirthResponse.setListVD302(listVD302);
		} catch (Exception e) {
			queryBirthResponse.setErrorMessage("查询失败!");
		}finally{
			try {
				if (connection != null) {
					connection.close();
					connection = null;
				}
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				
			} catch (Exception e) {

			}
		}
		
		return queryBirthResponse;
		*/
		return null;
	}
	
	@Override
	public QueryBirthResponse queryBirthCertificatebf(
			QueryBirthRequest queryBirthRequest) {
		String _d303_02 = queryBirthRequest.getD303_02();
		String _d303_05 = queryBirthRequest.getD303_05();
		String _d303_10 = queryBirthRequest.getD303_10();
		String _d303_11 = queryBirthRequest.getD303_11();
		String _d303_12 = queryBirthRequest.getD303_12();
		String _d303_16 = queryBirthRequest.getD303_16();
		String _d303_17 = queryBirthRequest.getD303_17();
		String _d303_26 = queryBirthRequest.getD303_26();
		Date _d303_28Start = queryBirthRequest.getD303_28Start();
		Date _d303_28End = queryBirthRequest.getD303_28End();
		String _d303_33 = queryBirthRequest.getD303_33();
		long _d303_45 = queryBirthRequest.getD303_45();
		String _d303_47 = queryBirthRequest.getD303_47();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		int parameterPageindex = queryBirthRequest.getParameterPageindex();
		int parameterPagesize = queryBirthRequest.getParameterPagesize();
		
		StringBuffer parameterConditionwhere = new StringBuffer();
		
		if(!StringUtil.isBlankString(_d303_02)){
			parameterConditionwhere.append(" and t.d303_02 like '");
			parameterConditionwhere.append(_d303_02);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(_d303_05))
		{
			parameterConditionwhere.append(" and t.d303_05 like '");
			parameterConditionwhere.append(_d303_05);
			parameterConditionwhere.append("%'");
		}
		if(!StringUtil.isBlankString(_d303_10))
		{
			parameterConditionwhere.append(" and t.d303_10 = '");
			parameterConditionwhere.append(_d303_10);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d303_11))
		{
			parameterConditionwhere.append(" and t.d303_11 = '");
			parameterConditionwhere.append(_d303_11);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d303_12))
		{
			parameterConditionwhere.append(" and t.d303_12 = '");
			parameterConditionwhere.append(_d303_12);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d303_16))
		{
			parameterConditionwhere.append(" and t.d303_16 = '");
			parameterConditionwhere.append(_d303_16);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d303_17))
		{
			parameterConditionwhere.append(" and t.d303_17 = '");
			parameterConditionwhere.append(_d303_17);
			parameterConditionwhere.append("'");
		}
		if(!StringUtil.isBlankString(_d303_26))
		{
			if(_d303_26.length() == 14) {
				parameterConditionwhere.append(" and t.d303_26 = '");
				parameterConditionwhere.append(_d303_26);
				parameterConditionwhere.append("'");
			} else {
				parameterConditionwhere.append(" and t.d303_26 like '");
				parameterConditionwhere.append(_d303_26);
				parameterConditionwhere.append("%'");
			}
		}
		if(_d303_28Start != null)
		{
			String d30328Start = simpleDateFormat.format(_d303_28Start);
			parameterConditionwhere.append(" and t.d303_28 >= to_date('" + d30328Start + "', 'yyyy-mm-dd')");
		}
		if(_d303_28End != null)
		{
			String d30328End = simpleDateFormat.format(_d303_28End);
			parameterConditionwhere.append(" and t.d303_28 <= to_date('" + d30328End + "', 'yyyy-mm-dd')");
		}
		if(!StringUtil.isBlankString(_d303_33))
		{
			parameterConditionwhere.append(" and t.d303_33 like '");
			parameterConditionwhere.append(_d303_33);
			parameterConditionwhere.append("%'");
		}
		
		if(_d303_45 > 0) {
			parameterConditionwhere.append(" and t.d303_45 = ");
			parameterConditionwhere.append(_d303_45);
		}
		if(!StringUtil.isBlankString(_d303_47))
		{
			parameterConditionwhere.append(" and t.d303_47 = '");
			parameterConditionwhere.append(_d303_47);
			parameterConditionwhere.append("'");
		}
		
		Connection connection = null;
		CallableStatement callableStatement = null;
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			
			callableStatement.setString(3, "V_D303");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.D303_01");
			
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			
			queryBirthResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VD303 vD303 =null;
			List<VD303> listVD303 = new ArrayList<VD303>();
			
//			SimpleDateFormat simpleDateFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm");;
			SimpleDateFormat simpleDateFormatShort = new SimpleDateFormat("yyyy-MM-dd");
			while (resultSet.next()) {
				long d30301 = resultSet.getLong("D303_01");
				String d30302 = resultSet.getString("D303_02");
				String d30303 = resultSet.getString("D303_03");
				String d30304 = resultSet.getString("D303_04");
//				Date d30304Date = resultSet.getDate("D303_04");
//				String d30304 = "";
//				if(d30304Date != null)
//				{
//					d30304 = simpleDateFormatFull.format(d30304Date);
//				}
				String d30305 = resultSet.getString("D303_05");
				String d30306 = resultSet.getString("D303_06");
				int d30307 = resultSet.getInt("D303_07");
				double d30308 = resultSet.getDouble("D303_08");
				String d30309 = resultSet.getString("D303_09");
				String d30310 = resultSet.getString("D303_10");
				String d30311 = resultSet.getString("D303_11");
				String d30312 = resultSet.getString("D303_12");
				Date d30313Date = resultSet.getDate("D303_13");
				String d30313 = "";
				if(d30313Date != null)
				{
					d30313 = simpleDateFormatShort.format(d30313Date);
				}
				String d30314 = resultSet.getString("D303_14");
				String d30315 = resultSet.getString("D303_15");
				String d30316 = resultSet.getString("D303_16");
				String d30317 = resultSet.getString("D303_17");
				Date d30318Date = resultSet.getDate("D303_18");
				String d30318 = "";
				if(d30318Date != null)
				{
					d30318 = simpleDateFormatShort.format(d30318Date);
				}
				String d30319 = resultSet.getString("D303_19");
				String d30320 = resultSet.getString("D303_20");
				String d30321 = resultSet.getString("D303_21");
				String d30322 = resultSet.getString("D303_22");
				String d30323 = resultSet.getString("D303_23");
				String d30324 = resultSet.getString("D303_24");
				String d30325 = resultSet.getString("D303_25");
				String d30326 = resultSet.getString("D303_26");
				String d30327 = resultSet.getString("D303_27");
				Date d30328Date = resultSet.getDate("d303_28");
				String d30328 = "";
				if(d30328Date != null)
				{
					d30328 = simpleDateFormatShort.format(d30328Date);
				}
				double d30329 = resultSet.getDouble("D303_29");
				String d30330 = resultSet.getString("D303_30");
				String d30331 = resultSet.getString("D303_31");
				String d30332 = resultSet.getString("D303_32");
				String d30333 = resultSet.getString("D303_33");
				String d30334 = resultSet.getString("D303_34");
				String d30335 = resultSet.getString("D303_35");
				String d30336 = resultSet.getString("D303_36");
				String d30337 = resultSet.getString("D303_37");
				String d30338 = resultSet.getString("D303_38");
				String d30339 = resultSet.getString("D303_39");
				String d30340 = resultSet.getString("D303_40");
				String d30341 = resultSet.getString("D303_41");
				String d30342 = resultSet.getString("D303_42");
				String d30343 = resultSet.getString("D303_43");
				String d30344 = resultSet.getString("D303_44");
				String d30303Zh = resultSet.getString("D303_03_ZH");
				String d30305Zh = resultSet.getString("D303_05_ZH");
				String d30309Zh = resultSet.getString("D303_09_ZH");
				String d30314Zh = resultSet.getString("D303_14_ZH");
				String d30315Zh = resultSet.getString("D303_15_ZH");
				String d30319Zh = resultSet.getString("D303_19_ZH");
				String d30320Zh = resultSet.getString("D303_20_ZH");
				String d30322Zh = resultSet.getString("D303_22_ZH");
				String d30324Zh = resultSet.getString("D303_24_ZH");
				String d30326Zh = resultSet.getString("D303_26_ZH");
				String d30332Zh = resultSet.getString("D303_32_ZH");
				String d30333Zh = resultSet.getString("D303_33_ZH");
				String d30336Zh = resultSet.getString("D303_36_ZH");
				String d30337Zh = resultSet.getString("D303_37_ZH");
				String d30339Zh = resultSet.getString("D303_39_ZH");
				String d30340Zh = resultSet.getString("D303_40_ZH");
				String d30343Zh = resultSet.getString("D303_43_ZH");
				//add
//				String d30321Zh = resultSet.getString("D303_21_ZH");
				String d30346 = resultSet.getString("D303_46");
//				String d30352Zh = resultSet.getString("D303_52_ZH");
				
				vD303 = new VD303();
				
				vD303.setD30301(d30301);
				vD303.setD30302(d30302);
				vD303.setD30303(d30303);
				vD303.setD30304(d30304);
				vD303.setD30305(d30305);
				vD303.setD30306(d30306);
				vD303.setD30307(d30307);
				vD303.setD30308(d30308);
				vD303.setD30309(d30309);
				vD303.setD30310(d30310);
				vD303.setD30311(d30311);
				vD303.setD30312(d30312);
				vD303.setD30313(d30313);
				vD303.setD30314(d30314);
				vD303.setD30315(d30315);
				vD303.setD30316(d30316);
				vD303.setD30317(d30317);
				vD303.setD30318(d30318);
				vD303.setD30319(d30319);
				vD303.setD30320(d30320);
				vD303.setD30321(d30321);
				vD303.setD30322(d30322);
				vD303.setD30323(d30323);
				vD303.setD30324(d30324);
				vD303.setD30325(d30325);
				vD303.setD30326(d30326);
				vD303.setD30327(d30327);
				vD303.setD30328(d30328);
				vD303.setD30329(d30329);
				vD303.setD30330(d30330);
				vD303.setD30331(d30331);
				vD303.setD30332(d30332);
				vD303.setD30333(d30333);
				vD303.setD30334(d30334);
				vD303.setD30335(d30335);
				vD303.setD30336(d30336);
				vD303.setD30337(d30337);
				vD303.setD30338(d30338);
				vD303.setD30339(d30339);
				vD303.setD30340(d30340);
				vD303.setD30341(d30341);
				vD303.setD30342(d30342);
				vD303.setD30343(d30343);
				vD303.setD30344(d30344);
				vD303.setD30303Zh(d30303Zh);
				vD303.setD30305Zh(d30305Zh);
				vD303.setD30309Zh(d30309Zh);
				vD303.setD30314Zh(d30314Zh);
				vD303.setD30315Zh(d30315Zh);
				vD303.setD30319Zh(d30319Zh);
				vD303.setD30320Zh(d30320Zh);
				vD303.setD30322Zh(d30322Zh);
				vD303.setD30324Zh(d30324Zh);
				vD303.setD30326Zh(d30326Zh);
				vD303.setD30332Zh(d30332Zh);
				vD303.setD30333Zh(d30333Zh);
				vD303.setD30336Zh(d30336Zh);
				vD303.setD30337Zh(d30337Zh);
				vD303.setD30339Zh(d30339Zh);
				vD303.setD30340Zh(d30340Zh);
				vD303.setD30343Zh(d30343Zh);
				//add
//				vD303.setD30321Zh(d30321Zh);
				vD303.setD30346(d30346);
//				vD303.setD30352Zh(d30352Zh);
				
			    listVD303.add(vD303);
			}
			queryBirthResponse.setListVD303(listVD303);
		} catch (Exception e) {
			queryBirthResponse.setErrorMessage("查询失败!");
		}finally{
			try {
				if (connection != null) {
					connection.close();
					connection = null;
				}
				if (callableStatement != null) {
					callableStatement.close();
					callableStatement = null;
				}
				
			} catch (Exception e) {

			}
		}
		return queryBirthResponse;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public QueryBirthResponse validateStockCertiticate(
			QueryBirthRequest queryBirthRequest) {
		String d30110 = queryBirthRequest.getD301_10();
		String d30126 = queryBirthRequest.getD301_26();
		
		QueryBirthResponse queryBirthResponse = new QueryBirthResponse();
		errorMessage = new StringBuffer();
		boolean state = true;
		
		String sql = "select * from D505 t where t.D505_03 = ? and t.D505_04 = ?";
		
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, d30110);
		sqlQuery.setString(1, d30126);
		
		List<Object> list = sqlQuery.list();
		if(list.size() > 0)
		{
			Object[] objD505 = (Object[])list.get(0);
			String d50505 = objD505[4] + "";
			String d50508 = objD505[7] + "";
			if(!"1".equals(d50505))
			{
				errorMessage.append("该证号已被使用!");
				state = false;
			}else if("1".equals(d50508))
			{
				errorMessage.append("该证号已经分配,没有使用权限");
				state = false;
			}
		}else
		{
			errorMessage.append("该出生证号没有入库!");
			state = false;
		}
		queryBirthResponse.setErrorMessage(errorMessage.toString());
		queryBirthResponse.setState(state);
		
		return queryBirthResponse;
	}

	@SuppressWarnings("unchecked")
	public VD505 queryBirthInstitution(VD505 vd505){
		String sql = "select * from V_D505 t where t.D505_03 = ?";
		Session session = sessionFactory.getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setString(0, vd505.getD505_03());
		List<Object> list = sqlQuery.list();
		if(list.size() > 0 ){
			Object[] objVD505 = (Object[])list.get(0);
			if(Integer.parseInt(objVD505[7].toString()) == 0)
			{
				vd505.setD505_04Zh(objVD505[20].toString());
			}
		}
		return vd505;
	}
	
	@Override
	public boolean del(String d30110)
	{
		try {
			String sql = "delete from d301 t where t.d301_10 = ?";
			
			Session session = sessionFactory.getCurrentSession();
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setString(0, d30110);
			int state = sqlQuery.executeUpdate();
			if(state <= 0)
			{
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isUsed(long d30401,long d60101) {
		StringBuffer sql =new StringBuffer("select * from D301 t where t.d301_57=" + d30401);
		if(d60101 ==1){   //机构内首发打印
			sql.append("and t.d301_56 !=0 ");
		}else if(d60101 ==0){
			sql.append("and t.d301_56 =0 ");
		}
		try{
			Session session = this.sessionFactory.getCurrentSession();
			SQLQuery query = session.createSQLQuery("select * from D301 t where t.d301_57=" + d30401 + "and t.d301_42 = '0' ");
			List<D301> d301s = query.addEntity(D301.class).list();
			if(d301s.size()>0) return false;
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
