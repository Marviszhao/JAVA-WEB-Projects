package chapter16_thread.mchapter16;

public class TestDeadLock2{
	public static void main(String args[]){
		char[] a = {'A','B','C'};
		char[] b = {'D','E','F'};
		MyThread t1 = new MyThread(a,b);
		MyThread t2 = new MyThread(b,a);
		t1.start();
		t2.start();		
	}	
}

class MyThread extends Thread{
	private char[] source;
	private char[] dest;
	
	public MyThread(char[] source,char[] dest){
		this.source = source;
		this.dest = dest;
	}
	public void run(){
		synchronized(source){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();	
			}
			
			synchronized(dest){
				System.arraycopy(source,0,dest,0,source.length);
				System.out.println(dest);
			}		
		}
	}	
}