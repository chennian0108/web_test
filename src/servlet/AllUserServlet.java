package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.IUserService;
import web.service.UesrServiceImpl;

import bean.User;



public class AllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public IUserService userService=new UesrServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list=null;
		try {
			list=userService.findAllUsers();
			System.out.println(list);
			request.setAttribute("allUsers",list);
			//把request以及数据带回到页面中去
			String page="/show_users.jsp";
			request.getRequestDispatcher(page).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
