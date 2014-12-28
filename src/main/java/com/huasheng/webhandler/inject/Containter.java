package com.huasheng.webhandler.inject;

public interface Containter {

	/**
	 * 将对象注入到容器中
	 * @param o
	 */
	void inject(Object o);

	<T> T inject(Class<T> implementation);
	
	/**
	 * 从webhandler容器中获取到对象
	 * @param type
	 * @return
	 */
	<T> T getInstance(Class<T> type);
	
	
	<T> T getInstance(Class<T> type, String name);
	
}
