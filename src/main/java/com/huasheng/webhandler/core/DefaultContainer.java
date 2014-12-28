 package com.huasheng.webhandler.core;

import java.util.Map;

/**
 * 容器默认的实现
 * @desc:
 * @title:DefaultContainer.java
 * @author:huasheng
 * @version:1.0
 */
public class DefaultContainer implements Container {
	
	final Map<Key<?>, InternalFactory<?>> factories;
	
	/**
	 * 将containerBuilder收集的的factory保存到map中
	 * @param factories
	 */
	DefaultContainer(Map<Key<?>, InternalFactory<?>> factories ) {
		this.factories = factories;
	}

	@Override
	public void inject(Object o) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T inject(Class<T> implementation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getInstance(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getInstance(Class<T> type, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	<T> InternalFactory<? extends T> getFactory( Key<T> key ) {
		return (InternalFactory<T>) factories.get(key);
	}
}
