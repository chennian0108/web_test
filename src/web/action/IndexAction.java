package web.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import web.service.IUserService;
import web.service.UesrServiceImpl;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {


	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private User user;
	private List<User> allUsers;
	private IUserService userService=new UesrServiceImpl();
	
	/*@Override
	public String execute()throws Exception{
		//String SUCCESS="success";
		return SUCCESS;
	}*/
	@Action(value="index",results={@Result(name="success",location="/show_users.jsp")})
	public String index(){
		try {
			allUsers=userService.findAllUsers();
			System.out.println("index = "+allUsers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<User> getAllUsers() {
		return allUsers;
	}
	public void setAllUsers(List<User> allUsers) {
		this.allUsers = allUsers;
	}
	@Override
	public String toString() {
		return "IndexAction [id=" + id + ", name=" + name + ", user=" + user
				+ ", allUsers=" + allUsers + ", userService=" + userService
				+ "]";
	}
	
	
	

}
