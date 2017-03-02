package chapter11_collection.dchapter11;

import java.util.Date;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Iterator;

public class TestIterator{
	public static void main(String[] args) {
		ArrayList a = new ArrayList();
		a.add("China");
		a.add("USA");
		a.add("Korea");
		Iterator  it = a.iterator();
		//�ж�it���Ƿ���Ԫ��
		while(it.hasNext()){
//			��it��ȡ��һ��Ԫ��
			String country = (String)it.next();
			System.out.println(country);	
		}		
	}
}