package com.xyw.medical.birth.deliveryRegist.service;

import com.xyw.medical.birth.model.D601;
import com.xyw.medical.birth.model.D602;
import com.xyw.medical.birth.model.D603;
import com.xyw.medical.birth.model.QueryBirthRequest;
import com.xyw.medical.birth.model.QueryBirthResponse;
import com.xyw.medical.birth.model.ZyfmdjbRequest;
import com.xyw.medical.birth.model.ZyfmdjbResponse;

public interface DeliveryService {
	public QueryBirthResponse saveDeliveryRegist(D601 d601);
	
	public QueryBirthResponse queryDeliveryRegist(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse queryDeliveryInfo(QueryBirthRequest queryBirthRequest);
	
	public QueryBirthResponse saveD603Info(D603 d603);
	
	public QueryBirthResponse renewDelivery(D601 d601);
	
	public QueryBirthResponse saveHealthcareInfo(D602 d602);

	public QueryBirthResponse deleteD601(QueryBirthRequest queryBirthRequest);
	
	public ZyfmdjbResponse pagerZyfmdjb(ZyfmdjbRequest zyfmdjbRequest);

}
