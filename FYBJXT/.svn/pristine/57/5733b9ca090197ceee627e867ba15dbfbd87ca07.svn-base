package com.xyw.medical.fnbj.print.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyw.medical.fnbj.model.VF401;
import com.xyw.medical.fnbj.print.model.Items;
import com.xyw.medical.fnbj.print.service.HqtjService;
import com.xyw.medical.xzjgwh.model.D201;
import com.xyw.medical.xzjgwh.model.VD201;
import com.xyw.sys.model.D101;

public class HqtjServlet extends HttpServlet{
	/**
	 * request.getSession().getServletContext()
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		long f40101 =Long.parseLong(request.getParameter("f40101"));
		String mancheck = request.getParameter("mancheck");
		String womencheck = request.getParameter("womancheck");
		HqtjService hqtjService = new HqtjService();
		VF401 vf401 = hqtjService.queryVF401(f40101,request.getSession().getServletContext());
		
		Items items = setItems(vf401);
		request.setAttribute("items", items);
		request.setAttribute("vf401", vf401);
		
		if("1".equals(mancheck)){
			request.getRequestDispatcher("/print/hqtj/man.jsp").forward(request, response);//男性检查单
		}else if("2".equals(mancheck)){
			String diqucode = request.getParameter("diqucode");//从前台获取机构编码
			D101 d101 = hqtjService.queryinstitutionCode(diqucode,request.getSession().getServletContext());//通过机构编码查询D101数据
			String d10104 = d101.getD10104();//得到所属地区编码
			VD201 vd201 = hqtjService.queryVD201(d10104,request.getSession().getServletContext());//通过所属地区编码查询VD201数据，目的为得到d20105
			request.setAttribute("vd201", vd201);
			request.getRequestDispatcher("/print/hqtj/hqyxjc.jsp").forward(request, response);//男性检查证明及存根
		}
		if("1".equals(womencheck)){
			request.getRequestDispatcher("/print/hqtj/woman.jsp").forward(request, response);//女性检查单
		}else if("2".equals(womencheck)){
			String diqucode = request.getParameter("diqucode");//从前台获取机构编码
			D101 d101 = hqtjService.queryinstitutionCode(diqucode,request.getSession().getServletContext());//通过机构编码查询D101数据
			String d10104 = d101.getD10104();//得到所属地区编码
			VD201 vd201 = hqtjService.queryVD201(d10104,request.getSession().getServletContext());//通过所属地区编码查询VD201数据，目的为得到d20105
			request.setAttribute("vd201", vd201);
			request.getRequestDispatcher("/print/hqtj/hqyxjc.jsp").forward(request, response);//女性检查证明及存根
		}
		
	}
	public Items setItems(VF401 vf){
		Items it = new Items();
		if(vf.getF40119()!=null){
			String f40119 [] = vf.getF40119().split(",");
			for(int i=0;i<f40119.length;i++){
				if("1".equals(f40119[i])){
					it.setF40119_01(f40119[i]);
				}
				if("2".equals(f40119[i])){
					it.setF40119_02(f40119[i]);
				}
				if("3".equals(f40119[i])){
					it.setF40119_03(f40119[i]);
				}
				if("4".equals(f40119[i])){
					it.setF40119_04(f40119[i]);
				}
				if("5".equals(f40119[i])){
					it.setF40119_05(f40119[i]);
				}
				if("6".equals(f40119[i])){
					it.setF40119_06(f40119[i]);
				}
				if("7".equals(f40119[i])){
					it.setF40119_07(f40119[i]);
				}
				if("8".equals(f40119[i])){
					it.setF40119_08(f40119[i]);
				}
				if("9".equals(f40119[i])){
					it.setF40119_09(f40119[i]);
				}
				if("10".equals(f40119[i])){
					it.setF40119_10(f40119[i]);
				}
				if("11".equals(f40119[i])){
					it.setF40119_11(f40119[i]);
				}
				if("12".equals(f40119[i])){
					it.setF40119_12(f40119[i]);
				}
				if("99".equals(f40119[i])){
					it.setF40119_13(f40119[i]);
				}
				
			}
		}
		if(vf.getF40127()!=null){
			String f40127[] = vf.getF40127().split(",");
			for(int j=0;j<f40127.length;j++){
				if("1".equals(f40127[j])){
					it.setF40127_01(f40127[j]);
				}
				if("2".equals(f40127[j])){
					it.setF40127_02(f40127[j]);
				}
				if("3".equals(f40127[j])){
					it.setF40127_03(f40127[j]);
				}
				if("4".equals(f40127[j])){
					it.setF40127_04(f40127[j]);
				}
				if("5".equals(f40127[j])){
					it.setF40127_05(f40127[j]);
				}
				if("6".equals(f40127[j])){
					it.setF40127_06(f40127[j]);
				}
				if("7".equals(f40127[j])){
					it.setF40127_07(f40127[j]);
				}
				if("8".equals(f40127[j])){
					it.setF40127_08(f40127[j]);
				}
				if("9".equals(f40127[j])){
					it.setF40127_09(f40127[j]);
				}
				if("99".equals(f40127[j])){
					it.setF40127_10(f40127[j]);
				}
			}
		}
		if(vf.getF40130()!=null){
			String f40130[] = vf.getF40130().split(",");
			for(int k =0;k<f40130.length;k++){
				if("1".equals(f40130[k])){
					it.setF40130_01(f40130[k]);
				}
				if("2".equals(f40130[k])){
					it.setF40130_02(f40130[k]);
				}
				if("3".equals(f40130[k])){
					it.setF40130_03(f40130[k]);
				}
				if("4".equals(f40130[k])){
					it.setF40130_04(f40130[k]);
				}
			}
		}
		return it;
	
	}
}
