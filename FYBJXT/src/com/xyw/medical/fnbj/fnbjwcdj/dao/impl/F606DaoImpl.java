package com.xyw.medical.fnbj.fnbjwcdj.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xyw.medical.fnbj.fnbjwcdj.dao.F606Dao;
import com.xyw.medical.fnbj.model.F606;
import com.xyw.medical.fnbj.model.Vf606s;


public class F606DaoImpl implements F606Dao{

	@Autowired
	private SessionFactory factory;
	@Override
	public void saveF606(F606 f606) {
		Session session = null;
		try {
			session = factory.openSession();
			session.save(f606);
			session.flush();
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public int findByIdFromF605(String str) {
		Session session = null;
		int i;
		try {
			session = factory.openSession();
			String sql = "select f605_01 from f605 where f605_07 = ? ";
			i = session.createSQLQuery(sql).setString(0, str).executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return i;
	}

	@Override
	public long querySum(String str) {
		Session session = null;
		long i = 0;
		try {
			session = factory.openSession();
			List list = session.createSQLQuery(str).list();
			i = Long.parseLong(list.get(0).toString());
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vf606s> queryList(String str) {
		Session session = null;
		List<Vf606s> list;
		try {
			session = factory.openSession();
			list = session.createSQLQuery(str).addEntity(Vf606s.class).list();
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public int deletef606(String sid) {
		Session session = null;
		int i;
		try {
			session = factory.openSession();
			String sql = "delete f606 where f606_01=?";
			i = session.createSQLQuery(sql).setString(0, sid).executeUpdate();
			session.flush();
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return i;
	}

	@Override
	public void updatef606(F606 f606) {
		Session session = null;
		try {
			session = factory.openSession();
			session.update(f606);
			session.flush();
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
	}

	@Override
	public int findByIdFromF606(String str) {
		Session session = null;
		int i;
		try {
			session = factory.openSession();
			String sql = "select f606_01 from f606 where f606_05 = ?";
			i = session.createSQLQuery(sql).setString(0, str).executeUpdate();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}finally {
			if(session!=null) {
				session.close();
			}
		}
		return i;
	} 

}
