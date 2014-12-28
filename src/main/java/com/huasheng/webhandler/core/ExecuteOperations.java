package com.huasheng.webhandler.core;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huasheng.webhandler.execute.ActionMapping;

public class ExecuteOperations {

	protected Dispatcher dispatcher;
	
	public ExecuteOperations(Dispatcher dispatcher){
		this.dispatcher = dispatcher ;
	}
	
	public void executeAction(HttpServletRequest request, HttpServletResponse response, ActionMapping actionMapping) throws ServletException {
        dispatcher.serviceAction(request, response, actionMapping);
    }
}
