package web.service;

import java.util.List;

import bean.User;

public interface IUserService {
	
	List<User> findAllUsers()throws Exception;

}
