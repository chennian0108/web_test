package web.service;

import java.util.List;

import dao.IUserDao;
import dao.UserDaoImpl;

import bean.User;

public class UesrServiceImpl implements IUserService{
	private IUserDao userDao =new UserDaoImpl();

	@Override
	public List<User> findAllUsers() throws Exception {
		System.out.println("...");
		return userDao.queryAll();
	}

}
