package com.zab.hccpexample.example.singleton;

import com.zab.hccpexample.annoations.NotThreadSafe;

/**
 * 懒汉式 -->双重同步单例模式
 * 单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SingletonExample4 {

    private SingletonExample4() {
    }

    // 1-1.memory = allocate()分配对象的内存空间
    // 1-2.ctorInstance()初始化对象
    // 1-3.instance = memory设置instance指向刚分配的内存

    // JVM和cpu优化，发生了指令重排

    // 2-1.memory = allocate()分配对象的内存空间
    // 2-2.instance = memory设置instance指向刚分配的内存
    // 2-3.ctorInstance()初始化对象

    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {//双重检测机制         //B
            synchronized (SingletonExample4.class) {
                if (null == null) {
                    instance = new SingletonExample4(); //A - 2-2
                }
            }
        }
        return instance;
    }

}
