package com.xyw.medical.fnbj.fnyqsfdj.service;

import org.springframework.transaction.annotation.Transactional;

import com.xyw.medical.fnbj.model.F305;
import com.xyw.medical.fnbj.model.F305Request;
import com.xyw.medical.fnbj.model.F305Response;
@Transactional
public interface PregnancyDurService {
	public F305Response queryF305(F305Request f305Request);
	public F305Response saveF305(F305 f305);
	public F305Response queryVF305(F305Request f305Request);
	public F305Response updateF305(F305 f305);
	public F305Response deleteF305(F305Request f305Request);
}
