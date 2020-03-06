package com.xyw.medical.fnbj.fnbjxqsq.dao;

import com.xyw.medical.fnbj.model.F601;
import com.xyw.medical.fnbj.model.F601Request;
import com.xyw.medical.fnbj.model.F601Response;

public interface F601Dao {
	public F601Response saveF601(F601 f601);
	
	public F601Response renewF601(F601 f601);
	
	public F601Response renewF601(F601Request f601Request);
	
	public F601Response deleteF601(F601Request f601Request);

	public F601Response queryByF60155(String f60155);

	public F601Response queryF601(F601Request f601Request);
	
	public F601Response queryF601Excel(F601Request f601Request);
		
	public F601Response queryRevocationF601(F601Request f601Request);
	/**
	 * 
	 * @Description 以前的查询方法无法多次重用
	 * @author lb
	 * @param f601Request
	 * @return
	 * F601Response
	 */
	public F601Response queryF601_(F601Request f601Request);
}
