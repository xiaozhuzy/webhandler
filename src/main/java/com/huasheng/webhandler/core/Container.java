package com.huasheng.webhandler.core;

import java.io.Serializable;

/**
 * IOC框架容器
 * @title:Container.java
 * @author huasheng
 * @version 1.0
 */
public interface Container extends Serializable {

	/**
	 * 将对象注入到容器中
	 * @param t
	 */
	<T> void inject(T t);
	
	<T> void inject(Class<T> clazz);
	
	<T> void inject(String name ,Class<T> clazz);
	
	<T> void inject(Class<T> clazz,InternalFactory<?> factory);
	
	/**
	 * 从webhandler容器中获取到对象
	 * @param type
	 * @return
	 */
	<T> T getInstance(Class<T> type);
	
	<T> T getInstance(Class<T> type, String name);
	
}
