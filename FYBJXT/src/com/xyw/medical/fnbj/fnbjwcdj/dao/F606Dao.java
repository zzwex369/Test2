package com.xyw.medical.fnbj.fnbjwcdj.dao;

import java.util.List;

import com.xyw.medical.fnbj.model.F606;
import com.xyw.medical.fnbj.model.Vf606s;

public interface F606Dao {
	/**
	 * 保存 一条无创登记信息到f606表
	 * @param f606
	 */
	void saveF606(F606 f606);
	/**
	 * 从f605表查询是否有重复
	 * @param str 身份证号
	 * @return 查询到的数量
	 */
	int findByIdFromF605(String str);
	/**
	 * 查询总数量
	 * @param str 查询的sql语句
	 * @return 查询到的总数量
	 */
	long querySum(String str);
	/**
	 * 查询具体信息
	 * @param str 查询的sql语句
	 * @return 查询到的多条数据
	 */
	List<Vf606s> queryList(String str);
	/**
	 * 删除一条数据
	 * @param sid 想要删除数据的id
	 * @return 
	 */
	int deletef606(String sid);
	/**
	 * 更新一条数据
	 * @param f606 
	 */
	void updatef606(F606 f606);
	/**
	 * 从f606表查询是否有重复
	 * @param str 身份证号
	 * @return 查询到的数量
	 */
	int findByIdFromF606(String str);
}
