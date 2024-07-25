package com.epsillon.Controller;

public interface CRUD<T> {
	public int add(T t);
	
	public int delete(int id);
	
	public int update(T t);
}
