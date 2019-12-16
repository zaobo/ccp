package com.zab.hccpexample.example.singleton;

import com.zab.hccpexample.annoations.ThreadSafe;

/**
 * 懒汉式 -->双重同步单例模式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
public class SingletonExample5 {

    private SingletonExample5() {
    }

    // 1-1.memory = allocate()分配对象的内存空间
    // 1-2.ctorInstance()初始化对象
    // 1-3.instance = memory设置instance指向刚分配的内存

    // 单例对象 volatile+双重检测机制——》禁止指令重排
    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {//双重检测机制
            synchronized (SingletonExample5.class) {
                if (null == null) {
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }

}
