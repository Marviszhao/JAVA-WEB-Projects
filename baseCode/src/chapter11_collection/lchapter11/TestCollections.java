package chapter11_collection.lchapter11;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class TestCollections{
	public static void main(String[] args) {
		ArrayList alist = new ArrayList();
		alist.add(75); 
		alist.add(38); 
		alist.add(21); 
		alist.add(4); 
		alist.add(12); 

		System.out.println("ԭ�б�: " + alist);
		Collections.sort(alist);
		System.out.println("�����: " + alist);
		Collections.reverse(alist);
		System.out.println("�����: " + alist);
		Collections.shuffle(alist);
		System.out.println("���ź�: " + alist);
		Collections.rotate(alist,2);
		System.out.println("��λ��: " + alist);		
		
		ArrayList blist = new ArrayList();
		blist.add(55); 
		blist.add(66);
		System.out.println("���б�: " + blist);
		Collections.copy(alist,blist);
		System.out.println("������: " + alist);

		System.out.println("�б��г���Ԫ��66�Ĵ���: " + Collections.frequency(alist,66));
		System.out.println("�б���Ԫ�ص����ֵ: " + Collections.max(alist));
		System.out.println("�б���Ԫ�ص���Сֵ: " + Collections.min(alist));

		Enumeration en = createDemoEnumeration();
		ArrayList clist = Collections.list(en);
		System.out.println("Enumeration->ArrayList: " + alist);
	}
	
	public static Enumeration createDemoEnumeration(){
		Vector v = new Vector();
		v.add("Tom");		
		v.add("Billy");		
		v.add("Jenny");		
		return v.elements();	
	}
}