package com.huasheng.webhandler.execute;

import com.huasheng.webhandler.config.ActionConfig;
import com.huasheng.webhandler.config.Configuration;

public class DefaultActionProxy implements ActionProxy {

	protected Configuration configuration;
    protected ActionConfig config;
    protected ActionInvocation invocation;
    
    protected String actionName;
    protected String className;
    protected String method;
    
    public DefaultActionProxy(String actionName,String className,String method){
    	this.actionName = actionName;
    	this.className = className;
    	this.method = method;
    }
    
	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	public ActionConfig getConfig() {
		return config;
	}

	public void setConfig(ActionConfig config) {
		this.config = config;
	}

	public ActionInvocation getInvocation() {
		return invocation;
	}



	public void setInvocation(ActionInvocation invocation) {
		this.invocation = invocation;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public void execute() {
		
		this.invocation = new DefaultActionInvocation(this);
		
		invocation.invoke();
	}

}
