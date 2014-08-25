package com.jdc.ls7.ep3;

public class T2Pair<K, V> implements T1Pair<K, V> {
	
	private K key;
	private V value;
	
	public T2Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	@Override
	public K key() {
		return key;
	}

	@Override
	public V value() {
		return value;
	}

}
