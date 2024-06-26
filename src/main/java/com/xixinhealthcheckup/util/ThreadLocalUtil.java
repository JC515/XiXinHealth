package com.xixinhealthcheckup.util;

public class ThreadLocalUtil {
    // 提供一个ThreadLocal对象，用于存放当前线程的变量
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal<>();

    // 设置当前线程的变量
    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    // 获取当前线程的变量
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    // 清除当前线程的变量
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
