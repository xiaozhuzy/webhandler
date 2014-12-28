package com.huasheng.webhandler.core;

public class Key<T> {

	final Class<T> type;

	final String name;

	private Key(Class<T> type, String name) {
		if (type == null) {
			throw new NullPointerException("Type is null.");
		}
		if (name == null) {
			throw new NullPointerException("Name is null.");
		}

		this.type = type;
		this.name = name;

	}

	Class<T> getType() {
		return type;
	}

	String getName() {
		return name;
	}

	static <T> Key<T> newInstance(Class<T> type, String name) {
		return new Key<T>(type, name);
	}
}
