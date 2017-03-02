package chapter11_collection.bchapter11;

import java.util.Date;
import java.util.Vector;

public class TestVector{
	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("1st");
		v.add("2nd");
		v.add(new Integer(3));
		v.add(new Double(4.0));
		v.add("2nd");      // �ظ�Ԫ��, ����
		v.add(new Integer(3)); // �ظ�Ԫ��,����
		System.out.println(v);		
		System.out.println("size=" + v.size());
		System.out.println("-----�滻ָ��Ԫ��-----");	
		v.set(3,"replace");		
		System.out.println("-----forѭ������-----");
		for(int i=0;i<v.size();i++){
			System.out.println(v.get(i));
		}		
		System.out.println("-----ȡ���ض�Ԫ��-----");		
		Integer it = (Integer)v.get(2);
		System.out.println(it.intValue());
		System.out.println("-----����Ԫ��-----");		
		v.add(3,new Date());
		System.out.println("-----ת��Ϊ����-----");	
		Object[] os = v.toArray();
		for(Object o : os){
			System.out.println(o);	
		}		
	}
}