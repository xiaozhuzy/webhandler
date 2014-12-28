package com.huasheng.webhandler.config;

import java.util.Map;

public class ActionConfig {

	private String name;
	
	private String className;
	
	private String method;
	
	protected Map<String, ResultConfig> results;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Map<String, ResultConfig> getResults() {
		return results;
	}

	public void setResults(Map<String, ResultConfig> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "ActionConfig [name=" + name + ", className=" + className
				+ ", method=" + method + ", results=" + results + "]";
	}
	
}
