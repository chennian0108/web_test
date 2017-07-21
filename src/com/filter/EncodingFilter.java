package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class EncodingFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		
		
		//过滤完之后让请求和响应继续往前传递和转发
		chain.doFilter(request, response);//主要作用是拦截request请求和response响应
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
