package com.huasheng.webhandler.execute;

import com.huasheng.webhandler.config.ActionConfig;

public class ActionProxyFactory {

	public static ActionProxy createActionProxy(ActionConfig config){
		
		String name = config.getName();
		String className = config.getClassName();
		String method = config.getMethod();
		
		ActionProxy proxy = new DefaultActionProxy(name,className,method);
		
		return null;
		
	}
}
