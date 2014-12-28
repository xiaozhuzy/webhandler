package com.huasheng.webhandler.config;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.huasheng.webhandler.core.Container;
import com.huasheng.webhandler.core.ContainerBuilder;
import com.huasheng.webhandler.provider.ConfigurationProvider;
import com.huasheng.webhandler.provider.PackageProvider;

/**
 * @desc:Configuration的默认实现
 * @title:DefaultConfiguration.java
 * @author:huasheng
 * @version:1.0
 */
public class DefaultConfiguration implements Configuration {

	/**
	 * 读取xml中package节点的信息存放在map中
	 */
    protected Map<String, PackageConfig> packageConfigMaps = new LinkedHashMap<String, PackageConfig>();

	private Container container;

	// ObjectFactory objectFactory;

	@Override
	public Container getContainer() {

		return this.container;
	}

	@Override
	public PackageConfig getPackageConfig(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, PackageConfig> getPackageConfigs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void loadContainer(List<ConfigurationProvider> configurationProviders) {
		List<PackageProvider> packageProviders = new ArrayList<PackageProvider>();

		// 创建builder对象 调用factory收集参数 最后创建Container对象
		ContainerBuilder builder = new ContainerBuilder();
		for (final ConfigurationProvider configurationProvider : configurationProviders) {
			
//			初始化init provider 然后 调用register方法解析xml
			configurationProvider.init(this);
			configurationProvider.register(builder);
			packageConfigMaps = configurationProvider.getPackageConfigMaps();
		}
		
		this.container = builder.create();

	}

	@Override
	public void addPackageConfig(String name, PackageConfig packageConfig) {
		// TODO Auto-generated method stub

	}

}
