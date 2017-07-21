package com.zzqg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;// 序列化的版本号
	//private String name;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//解决POST方式提交数据的是乱码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");

		
		System.out.println("name="+name);
		
		//准备跳转的页面
		String page="/test.jsp";
		//获得一个跳转的对象，并指定好要跳转的页面
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(page);
		//进行页面的跳转，并且把请求和响应对象转发过去
		requestDispatcher.forward(request,response);
		
		
		
		
		/*response.setContentType("test/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>测试页面</title>");
		out.println("</head>");
		out.println("<body>");
//		for(int i=1;i<num;i++){
		out.println("<h1>Hello World!"+name+"</h1>");
//		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		*/
		

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
