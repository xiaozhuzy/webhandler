package com.huasheng.webhandler.core;

public class ContainerHolder {

	private static ThreadLocal<Container> instance = new ThreadLocal<Container>();

    public static void store(Container instance) {
        ContainerHolder.instance.set(instance);
    }

    public static Container get() {
        return ContainerHolder.instance.get();
    }

    public static void clear() {
        ContainerHolder.instance.remove();
    }
}
