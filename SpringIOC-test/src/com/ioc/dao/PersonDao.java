package com.ioc.dao;

public class PersonDao implements PersonInterface{

	@Override
	public void save() {
		System.out.println("dao ±£´æ");
	}
	
}
