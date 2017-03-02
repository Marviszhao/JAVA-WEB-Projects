package chapter16_thread.echapter16;

import java.awt.*;
import java.awt.event.*;
public class TestGUIThread {	
	public static void main(String args[]) throws Exception{
		
		Frame f = new Frame();
		Button b = new Button("Press Me!");
		MyMonitor mm = new MyMonitor();
		b.addActionListener(mm);
		f.addWindowListener(mm);	
		f.add(b,"Center");	
		f.setSize(100,60);
		f.setVisible(true);
		MyThreadViewer.view();
	}
}

class MyMonitor extends WindowAdapter implements ActionListener{
	public void actionPerformed(ActionEvent e){
		MyThreadViewer.view();	
	}
}

class MyThreadViewer{
	public static void view(){
		Thread current = Thread.currentThread();
		System.out.println("��ǰ�߳����: " + current.getName());
		int total = Thread.activeCount();
		System.out.println("��߳�����: " + total + "��");
		Thread[] threads = new Thread[total];		
		current.enumerate(threads);
		for(Thread t : threads){
			String role = t.isDaemon()?"��̨�߳� ":"�û��߳� ";
			System.out.println("   -" + role + t.getName());	
		}	
		System.out.println("----------------------------------");
	}	
}
