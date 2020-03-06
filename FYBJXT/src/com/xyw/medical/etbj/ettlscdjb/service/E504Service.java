package com.xyw.medical.etbj.ettlscdjb.service;

import com.xyw.medical.etbj.model.E504;
import com.xyw.medical.etbj.model.E504Request;
import com.xyw.medical.etbj.model.E504Response;

public interface E504Service {
	public E504Response saveE504(E504 e504);
	public E504Response queryE504(E504Request e504Request);
	public E504Response renewE504(E504 e504);
	public E504Response deleteE504(E504Request e504Request);
}
