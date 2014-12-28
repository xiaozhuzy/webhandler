package com.huasheng.webhandler.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huasheng.webhandler.execute.ActionMapping;

public class PrepareOperations {
	
	protected Dispatcher dispatcher;
	
	public PrepareOperations(Dispatcher dispatcher){
		this.dispatcher = dispatcher;
	}
	
	public ActionMapping findActionMapping(HttpServletRequest request, HttpServletResponse response) {

        return null;
    }
	
}
