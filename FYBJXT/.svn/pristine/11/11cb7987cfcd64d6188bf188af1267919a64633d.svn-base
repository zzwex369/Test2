package com.xyw.medical.fnbj.fnyqsfdj.service.impl;

import javax.annotation.Resource;
import com.xyw.medical.fnbj.fnyqsfdj.dao.PregnancyDurDao;
import com.xyw.medical.fnbj.fnyqsfdj.service.PregnancyDurService;
import com.xyw.medical.fnbj.model.F305;
import com.xyw.medical.fnbj.model.F305Request;
import com.xyw.medical.fnbj.model.F305Response;
public class PregnancyDurServiceImpl implements PregnancyDurService {
	@Resource
	private PregnancyDurDao pregnancyDurDao;
	
	@Override
	public F305Response queryF305(F305Request f305Request) {
		F305Response f305Response = pregnancyDurDao.queryF305(f305Request);
		return f305Response;
	}

	@Override
	public F305Response saveF305(F305 f305) {
		F305Response f305Response = pregnancyDurDao.saveF305(f305);
		return f305Response;
	}

	@Override
	public F305Response queryVF305(F305Request f305Request) {
		F305Response f305Response = pregnancyDurDao.queryVF305(f305Request);
		return f305Response;
	}

	@Override
	public F305Response updateF305(F305 f305) {
		F305Response f305Response = pregnancyDurDao.updateF305(f305);
		return f305Response;
	}

	@Override
	public F305Response deleteF305(F305Request f305Request) {
		F305Response f305Response = pregnancyDurDao.deleteF305(f305Request);
		return f305Response;
	}

}
