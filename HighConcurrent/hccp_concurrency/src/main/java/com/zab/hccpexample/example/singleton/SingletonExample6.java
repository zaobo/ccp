package com.zab.hccpexample.example.singleton;

import com.zab.hccpexample.annoations.ThreadSafe;

/**
 * 饿汉式
 * 单例实例在类加载时进行创建
 */
@ThreadSafe
public class SingletonExample6 {

    private SingletonExample6() {
    }

    private static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    /**
     * 静态的工厂方法
     * @return
     */
    public static SingletonExample6 getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }

}
