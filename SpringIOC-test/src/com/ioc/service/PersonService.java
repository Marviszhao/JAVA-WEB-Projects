package com.ioc.service;

import com.ioc.dao.PersonInterface;

public class PersonService implements PersonServiceInterface{

	 private PersonInterface pdo;  
	  
	  
	public PersonInterface getPdo() {
		return pdo;
	}


	public void setPdo(PersonInterface pdo) {
		this.pdo = pdo;
	}


	@Override  
	public void save() {  
	        pdo.save();  
	}  

}
