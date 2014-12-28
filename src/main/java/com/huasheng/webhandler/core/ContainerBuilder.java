package com.huasheng.webhandler.core;

import java.util.HashMap;
import java.util.Map;

public final class ContainerBuilder {

	final Map<Key<?>, InternalFactory<?>> factories = new HashMap<Key<?>, InternalFactory<?>>();

	/**
	 * ��factory��������������
	 */
	public <T> ContainerBuilder factory(final Class<T> type, final String name,
			Scope scope) {
		
		Key<T> key = Key.newInstance(type,name);
		final InternalFactory<? extends T> scopedFactory = scope.scopeFactory(type, name);
		factories.put(key, scopedFactory);
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
