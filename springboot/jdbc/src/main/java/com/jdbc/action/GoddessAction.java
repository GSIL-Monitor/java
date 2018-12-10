package com.jdbc.action;

import com.jdbc.dao.GoddessDao;
import com.jdbc.Entity.Goddess;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class GoddessAction {
	public void add(Goddess goddess) throws SQLException {
		GoddessDao dao=new GoddessDao();
		goddess.setSex(1);
		goddess.setCreate_user("ADMIN");
		goddess.setUpdate_user("ADMIN");
		goddess.setIsdel(0);
		dao.addGoddess(goddess);
	}

	public void delete(Integer id) throws SQLException {
		GoddessDao dao=new GoddessDao();
		dao.deleteGoddess(id);
	}

	public void update(Goddess goddess) throws SQLException {
		GoddessDao dao=new GoddessDao();
		dao.updateGoddess(goddess);
	}

	public List<Goddess> query() throws SQLException {
		GoddessDao dao=new GoddessDao();
		return dao.query();
	}

	public List<Goddess> query(List<Map<String, Object>> params) throws SQLException {
		GoddessDao dao=new GoddessDao();
		return dao.query(params);
	}


	public Goddess get(Integer id) throws SQLException {
		GoddessDao dao=new GoddessDao();
		return dao.get(id);
	}
}
