package com.huasheng.webhandler.config;

import java.util.List;

import com.huasheng.webhandler.provider.ConfigurationProvider;
import com.huasheng.webhandler.provider.ContainerProvider;
import com.huasheng.webhandler.provider.PackageProvider;

/**
 * @desc:管理 Configuration对象 以及容器中的各个 provider
 * @title:ConfigurationManager.java
 * @author:huasheng
 * @version:1.0
 */
public class ConfigurationManager {

	protected Configuration configuration;
	
	protected List<ConfigurationProvider> containerProviders;
	
	protected List<PackageProvider> packageProviders;
	
	public synchronized Configuration getConfiguration(){
		if (configuration == null) {
            setConfiguration(createConfiguration());
            configuration.loadContainer(getContainerProviders());
		}
        return configuration;
	}
	
	
	protected Configuration createConfiguration() {
        return new DefaultConfiguration();
    }

    public synchronized void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
	
    public List<ConfigurationProvider> getContainerProviders(){
    	
    	return this.containerProviders;
    }
    
    public void addConfigurationProvider(ConfigurationProvider provider) {
        if (!containerProviders.contains(provider)) {
            containerProviders.add(provider);
        }
    }
}
