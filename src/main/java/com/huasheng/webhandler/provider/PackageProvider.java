package com.huasheng.webhandler.provider;

import java.util.Map;

import com.huasheng.webhandler.config.Configuration;
import com.huasheng.webhandler.config.PackageConfig;
import com.huasheng.webhandler.exception.ConfigurationException;

public interface PackageProvider {

	/**
	 * 初始化provider
	 * @param configuration
	 * @throws ConfigurationException
	 */
	public void init(Configuration configuration) throws ConfigurationException;
	
	/**
	 * 加载package元素
	 * @throws ConfigurationException
	 */
	public void loadPackages() throws ConfigurationException;
	

	/**
	 * 获取package信息
	 * @return
	 */
	public Map<String,PackageConfig> getPackageConfigMaps();
}
