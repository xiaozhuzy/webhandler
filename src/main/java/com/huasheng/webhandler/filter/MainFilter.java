package com.huasheng.webhandler.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huasheng.webhandler.core.Dispatcher;
import com.huasheng.webhandler.core.ExecuteOperations;
import com.huasheng.webhandler.core.InitOperations;
import com.huasheng.webhandler.core.PrepareOperations;
import com.huasheng.webhandler.execute.ActionMapping;

/**
 * 
 * @desc:框架 的入口Filter
 * @title:MainFilter.java
 * @author:huasheng
 * @version:1.0
 */
public class MainFilter implements Filter {

	PrepareOperations prepare = null;
	ExecuteOperations execute = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		InitOperations initOperations = new InitOperations();

		/**
		 * 封装filterConfig
		 */
		HostConfig hostConfig = new FilterHostConfig(filterConfig);

		/**
		 * 创建Dispatcher对象
		 */
		Dispatcher dispatcher = initOperations.initDispatcher(hostConfig);

		prepare = new PrepareOperations(dispatcher);
		execute = new ExecuteOperations(dispatcher);

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		
		prepare.assignDispatcherToThread();
		//根据请求的url返回对应的actionmapping对象
		ActionMapping mapping = prepare.findActionMapping(request, response);
		if (mapping == null) {
			chain.doFilter(request, response);
		} else {
			//执行action  //未完 待继续
			execute.executeAction(request, response, mapping);
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
