package chapter16_thread.ichapter16;

import java.util.Date;

public class TestYield{
	public static void main(String[] args){
		Thread t1 = new MyThread(false);
		Thread t2 = new MyThread(true);
		Thread t3 = new MyThread(false);
		t1.start();
		t2.start();
		t3.start();
	}	
}

class MyThread extends Thread{
	private boolean flag;
	public MyThread(boolean flag){
		this.flag = flag;
	}
	public void setFlag(boolean flag){
		this.flag = flag;
	}
	public void run(){
		long start = new Date().getTime();
		for(int i=0;i<500;i++){
			if(flag)
				Thread.yield();
			System.out.print(this.getName() + ": " + i + "\t");
		}
		long end = new Date().getTime();
		System.out.println("\n" + this.getName() + "ִ��ʱ��: " + (end - start) + "����");
	}
}