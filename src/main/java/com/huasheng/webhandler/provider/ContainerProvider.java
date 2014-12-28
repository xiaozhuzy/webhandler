package com.huasheng.webhandler.provider;

import com.huasheng.webhandler.config.Configuration;
import com.huasheng.webhandler.core.ContainerBuilder;
import com.huasheng.webhandler.exception.ConfigurationException;


public interface ContainerProvider {

	/**
	 * 初始化 Configuration
	 * @param configuration
	 * @throws ConfigurationException
	 */
	public void init(Configuration configuration);
	
	/**
	 * 往IOC容器(Container)中注册将要被容器托管的对象 获取到Java对象 
	 * @param builder
	 * @param props
	 * @throws ConfigurationException
	 */
    public void register(ContainerBuilder builder);
    
}
