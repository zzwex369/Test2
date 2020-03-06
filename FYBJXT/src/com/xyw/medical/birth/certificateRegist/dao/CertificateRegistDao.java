package com.xyw.medical.birth.certificateRegist.dao;

import com.xyw.medical.birth.model.D502Request;
import com.xyw.medical.birth.model.D502Response;
import com.xyw.medical.birth.model.D505Request;
import com.xyw.medical.birth.model.D505Response;
import com.xyw.medical.birth.model.D506Request;
import com.xyw.medical.birth.model.D506Response;
import com.xyw.medical.birth.model.StockRequest;
import com.xyw.medical.birth.model.StockResponse;

public interface CertificateRegistDao {
	public D502Response saveD502(D502Request d502Request);
	public D502Response queryD502(D502Request d502Request);
	public D505Response queryD505(D505Request d505Request);
	public D506Response saveD506(D506Request d506Request);
	public StockResponse queryCountD505(StockRequest StockRequest);
	public D506Response queryD506(D506Request d506Request);
	public StockResponse queryStockDetail(StockRequest stockRequest);
}
