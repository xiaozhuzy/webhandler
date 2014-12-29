package com.huasheng.webhandler.core;

import java.util.HashMap;
import java.util.Map;

public final class ContainerBuilder {

	final Map<Key<?>, InternalFactory<?>> factories = new HashMap<Key<?>, InternalFactory<?>>();

	/**
	 * 将factory对象存放于容器中
	 */
	public <T> ContainerBuilder factory(final Class<T> type) {
		
		String name = type.getSimpleName();
		
		factory(type, name);
		
		return this;
	}
	
	public <T> ContainerBuilder factory(final Class<T> type, final String name) {
		
		Scope scope = Scope.SINGLETON ;
		
		factory(type, name, scope);
		
		return this;
	}
	
	public <T> ContainerBuilder factory(final Class<T> type, final String name,
			Scope scope) {
		
		final InternalFactory<? extends T> scopedFactory = scope.scopeFactory(type, name);
		
		factory(type, name, scope, scopedFactory);
		
		return this;
	}
	
	
	public <T> ContainerBuilder factory(final Class<T> type, final String name,
			Scope scope,InternalFactory<? extends T> factory) {
		
		Key<T> key = Key.newInstance(type,name);
		
		factories.put(key, factory);
		
		return this;
	}
	
	/**
	 * 创建container容器对象	
	 * @return
	 */
	public Container create() {
		final DefaultContainer container = new DefaultContainer(
				new HashMap<Key<?>, InternalFactory<?>>(factories));
		return container;
	}
}
