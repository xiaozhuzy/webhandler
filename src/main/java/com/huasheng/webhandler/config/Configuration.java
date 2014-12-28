package com.huasheng.webhandler.config;

import java.util.List;
import java.util.Map;

import com.huasheng.webhandler.core.Container;
import com.huasheng.webhandler.exception.ConfigurationException;
import com.huasheng.webhandler.provider.ConfigurationProvider;

/**
 * @desc:Configuration申明，用于提供管理容器的接口方法
 * @title:Configuration.java
 * @author:huasheng
 * @version:1.0
 */
public interface Configuration {

	 Container getContainer();
	 
	 /**
	  * 根据package返回Package信息
	  * @param name
	  * @return
	  */
	 PackageConfig getPackageConfig(String name);

	 /**
	  * 获取配置文件中所有的package节点信息
	  * @return
	  */
	 Map<String, PackageConfig> getPackageConfigs();
	 
	 
	 /**
	  * 根据providers加载Container容器
	  * @param containerProviders
	  * @throws ConfigurationException
	  */
	 void loadContainer(List<ConfigurationProvider> configurationProvider);
	 
	 /**
	  * 添加package节点信息到packageconfig
	  * @param name
	  * @param packageConfig
	  */
	 void addPackageConfig(String name, PackageConfig packageConfig);
	 
}
