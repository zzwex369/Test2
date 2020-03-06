package com.xyw.medical.loadPicture.dao.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.sql.DataSource;

import oracle.jdbc.OracleTypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.loadPicture.dao.PictureDao;
import com.xyw.medical.loadPicture.model.PictureMessage;
import com.xyw.medical.loadPicture.model.PictureRequest;
import com.xyw.medical.loadPicture.model.PictureResponse;
import com.xyw.medical.loadPicture.model.Pictures;
import com.xyw.medical.loadPicture.model.VPicture;
import com.xyw.sys.util.BmpReader;

public class PictureDaoImpl implements PictureDao {
	@Resource
	SessionFactory sessionFactory;
	@Resource
	private DataSource dataSource;

	public PictureMessage save(List<Object[]> picArrays,String pic02) {

		Session session = sessionFactory.getCurrentSession();
		PictureMessage message=new PictureMessage();
		
		int i=0;//计数器
		if (picArrays.size() > 0) {
			ByteArrayInputStream inputStream=null;
			try {
				for (Object[] picArr : picArrays) {
					Pictures pictures = (Pictures) picArr[0];
					pictures.setPic02(pic02);
					byte[] picByte = (byte[]) picArr[1];
					// /csbg_csyxzmweb/ ccbg_picture/501主键/图片类型
					// 图片的保存路径，上传的时候一定要修改一下=========================
					// 本地测试路径
					
//					  pictures.setPic03("E:"+File.separator+"csbg_csyxzmweb"+
//					  File.separator+"ccbg_picture"+File.separator+
//					  pictures.getPic07()+File.separator+pictures.getPic02()+
//					  File.separator+pictures.getPic10()+File.separator);
					 
					// 正式路径 本地测试不改默认保存到D盘
					pictures.setPic03(File.separator + "cs_csyxzmweb"
							+ File.separator + "FYBJ_csscbg_picture"
							+ File.separator + pictures.getPic07()
							+ File.separator + pictures.getPic02()
							+ File.separator + pictures.getPic10()
							+ File.separator);

					
				
					File fil = new File(pictures.getPic03());
					if (!fil.exists()) {
						fil.mkdirs();
					}
					File file = new File(fil + File.separator
							+ pictures.getPic04());// 可以是任何图片格式.jpg,.png等
					
					String picName = pictures.getPic04();
					String formartPic = picName.substring(
							picName.indexOf(".") + 1, picName.length());
					 inputStream = new ByteArrayInputStream(picByte);
					BufferedImage bi1 = ImageIO.read(inputStream);
					ImageIO.write(bi1, formartPic, file);// 不管输出什么格式图片，此处不需改动
					List<BigDecimal> idArr= session.createSQLQuery("select pic01 from picture where pic02=? and pic07=? and pic10=? ")
										.setString(0, pic02).setString(1, pictures.getPic07())
										.setString(2, pictures.getPic10()).list();//防止其他机构修改图片   防止多张图片问题 返回list
					session.save(pictures);
					session.flush();
					session.clear();
					++i;
					
					if(idArr.size()>0)
					{
						for(BigDecimal id:idArr){
							VPicture vPicture=new VPicture();
							vPicture.setPic01(id.longValue());
							PictureMessage delMessage=this.deleteById(vPicture);
							if(!delMessage.isStatus())
								return delMessage;
						}
					}
				}
			} catch (Exception e) {
				message.setStatus(false);
				e.printStackTrace();
			}finally{
				try {
					if(inputStream!=null)
						inputStream.close();
				} catch (IOException e) {
					message.setStatus(false);
					e.printStackTrace();
				}
			}
			
			if(i==picArrays.size()){
				message.setStatus(true);
				message.setMessage("图片全部保存成功");
			}
			else {
				message.setStatus(false);
				int fail=picArrays.size()-i;
				message.setMessage("图片保存成功"+i+"条，图片保存失败"+fail+"条");
			}
		}
		return message;
	}
	
	
	@Override
	public PictureMessage save(List<Object[]> picArrays) {

		Session session = sessionFactory.getCurrentSession();
		if (picArrays.size() > 0) {
			try {
				for (Object[] picArr : picArrays) {
					Pictures pictures = (Pictures) picArr[0];
					byte[] picByte = (byte[]) picArr[1];
					// /csbg_csyxzmweb/ ccbg_picture/501主键/图片类型
					// 图片的保存路径，上传的时候一定要修改一下=========================
					// 本地测试路径
					
//					  pictures.setPic03("E:"+File.separator+"csbg_csyxzmweb"+
//					  File.separator+"ccbg_picture"+File.separator+
//					  pictures.getPic07()+File.separator+pictures.getPic02()+
//					  File.separator+pictures.getPic10()+File.separator);
					 
					// 正式路径
					pictures.setPic03(File.separator + "cs_csyxzmweb"
							+ File.separator + "FYBJ_csscbg_picture"
							+ File.separator + pictures.getPic07()
							+ File.separator + pictures.getPic02()
							+ File.separator + pictures.getPic10()
							+ File.separator);

					
				
					File fil = new File(pictures.getPic03());
					if (!fil.exists()) {
						fil.mkdirs();
					}
					File file = new File(fil + File.separator
							+ pictures.getPic04());// 可以是任何图片格式.jpg,.png等

					String picName = pictures.getPic04();
					String formartPic = picName.substring(
							picName.indexOf(".") + 1, picName.length());
					ByteArrayInputStream inputStream = new ByteArrayInputStream(picByte);
					BufferedImage bi1 = ImageIO.read(inputStream);
					ImageIO.write(bi1, formartPic, file);// 不管输出什么格式图片，此处不需改动
					session.save(pictures);
					session.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new PictureMessage(true, "保存成功");
	}

	@Override
	public PictureResponse find(PictureRequest pictureRequest) {
		Date timeStr_ = pictureRequest.getTimeStr();
		Date timeEnd_ = pictureRequest.getTimeEnd();
		String f50201 = pictureRequest.getPic02();
		String pic10 = pictureRequest.getPic10();
		PictureResponse pictureResponse = new PictureResponse();
		// Session session=sessionFactory.getCurrentSession();
		// List
		// list=session.createSQLQuery("select * from picture p where p.pic02=?").setParameter(0,
		// d30101).list();
		// if(list.isEmpty()){
		// pictureResponse.setStatus(false);
		// pictureResponse.setMessage("没有与此信息相关的图片");
		// return pictureResponse;
		// }
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int parameterPageindex = pictureRequest.getParameterPageindex();
		int parameterPagesize = pictureRequest.getParameterPagesize();

		if (parameterPageindex == 0) {
			parameterPageindex = 1;
		}
		StringBuffer parameterConditionwhere = new StringBuffer();
		if (timeStr_ != null) {
			String timeStr = sdf.format(timeStr_);
			parameterConditionwhere.append(" and t.pic05_str >= '" + timeStr
					+ "'");
		}
		if (timeEnd_ != null) {
			String timeEnd = sdf.format(timeEnd_);
			parameterConditionwhere.append(" and t.pic05_str <= '" + timeEnd
					+ "'");
		}
		if (f50201 != null) {
			parameterConditionwhere.append(" and t.pic02 = '" + f50201 + "'");
		}
		if (pic10 != null && pic10 != "") {
			parameterConditionwhere.append(" and t.pic10 = '" + pic10 + "'");
		}
		Connection connection = null;
		CallableStatement callableStatement = null;
		try {
			connection = this.dataSource.getConnection();
			callableStatement = connection
					.prepareCall("{call system_package.get_pager_procedure(?, ?, ?, ?, ?, ?, ?)}");

			callableStatement.setInt(1, parameterPageindex);
			callableStatement.setInt(2, parameterPagesize);
			callableStatement.setString(3, "V_PICTURE");
			callableStatement.setString(4, parameterConditionwhere.toString());
			callableStatement.setString(5, "t.PIC01");
			callableStatement.registerOutParameter(6, OracleTypes.NUMBER);
			callableStatement.registerOutParameter(7, OracleTypes.CURSOR);
			callableStatement.execute();
			long rowCount = callableStatement.getLong(6);
			pictureResponse.setRowCount(rowCount);
			ResultSet resultSet = (ResultSet) callableStatement.getObject(7);
			VPicture vPicture = null;
			List<VPicture> vPictures = new ArrayList<VPicture>();
			while (resultSet.next()) {
				vPicture = new VPicture(resultSet.getLong("PIC01"), resultSet
						.getString("PIC02"), resultSet.getString("PIC03"),
						resultSet.getString("PIC04"), resultSet
								.getDate("PIC05"),
						resultSet.getString("PIC06"), resultSet
								.getString("PIC07"), resultSet
								.getString("PIC07_ZH"));
				vPicture.setPic05Str(resultSet.getString("pic05_str"));
				vPicture.setPic08(resultSet.getString("PIC08"));
				vPicture.setPic08Zh(resultSet.getString("pic08_zh"));
				vPicture.setPic09(resultSet.getString("PIC09"));
				vPicture.setPic09Zh(resultSet.getString("pic09_zh"));
				vPicture.setPic10(resultSet.getString("PIC10"));
				vPicture.setPic10Zh(resultSet.getString("pic10_zh"));
				vPictures.add(vPicture);
			}
			pictureResponse.setVp(vPictures);
		} catch (Exception e) {
			e.printStackTrace();
			pictureResponse.setStatus(false);
			pictureResponse.setMessage("查询失败");
			return pictureResponse;
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

			}
		}
		pictureResponse.setStatus(true);
		return pictureResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PictureMessage findById(VPicture vPicture) {
		String Imagepath = null;
		String imageName = null;
		PictureMessage pictureMessage = new PictureMessage(false, "该文件不存在");
		if (vPicture.getPic01().equals(0))
			return new PictureMessage(false, "该文件主键异常");
		Session session = sessionFactory.getCurrentSession();
		StringBuffer sql = new StringBuffer("select * from picture t where 1=1");
		if (!vPicture.getPic01().equals(null)) {
			sql.append(" and t.pic01=" + vPicture.getPic01());
		}
		List<Pictures> list = session.createSQLQuery(sql.toString()).addEntity(
				Pictures.class).list();
		if (list.isEmpty())
			return pictureMessage;
		for (Pictures pictures : list) {
			Imagepath = pictures.getPic03();
			imageName = pictures.getPic04();
		}
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(Imagepath + imageName));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
			return pictureMessage;
		} catch (IOException ex1) {
			ex1.printStackTrace();
			return pictureMessage;
		}

		pictureMessage = new PictureMessage(true, data, "图片存在");
		return pictureMessage;
	}

	@Override
	public PictureMessage deleteById(VPicture vPicture) {
		PictureMessage pictureMessage = new PictureMessage(false, "删除失败");
		if (vPicture.equals(null))
			return new PictureMessage(false, "没有选中图片");
		Session session = sessionFactory.getCurrentSession();
		Pictures pictures=(Pictures) session.get(Pictures.class,vPicture.getPic01());
	
		// 如果此列表中没有元素，则返回 true
		if (pictures==null)
			return new PictureMessage(false, "图片索引异常");
		try {
			session.delete(pictures);
			File file = new File(pictures.getPic03() + File.separator
					+ pictures.getPic04());
			// 路径为文件且不为空则进行删除
			if (file.isFile() && file.exists()) {
				Boolean flag = file.delete();
				if (flag)
					pictureMessage = new PictureMessage(true, "删除成功");
				else {
					pictureMessage = new PictureMessage(false, "删除失败");
				}
			} else {
				pictureMessage = new PictureMessage(false, "文件不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return pictureMessage;
		}
		return pictureMessage;
	}

	@Override
	public PictureMessage formartBMP(List<Object[]> picArrays) {

		PictureMessage message = new PictureMessage();
		try {
			Object[] pic = picArrays.get(0);
			String picFormart = pic[3].toString();
//			byte[] bytes = BmpReader.bmpTojpg((byte[]) pic[0], picFormart);
			byte[] bytes = BmpReader.image2RGB565Bmp((byte[]) pic[0], picFormart);
			Thread.sleep(500);
			int i = bytes.length;
			String picName = pic[1].toString().replace("bmp", picFormart);
			List<Object[]> piclist = new ArrayList<Object[]>();
			pic[0] = bytes;
			pic[1] = picName;
			pic[2] = i;
			piclist.add(pic);
			message.setPicArrays(picArrays);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return message;
	}

}
