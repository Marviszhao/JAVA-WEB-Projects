package com.rest.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.rest.vo.UserModel;

@Repository("userDao")
public class UserDao  extends SqlMapClientDaoSupport implements I_UserDao {

	@Resource(name="sqlMapClient")
	
	public void setSqlMapClientWorkAround(SqlMapClient sqlMapClient){
		this.setSqlMapClient(sqlMapClient);
	}
	
	@Override
	public void addUser(Map map) {
		getSqlMapClientTemplate().insert("User.addUser",map);
	}

	@Override
	public UserModel getUser(Map map) {
		List<UserModel> list = (List<UserModel>)getSqlMapClientTemplate().queryForList("User.getUser",map);
		if (list != null && list.size()>0) {
			System.out.println(list.size());
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<UserModel> getAllUser() {
		
		return getSqlMapClientTemplate().queryForList("User.getAllUser");
	}

	@Override
	public void delete(String userID) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", userID);
		getSqlMapClientTemplate().delete("User.deleteUser",map);
	}

	@Override
	public void update(Map<String, String> aMap) {
		getSqlMapClientTemplate().update("User.updateUser",aMap);
	}

}
