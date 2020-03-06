package com.xyw.medical.pictureFactory;

import java.io.File;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.xyw.medical.loadPicture.model.PictureMessage;
import com.xyw.medical.loadPicture.model.Pictures;

public class CCbg {
	@SuppressWarnings("unchecked")
	public static PictureMessage deletePics(String index,Session session){
		String picPath=null;//图片目录路径
		String pic10=null;//图片类型
		//得到相同pic02 的一条信息
		SQLQuery sqlQuery=session.createSQLQuery("select * from picture t where t.pic02=?").addEntity(Pictures.class);
		sqlQuery.setParameter(0, index);
		List<Pictures> list=sqlQuery.list();
		if(list.isEmpty())return new PictureMessage(false,"不存在图片记录，无法删除");
		for(Pictures pictures:list){
				picPath=pictures.getPic03();//得到路径  E:\cs_csyxzmweb\wsjd_picture\01\1201\02\
				pic10=pictures.getPic10();
				break;
		}
		String picDirectory=picPath.substring(0, picPath.lastIndexOf(pic10));
		 File fil=new File(picDirectory);
		 if(!fil.exists())return new PictureMessage(false,"该图片不存在");
		 boolean flag=deleteDirectory(picDirectory);
		 if(!flag)return new PictureMessage(false,"删除图片路径失败");
		 try {
				int count=session.createSQLQuery("delete from picture t where t.pic02=?").setString(0,index).executeUpdate();
		} catch (Exception e) {
			return new PictureMessage(false,"删除图片信息失败");
		}
		 
		return new PictureMessage(flag,"删除图片成功") ;
	}
	/**
     * 删除单个文件
     * 
     * @param sPath
     *            被删除文件的路径+文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
	 public static boolean deleteFile(String sPath) {
	        Boolean flag = false;
	        File file = new File(sPath);
	        // 路径为文件且不为空则进行删除
	        if (file.isFile() && file.exists()) {
	            file.delete();
	            flag = true;
	        }
	        return flag;
	    }
	 /**
	     * 删除目录（文件夹）以及目录下的文件
	     * 
	     * @param sPath
	     *            被删除目录的文件路径
	     * @return 目录删除成功返回true，否则返回false
	     */
	 public static boolean deleteDirectory(String sPath) {
	        // 如果sPath不以文件分隔符结尾，自动添加文件分隔符
	        if (!sPath.endsWith(File.separator)) {
	            sPath = sPath + File.separator;
	        }
	        File dirFile = new File(sPath);
	        // 如果dir对应的文件不存在，或者不是一个目录，则退出
	        if (!dirFile.exists() || !dirFile.isDirectory()) {
	            return false;
	        }
	        Boolean flag = true;
	        // 删除文件夹下的所有文件(包括子目录)
	        File[] files = dirFile.listFiles();
	        for (int i = 0; i < files.length; i++) {
	            // 删除子文件
	            if (files[i].isFile()) {
	                flag = deleteFile(files[i].getAbsolutePath());//得到文件路径
	                if (!flag) break;
	            } // 删除子目录
	            else {
	                flag = deleteDirectory(files[i].getAbsolutePath());//得到空目录路径
	                if (!flag) break;
	            }
	        }
	        if (!flag) return false;
	        // 删除当前目录
	        if (dirFile.delete()) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	public static void main(String arg[]){
		String picPath="E:/cs_csyxzmweb/wsjd_picture/01/1201/02/";
		String picDirectory=picPath.substring(0, picPath.lastIndexOf("02"));
		boolean success=deleteDirectory(picDirectory);
		System.out.println(picDirectory+"----------------------");
	}
}
