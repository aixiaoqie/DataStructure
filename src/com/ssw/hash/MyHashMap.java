package com.ssw.hash;

import java.util.HashMap;

/**
 * * 设置有setAll功能的哈希表
 * * <p>
 * * hash表常见的三个操作时put get 和containsKey,而且这三个操作的时间复杂度为O(1).
 * * 现在加一个setAll的功能，把所有记录的value设置成统一值。请设计并实现这种setAll功能的hash表
 * * 并且put get containsKey和setAll的操作时间复杂度都为O(1).
 * * <p>
 * * 解：加入一个时间戳结果
 * * 1.把每一个记录都加上一个时间，标记每条记录时何时建立的。
 * * 2.设置一个setAll记录也加上一个时间，标记setAll记录建立的时间
 * * 3.查询记录时如果某条记录时间早于setAll的时间，说明setAll是最新数据，返回setAll记录的值。
 * * 如果某条记录玩于setAll记录的时间，说明记录的值是最新的，返回该条记录的值。
 */
public class MyHashMap<K, V> {
    private HashMap<K, MyValue<V>> baseMap;

    private long time;

    private MyValue<V> setAll;

    public MyHashMap() {
        this.baseMap = new HashMap<K, MyValue<V>>();
        this.time = 0;
        this.setAll = new MyValue<V>(null, -1);
    }

    public boolean containsKey(K key) {
        return this.baseMap.containsKey(key);
    }

    public void put(K key, V value) {
        this.baseMap.put(key, new MyValue<V>(value, this.time++));
    }

    public void setAll(V value) {
        this.setAll = new MyValue<V>(value, this.time++);
    }

    public V get(K key) {
        if (this.containsKey(key)) {
            if (this.baseMap.get(key).getTime() > this.setAll.getTime()) {
                return this.baseMap.get(key).getValue();
            } else {
                return this.setAll.getValue();
            }
        } else {
            return null;
        }
    }
}

class MyValue<V> {

    private V value;
    private long time;

    public MyValue(V value, long time) {
        this.value = value;
        this.time = time;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
