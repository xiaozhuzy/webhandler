package com.huasheng.webhandler.config;

import java.util.Map;


public class PackageConfig {
	
	private String name;
	
	private String namespace;
	
	private Map<String, ActionConfig> actionConfigMap;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Map<String, ActionConfig> getActionConfigMap() {
		return actionConfigMap;
	}

	public void setActionConfigMap(Map<String, ActionConfig> actionConfigMap) {
		this.actionConfigMap = actionConfigMap;
	}

	@Override
	public String toString() {
		return "PackageConfig [name=" + name + ", namespace=" + namespace
				+ ", actionConfigMap=" + actionConfigMap + "]";
	}

}
