package chapter11_collection.achapter11;

import java.util.Date;
import java.util.ArrayList;

public class TestArrayList{//��˳�����±�Ԫ�ؿ��ظ��ļ���
	public static void main(String[] args) {
		ArrayList h = new ArrayList();
		h.add("1st");
		h.add("2nd");
		h.add(new Integer(3));
		h.add(new Double(4.0));
		h.add("2nd");      // �ظ�Ԫ��, ����
		h.add(new Integer(3)); // �ظ�Ԫ��,����
		System.out.println(h);		
		System.out.println("size=" + h.size());
		System.out.println("-----�滻ָ��Ԫ��-----");	
		h.set(3,"replace");		
		System.out.println("-----forѭ������-----");
		for(int i=0;i<h.size();i++){
			System.out.println(h.get(i));}		
		System.out.println("-----ȡ���ض�Ԫ��-----");		
		Integer it = (Integer)h.get(2);
		System.out.println(it.intValue());
		System.out.println("-----����Ԫ��-----");		
		h.add(3,new Date());
		System.out.println("-----ת��Ϊ����-----");	
		Object[] os = h.toArray();
		for(Object o : os){
			System.out.println(o);	}		}}