package com.xyw.medical.fnbj.fnrxajc.service;

import org.springframework.transaction.annotation.Transactional;
import com.xyw.medical.fnbj.model.L402Request;
import com.xyw.medical.fnbj.model.L402Response;
@Transactional
public interface L402Service {
	L402Response saveL402(L402Request l402Request);
	L402Response delL402(L402Request l402Request);
	L402Response renewL402(L402Request l402Request);
	L402Response queryL402(L402Request l402Request);
	L402Response queryByL402(String l40202);
}
