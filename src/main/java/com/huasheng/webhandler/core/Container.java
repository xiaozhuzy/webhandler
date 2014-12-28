package com.huasheng.webhandler.core;

import java.io.Serializable;

/**
 * IOC框架容器
 * @title:Container.java
 * @author huasheng
 * @version 1.0
 */
public interface Container extends Serializable {

	void inject(Object o);

	<T> T inject(Class<T> implementation);

	<T> T getInstance(Class<T> type);
	
	<T> T getInstance(Class<T> type, String name);

}
