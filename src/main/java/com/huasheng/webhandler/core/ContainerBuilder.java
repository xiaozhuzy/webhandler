package com.huasheng.webhandler.core;

import java.util.HashMap;
import java.util.Map;

public final class ContainerBuilder {

	final Map<Key<?>, InternalFactory<?>> factories = new HashMap<Key<?>, InternalFactory<?>>();

	/**
	 * ��factory��������������
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
	 * ����container��������	
	 * @return
	 */
	public Container create() {
		final DefaultContainer container = new DefaultContainer(
				new HashMap<Key<?>, InternalFactory<?>>(factories));
		return container;
	}
}
