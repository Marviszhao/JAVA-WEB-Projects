package chapter11_collection.achapter11;

import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
//arrayList �����б?��ݵĴ���������������ģ�ִ�в�ѯ�����ٶȿ飬ɾ��Ԫ���ٶ���
//LinkedList ��ʽ�б� ��������������ǲ������ģ���ѯ�ٶ���ɾ��Ԫ���ٶȿ�
public class TestLinkedList{
	public static void main(String[] args) {
		LinkedList h = new LinkedList();
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