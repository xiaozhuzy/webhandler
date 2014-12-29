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
	
	private static final long serialVersionUID = -8293268128139630926L;
	/**
	 * 存放factory的map
	 */
	final Map<Key<?>, InternalFactory<?>> factories;
	
	/**
	 * 将containerBuilder收集的的factory保存到map中
	 * @param factories
	 */
	DefaultContainer(Map<Key<?>, InternalFactory<?>> factories ) {
		this.factories = factories;
	}

	@Override
	public <T> void inject(T t) {

		Class<?> clazz = t.getClass();
		
		this.inject(clazz);
	}

	@Override
	public <T> void inject(Class<T> clazz) {
		
		String name = clazz.getSimpleName();
		
		this.inject(name,clazz);
		
	}
	
	@Override
	public <T> void inject(String name,Class<T> clazz) {
		
		Scope scope = Scope.SINGLETON;
		
		final InternalFactory<?> scopedFactory = scope.scopeFactory(clazz,name);
		
		this.inject(clazz, scopedFactory);
		
		
	}
	
	@Override
	public <T> void inject(Class<T> clazz,InternalFactory<?> factory){
		
		Key<T> key = Key.newInstance(clazz, clazz.getSimpleName());
		
		factories.put(key,factory);
	}

	@Override
	public <T> T getInstance(Class<T> clazz) {
		
		String name = clazz.getSimpleName();  
		
		return this.getInstance(clazz, name);
		
	}

	@Override
	public <T> T getInstance(Class<T> clazz, String name) {
		
		Key<T> key = Key.newInstance(clazz, name);
		
		InternalFactory<?> factory = factories.get(key);
		
		T t = (T)factory.create();
		
		return t;
	}
	
}
