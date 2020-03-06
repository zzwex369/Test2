package com.xyw.medical.birth.report.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PrintInfo {
	private String path;
	private String label;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public boolean setProperties(Properties properties) {
		boolean flag = false;
		FileOutputStream fos = null;
		try {
			File file = new File(this.path + "/setup/" + this.label);
			if(!file.exists()) {
				file.createNewFile();
			}else {
				boolean fl = file.delete();
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			properties.store(fos, "PRINT_SETTINGS_COMMENT");
			flag = true;
		} catch(Exception e) {
			flag = false;
		} finally {
			if(fos != null) {
				try {
					fos.close();
					fos = null;
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return flag;
	}
	
	public Properties getProperties() {
		FileInputStream fis = null;
		Properties properties = null;
		try {
			File file = new File(this.path + "/setup/" + this.label);
			fis = new FileInputStream(file);
			properties = new Properties();
			properties.load(fis);
		} catch(Exception e) {
			properties = null;
			e.printStackTrace();
		} finally {
			try{
				fis.close();
				fis = null;
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	public boolean changeProperties(){
		boolean flag = false;
		FileOutputStream fileOutputStream=null;
		FileInputStream fileInputStream=null;
		try {
			File standardFile = new File(this.path + "/setup/" +"BIRTH_PRINTINFO_NEW_Standard.ini");
			File file = new File(this.path + "/setup/" + this.label);

			if(!file.exists()) {
				file.createNewFile();
			}else {
				boolean fl = file.delete();
				file.createNewFile();
			}
			fileInputStream=new FileInputStream(standardFile);
			fileOutputStream=new FileOutputStream(file);
			int d=-1;
			while ((d=fileInputStream.read())!=-1) {
				fileOutputStream.write(d);
			}
			flag=true;
		}catch (Exception e) {
			flag = false;
		}finally{
			try {
				fileInputStream.close();
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
