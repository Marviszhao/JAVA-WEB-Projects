package chapter16_thread.pchapter16;

import java.util.Vector;
public class Test{
	public static void main(String args[]){
		Vector<String> v = new Vector<String>();
		v.addElement("Tom");	
		v.addElement("Billy");	
		v.addElement("Kessy");	
		v.addElement("Mr Brown");
		v.addElement("Kity");	
		v.addElement("Johnson");	
		v.addElement("Nancy");	
		v.addElement("Scott");
		v.addElement("Ruby");	
		MyThread1 mt1 = new MyThread1(v);
		MyThread2 mt2 = new MyThread2(v);
		mt1.start();
		mt2.start();		
	}		
}

class MyThread1 extends Thread{
	private Vector<String> v;
	public MyThread1(Vector<String> v){
		this.v = v;	
	}
	public void run(){
		synchronized(v){
			int total = v.size();
			for(int i=0;i<total;i++){
				String s = v.elementAt(i);
				StringBuffer sb = new StringBuffer(s);
				s = sb.reverse().toString();
				v.setElementAt(s,i);
				System.out.println(v.elementAt(i));	
			}
		}
	}
}

class MyThread2 extends Thread{
	private Vector<String> v;
	public MyThread2(Vector<String> v){
		this.v = v;	
	}
	public void run(){
		v.clear();
	}
}