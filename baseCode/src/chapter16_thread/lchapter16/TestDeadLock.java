package chapter16_thread.lchapter16;

public class TestDeadLock{
	public static void main(String args[]){
		StringBuffer sb = new StringBuffer("ABCD");
		MyThread t = new MyThread(sb);
		t.start();	
		synchronized(sb){
			try{
				t.join();
			}catch(InterruptedException e){
				e.printStackTrace();	
			}
			System.out.println(sb);	
		}
		System.out.println("Main thread is over!");	
	}	
}

class MyThread extends Thread{
	private StringBuffer sb;
	public MyThread(StringBuffer sb){
		this.sb = sb;
	}
	public void run(){
		synchronized(sb){
			sb.reverse();
		}
		System.out.println("Sub thread is over!");	
	}	
}