package util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 * 常用工具类
 */
public class WebUtil {
	

	/**
	 * 发送字符串
	 */
	public static void sendResponse(final String text) {
		HttpServletResponse response = ServletActionContext.getResponse();
		write(text, response);
	}

	/**
	 * 将字符串写到response writer流中
	 */
	private static void write(final String context,
			final HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			response.setContentType("text/plain");
			response.setCharacterEncoding("utf-8");
			writer = response.getWriter();
			writer.write(context);
			writer.flush();
		} catch (IOException e) {

		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
	
	/**
	 * 返回response
	 */
	public static HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	/**
	 * 返回request
	 */
	public static HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
}
