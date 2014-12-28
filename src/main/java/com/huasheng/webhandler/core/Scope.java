package com.huasheng.webhandler.core;

public enum Scope {

	PROTOTYPE {
		@Override
		<T> InternalFactory<? extends T> scopeFactory(final Class<T> type,
				String name) {
			return new InternalFactory<T>() {
				T instance;
				public T create() {
					try {
						instance = type.newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return instance;
				}
			};
		}
	},

	/**
	 * One instance per container.
	 */
	SINGLETON {
		@Override
		<T> InternalFactory<? extends T> scopeFactory(final Class<T> type,
				String name) {
			return new InternalFactory<T>() {
				T instance;

				public T create() {
					synchronized (this) {
						try {
							if (instance == null) {
								instance = type.newInstance();
							}
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return instance;
					}
				}
			};
		}
	},

	THREAD {
		@Override
		<T> InternalFactory<? extends T> scopeFactory(final Class<T> type,
				String name) {
			return new InternalFactory<T>() {
				final ThreadLocal<T> threadLocal = new ThreadLocal<T>();

				public T create() {
					T t = threadLocal.get();
					if (t == null) {
						try {
							t = type.newInstance();
							threadLocal.set(t);
						} catch (InstantiationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return t;
				}
			};
		}
	};

	abstract <T> InternalFactory<? extends T> scopeFactory(Class<T> type,
			String name);
}
