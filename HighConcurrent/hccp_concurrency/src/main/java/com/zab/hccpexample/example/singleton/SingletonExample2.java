package com.zab.hccpexample.example.singleton;

import com.zab.hccpexample.annoations.ThreadSafe;

/**
 * 饿汉式
 * 单例实例在类加载时进行创建
 */
@ThreadSafe
public class SingletonExample2 {

    private SingletonExample2() {
    }

    private static SingletonExample2 instance = new SingletonExample2();

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonExample2 getInstance() {
        return instance;
    }

}
