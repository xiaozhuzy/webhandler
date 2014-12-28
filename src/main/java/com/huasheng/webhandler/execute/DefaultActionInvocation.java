package com.huasheng.webhandler.execute;

public class DefaultActionInvocation implements ActionInvocation {
	
	protected ActionProxy proxy;
	
	public DefaultActionInvocation(){
		
	}
	
	public DefaultActionInvocation(ActionProxy proxy){
		this.proxy = proxy ;
	}
	
	@Override
	public String invoke() {
		
		invokeAction();
		
//		executeResult();
		return null;
	}

	@Override
	public String invokeAction() {
		return null;
	}

}
