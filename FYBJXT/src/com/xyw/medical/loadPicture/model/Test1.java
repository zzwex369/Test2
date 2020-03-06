package com.xyw.medical.loadPicture.model;

import org.junit.Test;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class Test1 {
	 static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	    public static void main(String[] args) {
	        //     System.out.println(getImageBinary());

	        base64StringToImage("c://Jellyfish.jpg","c://Jellyfish.cdr");
	    }
	    
	    static String getImageBinary(String fileName){
	        File f = new File(fileName);
	        BufferedImage bi;
	        try {
	            bi = ImageIO.read(f);
	            String fileType=getFileType(fileName);
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            ImageIO.write(bi, fileType, outputStream);
	            byte[] bytes = outputStream.toByteArray();

	            return encoder.encodeBuffer(bytes).trim();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	    static String getFileType(String fileName){
	        return fileName.substring(fileName.indexOf(".")+1,fileName.length());
	    }

	    /**
	     * 将其他格式的图片转换成CDR或其它文件格式
	     * @param sourceFileName
	     * @param newFileName
	     */
	    static void base64StringToImage(String sourceFileName,String newFileName){
	        try {
	            String base64String =getImageBinary(sourceFileName);
	            byte[] bytes1 = decoder.decodeBuffer(base64String);
	            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes1);
	            BufferedImage bi1 =ImageIO.read(inputStream);
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	            File w2 = new File(newFileName);//可以是jpg,png,gif格式
	            ImageIO.write(bi1, getFileType(sourceFileName), w2);//不管输出什么格式图片，此处不需改动
	           // byte[] bytes = outputStream.toByteArray();
	            //System.out.println(encoder.encodeBuffer(bytes).trim());
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	@Test
	public void test01(){
		String srcfile = "C:\\Users\\Joe\\Desktop\\082242882_1530001203305.bmp";
		String dstFile = "C:\\Users\\Joe\\Desktop\\bbbimg.jpg";
		  base64StringToImage(srcfile,dstFile);
	}
}
