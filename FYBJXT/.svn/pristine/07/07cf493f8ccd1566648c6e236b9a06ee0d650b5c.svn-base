package com.xyw.sys.util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class BmpReader {

	
	 public static byte [] bmpTojpg(byte [] picbyte,String picFormart) {
		  byte[] bytes =null;
	        try {
	        	Image TheImage= read(picbyte);
	            int width = TheImage.getWidth(null);
	            int height = TheImage.getHeight(null);
	            BufferedImage tag = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
	            tag.getGraphics().drawImage(TheImage, 0, 0, width, height, null);
	           // FileOutputStream out = new FileOutputStream(dstFile);
	            //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	            //encoder.encode(tag);
	           // out.close();
	            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			     ImageIO.write(tag,picFormart, outputStream);//不管输出什么格式图片，此处不需改动
			     bytes= outputStream.toByteArray();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return bytes;
	    }
	 
	    public static int constructInt(byte[] in, int offset) {
	        int ret = ((int) in[offset + 3] & 0xff);
	        ret = (ret << 8) | ((int) in[offset + 2] & 0xff);
	        ret = (ret << 8) | ((int) in[offset + 1] & 0xff);
	        ret = (ret << 8) | ((int) in[offset + 0] & 0xff);
	        return (ret);
	    }
	 
	    public static int constructInt3(byte[] in, int offset) {
	        int ret = 0xff;
	        ret = (ret << 8) | ((int) in[offset + 2] & 0xff);
	        ret = (ret << 8) | ((int) in[offset + 1] & 0xff);
	        ret = (ret << 8) | ((int) in[offset + 0] & 0xff);
	        return (ret);
	    }
	 
	    public static long constructLong(byte[] in, int offset) {
	        long ret = ((long) in[offset + 7] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 6] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 5] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 4] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 3] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 2] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 1] & 0xff);
	        ret |= (ret << 8) | ((long) in[offset + 0] & 0xff);
	        return (ret);
	    }
	 
	    public static double constructDouble(byte[] in, int offset) {
	        long ret = constructLong(in, offset);
	        return (Double.longBitsToDouble(ret));
	    }
	 
	    public static short constructShort(byte[] in, int offset) {
	        short ret = (short) ((short) in[offset + 1] & 0xff);
	        ret = (short) ((ret << 8) | (short) ((short) in[offset + 0] & 0xff));
	        return (ret);
	    }
	 
	    static class BitmapHeader {
	        public int iSize, ibiSize, iWidth, iHeight, iPlanes, iBitcount,
	                iCompression, iSizeimage, iXpm, iYpm, iClrused, iClrimp;
	 
	        // 读取bmp文件头信息
	        public void read(byte [] fs) throws IOException {
	            final int bflen = 14;
	          byte bf[] = new byte[bflen];
	           // byte bf[]=null;
	          //  fs.read(bf, 0, bflen);
	           System.arraycopy(fs, 0, bf,0, bflen);
	            final int bilen = 40;
	            byte bi[] = new byte[bilen];
	            //fs.read(bi, 0, bilen);
	            System.arraycopy(fs, bflen, bi,0, bilen);
	            iSize = constructInt(bf, 2);
	            ibiSize = constructInt(bi, 2);
	            iWidth = constructInt(bi, 4);
	            iHeight = constructInt(bi, 8);
	            iPlanes = constructShort(bi, 12);
	            iBitcount = constructShort(bi, 14);
	            iCompression = constructInt(bi, 16);
	            iSizeimage = constructInt(bi, 20);
	            iXpm = constructInt(bi, 24);
	            iYpm = constructInt(bi, 28);
	            iClrused = constructInt(bi, 32);
	            iClrimp = constructInt(bi, 36);
	        }
	    }
	 
	    public static Image read(byte [] fs) {
	        try {
	            BitmapHeader bh = new BitmapHeader();
	            bh.read(fs);
	            if (bh.iBitcount == 24) {
	                return (readImage24(fs,54, bh));
	            }
	            if (bh.iBitcount == 32) {
	                return (readImage32(fs,54, bh));
	            }
	           // fs.close();
	        } catch (IOException e) {
	            System.out.println(e);
	        }
	        return (null);
	    }
	 
	    // 24位
	    protected static Image readImage24(byte []  fs,int start, BitmapHeader bh)
	            throws IOException {
	        Image image;
	        if (bh.iSizeimage == 0) {
	            bh.iSizeimage = ((((bh.iWidth * bh.iBitcount) + 31) & ~31) >> 3);
	            bh.iSizeimage *= bh.iHeight;
	        }
	        int npad = (bh.iSizeimage / bh.iHeight) - bh.iWidth * 3;
	        int ndata[] = new int[bh.iHeight * bh.iWidth];
	        byte brgb[] = new byte[(bh.iWidth + npad) * 3 * bh.iHeight];
	        //fs.read(brgb, 0, (bh.iWidth + npad) * 3 * bh.iHeight);
	        System.arraycopy(fs, start, brgb,0, (bh.iWidth + npad) * 3 * bh.iHeight);
	        int nindex = 0;
	        for (int j = 0; j < bh.iHeight; j++) {
	            for (int i = 0; i < bh.iWidth; i++) {
	                ndata[bh.iWidth * (bh.iHeight - j - 1) + i] = constructInt3(
	                        brgb, nindex);
	                nindex += 3;
	            }
	            nindex += npad;
	        }
	        image = Toolkit.getDefaultToolkit().createImage(
	                new MemoryImageSource(bh.iWidth, bh.iHeight, ndata, 0,
	                        bh.iWidth));//转换为图片
	        //fs.close();
	        return (image);
	    }
	 
	    // 32位
	    protected static Image readImage32(byte []  fs,int start, BitmapHeader bh)
	            throws IOException {
	        Image image;
	        int ndata[] = new int[bh.iHeight * bh.iWidth];
	        byte brgb[] = new byte[bh.iWidth * 4 * bh.iHeight];
	        //fs.read(brgb, 0, bh.iWidth * 4 * bh.iHeight);
	        System.arraycopy(fs, start, brgb,0, bh.iWidth * 4 * bh.iHeight);
	        int nindex = 0;
	        for (int j = 0; j < bh.iHeight; j++) {
	            for (int i = 0; i < bh.iWidth; i++) {
	                ndata[bh.iWidth * (bh.iHeight - j - 1) + i] = constructInt3(
	                        brgb, nindex);
	                nindex += 4;
	            }
	        }
	        image = Toolkit.getDefaultToolkit().createImage(
	                new MemoryImageSource(bh.iWidth, bh.iHeight, ndata, 0,
	                        bh.iWidth));//转换为图片
	       // fs.close();
	        
	        return (image);
	    }
	    
	    
	    public static byte[] int2bytes(int  [] intarr){
	    	 int bytelength=intarr.length*4;//长度
	         byte []bt=new byte[bytelength];//开辟数组
	         int curint=0;
	         for(int j=0,k=0;j<intarr.length;j++,k+=4)
	         {
	             curint= intarr[j];
	              bt[k]=(byte)((curint >> 24) & 0xff);//说明一;//右移4位，与1作与运算
	              bt[k+1]=(byte)  ( (curint>>16)& 0xff);
	              bt[k+2]=(byte)  ( (curint>>8)& 0xff);
	              bt[k+3]= (byte)  ( (curint>>0 )& 0xff);
	         }
	         return bt;

		}
	    
	    public static byte [] image2RGB565Bmp(byte [] picbyte, String picFormart) {
	    	byte[] picByte=null;
	        try {
	        	ByteArrayInputStream in = new ByteArrayInputStream(picbyte);    //将b作为输入流；
	            BufferedImage sourceImg = ImageIO.read(in);
	            int h = sourceImg.getHeight(), w = sourceImg.getWidth();
	            int[] pixel = new int[w * h];
	            PixelGrabber pixelGrabber = new PixelGrabber(sourceImg, 0, 0, w, h, pixel, 0, w);
	            pixelGrabber.grabPixels();

	            MemoryImageSource m = new MemoryImageSource(w, h, pixel, 0, w);
	            Image image = Toolkit.getDefaultToolkit().createImage(m);
	            BufferedImage buff = new BufferedImage(w, h, BufferedImage.TYPE_USHORT_565_RGB);
	            buff.createGraphics().drawImage(image, 0, 0 ,null);
	            ByteArrayOutputStream out = new ByteArrayOutputStream();
	            boolean flag = ImageIO.write(buff, "jpg", out);
	            if(flag)
	            	picByte = out.toByteArray();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return picByte;
	    }
}
