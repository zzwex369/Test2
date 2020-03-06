package com.xyw.medical.etbj.ettlzz.dao.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import oracle.net.aso.l;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xyw.medical.etbj.ettlzz.dao.E506Dao;
import com.xyw.medical.etbj.model.E504;
import com.xyw.medical.etbj.model.E505;
import com.xyw.medical.etbj.model.E506;
import com.xyw.medical.etbj.model.E506Response;
import com.xyw.sys.util.StringUtil;

public class E506DaoImpl implements E506Dao {
	@Resource
	private SessionFactory sessionFactory;

	@Override
	public E506Response delByE506Id(String id) {
		E506Response e506Response = new E506Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			if (!StringUtil.isBlankString(id)) {
				E506 e506 = (E506) session.createSQLQuery(
						"select t.* from e506 t where e506_02 = ?").addEntity(
						E506.class).setString(0, id).uniqueResult();
				if (e506 == null) {
					state = false;
					e506Response.setErrorMessage("删除失败，不存在这条信息！，请联系客服！");
				} else {
					String updateState = updateE504AndE505(e506.getE50602(),null,session);
					if("true".equals(updateState)){
						session.delete(e506);
						e506Response.setPromptMessage("删除成功！");						
					}else {
						state = false;
						e506Response.setErrorMessage("原检查信息存在问题，无法删除转诊！，请联系客服！");
					}
				}
			} else {
				state = false;
				e506Response.setErrorMessage("参数不能为空！，请联系客服！");
			}
		} catch (Exception e) {
			state = false;
			e506Response.setErrorMessage(e.getMessage());
		}
		e506Response.setState(state);
		return e506Response;
	}

	@Override
	public E506Response queryByE506Id(String id) {
		E506Response e506Response = new E506Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			if (!StringUtil.isBlankString(id)) {
				E506 e506 = (E506) session.createSQLQuery(
						"select t.* from e506 t where e506_02 = ?").addEntity(
						E506.class).setString(0, id).uniqueResult();
				if (e506 == null) {
					state = false;
					e506Response.setErrorMessage("不存在这条信息！，请联系客服！");
				} else
					e506Response.setE506(e506);
			} else {
				state = false;
				e506Response.setErrorMessage("参数不能为空！，请联系客服！");
			}
		} catch (Exception e) {
			state = false;
			e506Response.setErrorMessage(e.getMessage());
		}
		e506Response.setState(state);
		return e506Response;
	}

	@Override
	public E506Response renewE506(E506 e506) {
		E506Response e506Response = new E506Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		String updateState = null;
		try {
			if (e506 != null) {
				E506 _e506 = (E506) session.get(E506.class, e506.getE50601());
				if (_e506 == null) {
					state = false;
					e506Response.setErrorMessage("不存在这条信息，无法修改信息！，请联系客服！");
				} else {
					session.clear();
					if (e506.getE50609().getTime() != _e506.getE50609().getTime())
							updateState = updateE504AndE505(e506.getE50602(), e506.getE50609(),session);
					if (updateState == null || "true".equals(updateState)) {
						
						session.update(e506);
						session.flush();
						e506Response.setPromptMessage("修改成功！");
					} else {
						state = false;
						e506Response.setErrorMessage("原检查信息存在问题，无法修改转诊！，请联系客服！");
					}
				}
			} else {
				state = false;
				e506Response.setErrorMessage("参数不能为空！，请联系客服！");
			}
		} catch (Exception e) {
			state = false;
			e506Response.setErrorMessage(e.getMessage());
		}
		e506Response.setState(state);
		return e506Response;
	}

	@Override
	public E506Response saveE506(E506 e506) {
		E506Response e506Response = new E506Response();
		Session session = sessionFactory.getCurrentSession();
		boolean state = true;
		try {
			if (e506 != null) {
				E506 _e506 = (E506) session.createSQLQuery(
						"select t.* from e506 t where e506_02 = ?").addEntity(
						E506.class).setString(0, e506.getE50602())
						.uniqueResult();
				if (_e506 != null) {
					state = false;
					e506Response.setErrorMessage("存在相同信息，不能重复登记！，请联系客服！");
				} else {
					String updateState = updateE504AndE505(e506.getE50602(),e506.getE50609(),session);
					if ("true".equals(updateState)) {
						session.save(e506);
						session.flush();
						e506Response.setPromptMessage("保存成功！");
					} else {
						state = false;
						e506Response.setErrorMessage("原检查信息存在问题，无法保存转诊！，请联系客服！");
					}
				}
			} else {
				state = false;
				e506Response.setErrorMessage("参数不能为空！，请联系客服！");
			}
		} catch (Exception e) {
			state = false;
			e506Response.setErrorMessage(e.getMessage());
		}
		e506Response.setState(state);
		return e506Response;
	}

	@SuppressWarnings("unchecked")
	private String updateE504AndE505(String e50502, Date e50609,Session session) {
		String state = "false";
		try {
			List<E505> list = session.createSQLQuery(
					"select * from e505 where e505_02=?").addEntity(E505.class).setString(0, e50502).list();
			if (list.size() == 2) {
				for (E505 e505 : list) {
					e505.setE50533(e50609);
					session.update(e505);
				}
				E504 e504 = (E504) session.get(E504.class, e50502);
				e504.setE50469(e50609);
				session.update(e504);
				state = "true";

			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		return state;
	}

}
