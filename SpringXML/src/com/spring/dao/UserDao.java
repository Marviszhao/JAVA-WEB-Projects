package com.spring.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.spring.vo.UserModel;

//@Repository("userDao")
public class UserDao implements I_UserDao {

//	@Resource
	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	//	@Resource
	HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(String user_name, String pass_word) {
		jdbcTemplate.execute("insert into usertable values(null,'"+user_name+"', '"+pass_word+"')");
	}

	@Override
	public List login(String user_name, String user_psw) {
		List list = jdbcTemplate.queryForList("select * from usertable where user_name = '"
				+user_name+"' and user_psw = '"+user_psw+"'");
		return list;
	}

	@Override
	public List getAllUsers() {
		List list = jdbcTemplate.queryForList("select * from usertable");
		return list;
	}

	@Override
	public void delete(String id) {
		jdbcTemplate.execute("delete from usertable where id = '"+id+"'");
	}

	@Override
	public void update(String id, String user_psw) {
		jdbcTemplate.execute("update usertable set user_psw = '"+user_psw+"'" +
				" where id = '"+id+"'");
	}

	@Override
	public void insert(UserModel userModel) {
		hibernateTemplate.persist(userModel);
	}

	@Override
	public void update(UserModel userModel) {
		hibernateTemplate.update(userModel);
	}

}
