package chapter11_collection.echapter11;

import java.util.Vector;
import java.util.Iterator;

public class TestIterator2{
	public static void main(String[] args) {
		Vector v = new Vector();
		v.addElement(new Person("����",18));
		v.addElement(new Person("����",26));
		v.addElement(new Person("����",34));
		v.addElement(new Person("����",40));

		Iterator it = v.iterator();
		while(it.hasNext()){
			Person p = (Person)it.next();
			System.out.println(p);	
			if(p.getName().equals("����")){
				p.setAge(p.getAge() + 50);
			}else if(p.getName().equals("����")){
				it.remove();
			}			
		}	
		System.out.println("-----------------------");	
		for(int i=0;i<v.size();i++)
			System.out.println(v.elementAt(i));	
	}
}