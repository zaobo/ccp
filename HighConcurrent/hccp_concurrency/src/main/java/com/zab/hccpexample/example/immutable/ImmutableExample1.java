package com.zab.hccpexample.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.zab.hccpexample.annoations.ThreadSafe;

@ThreadSafe
public class ImmutableExample1 {

    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4, 5, 6, 7, 8);

    private final static ImmutableMap<Integer, Integer> map1 = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).build();

    public static void main(String[] args) {
        System.out.println(map.get(3));
    }

}
