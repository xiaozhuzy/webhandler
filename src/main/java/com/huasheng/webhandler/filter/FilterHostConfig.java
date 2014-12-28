package com.huasheng.webhandler.filter;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

/**
 * @desc:包装 FilterConfig 对象用于解耦    
 * @title:FilterHostConfig.java
 * @author:huasheng
 * @version:1.0
 */
public class FilterHostConfig implements HostConfig {

	private FilterConfig filterConfig;

	
	public FilterHostConfig(FilterConfig filterConfig){
		this.filterConfig = filterConfig;
	}
	
	@Override
	public String getFilterName() {
		return filterConfig.getFilterName();
	}

	@Override
	public String getInitParameter(String key) {
		return filterConfig.getInitParameter(key);
	}

	@Override
	public Map<String, String> getInitParameterNames() {
		
		Map<String, String> paramsMap = new HashMap<String, String>();
		Enumeration<String> params = filterConfig.getInitParameterNames();
		 
		while(params.hasMoreElements()){
			 
			 String key = params.nextElement();
			 String value = this.getInitParameter(key);
			 paramsMap.put(key, value);
		 }
		
		
		return paramsMap;
	}

	@Override
	public ServletContext getServletContext() {
		return filterConfig.getServletContext();
	}
	
	
}
