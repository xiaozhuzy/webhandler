package com.huasheng.webhandler.core;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.huasheng.webhandler.config.Configuration;
import com.huasheng.webhandler.config.ConfigurationManager;
import com.huasheng.webhandler.execute.ActionMapping;
import com.huasheng.webhandler.provider.ConfigurationProvider;
import com.huasheng.webhandler.provider.impl.XmlConfigurationProvider;

/**
 * 核心分发类
 * @desc:
 * @title:Dispatcher.java
 * @author:huasheng
 * @version:1.0
 */
public class Dispatcher {

	private static ThreadLocal<Dispatcher> instance = new ThreadLocal<Dispatcher>();

	private static final String DEFAULT_CONFIGURATION_PATHS = "webhandler-default.xml,webhandler.xm";

	private ConfigurationManager configurationManager;

	protected Map<String, String> initParams;

	public Dispatcher() {

	}

	public Dispatcher(Map<String, String> params) {
		this.initParams = params;
	}

	/**
	 * 初始化Dispatcher对象
	 */
	public void init() {

		// 初始化configurationManager对象
		if (configurationManager == null) {
			configurationManager = createConfigurationManager();
		}

		// 初始化解析xml的provider
		initXmlConfigurations();

		// 加载容器对象
		Container container = getContainer();

	}

	String configPaths = initParams.get("config");

	/**
	 * 初始化配置文件信息
	 */
	private void initXmlConfigurations() {
		if (configPaths == null) {
			configPaths = DEFAULT_CONFIGURATION_PATHS;
		}
		String[] files = configPaths.split("\\s*[,]\\s*");
		for (String file : files) {
			if (file.endsWith(".xml")) {
				configurationManager
						.addConfigurationProvider(createXmlConfigurationProvider(file));
			}
		}
	}

	private ConfigurationProvider createXmlConfigurationProvider(String file) {
		return new XmlConfigurationProvider(file);
	}

	private Container getContainer() {
		if (this.configurationManager == null) {
			throw new IllegalStateException(
					"The configuration manager shouldn't be null");
		} else {
			Configuration configuration = this.configurationManager
					.getConfiguration();
			if (configuration == null) {
				throw new IllegalStateException("Unable to load configuration");
			} else {
				Container container = configuration.getContainer();
				return container;
			}
		}
	}

	private ConfigurationManager createConfigurationManager() {
		return new ConfigurationManager();
	}

	public void serviceAction(HttpServletRequest request,
			HttpServletResponse response, ActionMapping actionMapping) {

		// 创建actionProxy

	}
}
