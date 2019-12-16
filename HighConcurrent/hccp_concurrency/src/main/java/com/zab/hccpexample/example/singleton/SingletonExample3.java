package com.zab.hccpexample.example.singleton;

import com.zab.hccpexample.annoations.NotRecommend;
import com.zab.hccpexample.annoations.ThreadSafe;

/**
 * 懒汉式
 * 单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    private SingletonExample3() {
    }

    private static SingletonExample3 instance = null;

    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }

}
