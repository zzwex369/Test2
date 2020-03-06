package com.xyw.sys.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * 图片上传
 * @author Administrator
 *
 */
public class FileOperation {
	/**
	 * 保存图片至服务器
	 * @param path 正式路径
	 * @param picName 图片名称
	 * @param picType 图片格式
	 */
	public static void uploadPic(String path,byte[] picByte,String picName)throws Exception{
		String picType=null;
		ByteArrayInputStream inputStream=null;
		File fil = new File(path);
		if (!fil.exists()) {
			fil.mkdirs();
		}
		File file = new File(fil + File.separator+picName);// 可以是任何图片格式.jpg,.png等
		if(picName.lastIndexOf(".")!=-1)
			picType=picName.substring(picName.lastIndexOf(".")+1);
		try {
			inputStream = new ByteArrayInputStream(picByte);
			BufferedImage bi1 = ImageIO.read(inputStream);
			ImageIO.write(bi1, picType, file);// 不管输出什么格式图片，此处不需改动
		}finally{
			if(inputStream!=null){
				inputStream.close();
			}
		}
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
	     * 删除单个文件
	     * 
	     * @param sPath
	     *            被删除文件的路径+文件名
	     * @return Object [] 0 文件  1 true or false
	     */
		 public static Object [] isDirectory(String sPath) {
			 boolean status=true;
			 Object [] fileStatus= new Object[2];
			// 如果sPath不以文件分隔符结尾，自动添加文件分隔符
		        if (!sPath.endsWith(File.separator)) {
		            sPath = sPath + File.separator;
		        }
		        File dirFile = new File(sPath);
		        fileStatus[0]=dirFile;
		        // 如果dir对应的文件不存在，或者不是一个目录，则退出
		        if (!dirFile.exists() || !dirFile.isDirectory()) {
		        	status=false;
		        }
		        fileStatus[1]=status;
		        return fileStatus;
		    }
		 
	 
	 /**
	     * 删除目录（文件夹）以及目录下的文件
	     * 
	     * @param sPath
	     *            被删除目录的文件路径
	     *        isDelFile
	     *            是否删除含有文件的目录   true 是  false 否  
	     * @return 目录删除成功返回true，否则返回false
	     */
	 public static boolean deleteDirectory(String sPath,boolean isDelFile) {
		 	Object [] fileStatus=isDirectory(sPath);
	       if(!(Boolean) fileStatus[1])
	    	   return false;
	       	File dirFile =(File) fileStatus[0];
	        Boolean flag = true;
	        // 删除文件夹下的所有文件(包括子目录)
	        File[] files = dirFile.listFiles();
	        if(files.length>0&&!isDelFile)
	        	return false;
	        for (int i = 0; i < files.length; i++) {
	            // 删除子文件
	            if (files[i].isFile()) {
	                flag = deleteFile(files[i].getAbsolutePath());//得到文件路径
	                if (!flag) break;
	            } // 删除子目录
	            else {
	                flag = deleteDirectory(files[i].getAbsolutePath(),true);//得到空目录路径
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
}
