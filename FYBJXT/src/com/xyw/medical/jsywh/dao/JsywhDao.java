package com.xyw.medical.jsywh.dao;

import com.xyw.medical.jsywh.model.S30109Request;
import com.xyw.medical.jsywh.model.S30109Response;

public interface JsywhDao {
	
	public S30109Response find(S30109Request s30109Request);
	public S30109Response save(S30109Request s30109Request);
	public S30109Response del(S30109Request s30109Request);
	public S30109Response update(S30109Request s30109Request);

}
