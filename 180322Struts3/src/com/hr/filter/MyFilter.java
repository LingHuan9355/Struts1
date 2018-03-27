package com.hr.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
         HttpServletRequest request = (HttpServletRequest) req;
         HttpServletResponse response = (HttpServletResponse) res;
         
         String method = request.getMethod();
         if("GET".equalsIgnoreCase(method)){
        	 Enumeration<String> ens = request.getAttributeNames();
        	 while(ens.hasMoreElements()){
        	    String name = ens.nextElement();
        	    String [] values = request.getParameterValues(name);
        	    if(values != null){
        	    	for (int i = 0; i < values.length; i++) {
						values[i] = new String(values[i].getBytes("ISO-8859-1"),"UTF-8");
					}
        	    }
        	 }
        	 
         }else if("POST".equalsIgnoreCase(method)){
               request.setCharacterEncoding("UTF-8");        	 
         }
         
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
