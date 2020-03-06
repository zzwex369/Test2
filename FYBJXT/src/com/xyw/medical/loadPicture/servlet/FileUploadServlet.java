package com.xyw.medical.loadPicture.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


import com.xyw.medical.loadPicture.model.Pictures;


public class FileUploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 限制文件的上传大小
	private int maxPostSize = 100 * 1024 * 1024; // 最大100M

	@SuppressWarnings("unchecked")
	 protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
		// 保存文件到服务器中
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		//图片名字
		String name =null;
		upload.setSizeMax(maxPostSize);
			List fileItems = upload.parseRequest(request);
			Iterator iter = fileItems.iterator();
			String pic02=request.getParameter("pic02");
			String pic07=request.getParameter("pic07");
			String pic08=request.getParameter("pic08");
			String pic09=request.getParameter("pic09");
			String pic10=request.getParameter("pic10");
			Pictures pictures=new Pictures(pic02,pic07,pic08,pic10);
			///csbg_csyxzmweb/ ccbg_picture/501主键/图片类型
			//图片的保存路径，上传的时候一定要修改一下=========================
			//本地测试路径
				String uploadPath ="E:"+File.separator+"csbg_csyxzmweb"+
			File.separator+"ccbg_picture"+File.separator+
			pictures.getPic07()+File.separator+pictures.getPic02()+
			File.separator+pictures.getPic10()+File.separator;
			//正式路径
			/*String uploadPath =File.separator+"cs_csyxzmweb"+
			File.separator+"FYBJ_csscbg_picture"+File.separator+
			pictures.getPic07()+File.separator+pictures.getPic02()+
			File.separator+pictures.getPic10()+File.separator;	*/
			pictures.setPic03(uploadPath);
			 File fil=new File(uploadPath);
			 if(!fil.exists()){   
	        	 fil.mkdirs();   
	         }   
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					name = item.getName();
					name=name.substring(0, name.lastIndexOf("."))+"_"+new Date().getTime()+name.substring(name.lastIndexOf("."));
					pictures.setPic04(name);
					try {
						item.write(new File(fil+File.separator + name));
						saveImage(pictures,request.getSession().getServletContext(), name);						
						System.out.println(name);
						response.getWriter().print("true");
					} catch (Exception e) {
						e.printStackTrace();
						response.getWriter().print("false");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
			response.getWriter().print("false");
			System.out.println(e.getMessage() + "结束");
		}
	}
	private void saveImage(Pictures pic, ServletContext context,String name) {
		Pictures pictures=new Pictures();
		pictures.setPic02(pic.getPic02());
		pictures.setPic03(pic.getPic03());
		pictures.setPic04(name);
		pictures.setPic05(new Date());
		pictures.setPic06("1");
		pictures.setPic07(pic.getPic07());
		pictures.setPic08(pic.getPic08());
		pictures.setPic09(pic.getPic09());
		pictures.setPic10(pic.getPic10());
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(context);
		SessionFactory sessionFactory = (SessionFactory) webApplicationContext
		.getBean("sessionFactory");
		Session session=sessionFactory.openSession();
		try {
				session.save(pictures);
				session.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				session.close();
		}
	}
}
