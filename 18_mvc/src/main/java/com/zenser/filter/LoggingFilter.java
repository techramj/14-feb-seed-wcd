package com.zenser.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggingFilter
 */
@WebFilter("/*")
public class LoggingFilter extends HttpFilter implements Filter {

    
    public LoggingFilter() {
        System.out.println("filter created");
    }


	public void destroy() {
		System.out.println("filter destoryed");
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		
		String path= req.getContextPath()+req.getPathInfo();
		System.out.println(new Date()+" : "+path);
		
		chain.doFilter(request, response);
		
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("filter init called");
	}

}
