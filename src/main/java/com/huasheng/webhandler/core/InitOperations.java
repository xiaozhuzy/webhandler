package com.huasheng.webhandler.core;

import java.util.Map;

import com.huasheng.webhandler.filter.HostConfig;


/**
 * @desc:框架的初始化操作
 * @title:InitOperations.java
 * @author:huasheng
 * @version:1.0
 */
public class InitOperations {

	/**
	 * 
	 * @param filterConfig
	 * @return
	 */
	public Dispatcher initDispatcher(HostConfig filterConfig ) {
        Dispatcher dispatcher = createDispatcher(filterConfig);
        dispatcher.init();
        return dispatcher;
    }
	
	public Dispatcher createDispatcher(HostConfig filterConfig){
		Map<String, String> params = filterConfig.getInitParameterNames();
		
        return new Dispatcher(params);
	}
	
}
