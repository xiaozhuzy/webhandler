package com.huasheng.webhandler.filter;

import java.util.Map;

import javax.servlet.ServletContext;

public interface HostConfig {

	public String getFilterName();

	public String getInitParameter(String arg0);

	public Map<String, String> getInitParameterNames() ;

	public ServletContext getServletContext();
	
}
