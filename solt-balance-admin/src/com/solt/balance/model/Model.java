package com.solt.balance.model;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;

public interface Model<T> {

	public void add(T t) throws IOException;
	public List<T> getAll();
	public List<T> getWhere(Predicate<T> pred);
	public T findById(Predicate<T> pred);
	public int size();
}
