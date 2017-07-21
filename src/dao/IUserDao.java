package dao;

import java.util.List;

import bean.User;


public interface IUserDao {
	
	List<User> queryAll()throws Exception;

}
