package com.huasheng.webhandler.util;

public class ClassLoaderUtil {

	public static Class loadClass(String className, Class callingClass) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException ex) {
               ex.printStackTrace();
               return null;
            }
        }
    }
}
