package web.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import util.JsonUtil;
import util.WebUtil;
import web.service.UesrServiceImpl;
import web.service.IUserService;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class JsonAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private IUserService userService=new UesrServiceImpl();
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Action("getJsonStr")
	public void getJsonStr(){
//		User u=new User(1L,"tom");
		List<User> list=new ArrayList<>();
		list.add(new User(1L,"tom"));
		list.add(new User(2L,"tom1"));
		list.add(new User(3L,"tom2"));
		list.add(new User(4L,"tom3"));
		list.add(new User(5L,"tom4"));
		String jsonStr=JsonUtil.getJsonArrayFromObject(list);
//			String jsonStr="{\"id\":1,\"name\":\"tom\"}";
			System.out.println(jsonStr);
			WebUtil.sendResponse(jsonStr);
		
	}
	@Action("getUser")
	public void getUser(){
		User u=new User(1L,"tom");
		String jsonStr=JsonUtil.getJsonArrayFromObject(u);
		WebUtil.sendResponse(jsonStr);
	}
	@Action("findAllUser")
	public void findAllUser(){
		try {
			List<User> list=userService.findAllUsers();
			String jsonStr=JsonUtil.getJsonArrayFromObject(list);
			WebUtil.sendResponse(jsonStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Action("deleteUser")
	public void deleteUser(){
		
		String json = "{\"msg\":\"OK\"}";
		WebUtil.sendResponse(json);
		//System.out.println();
		
		
	}
	
	@Action(value="showIndexPage",results={@Result(name="success",location="/show_users.jsp")})
	public String showIndexPage(){
		return SUCCESS;
	}

}
