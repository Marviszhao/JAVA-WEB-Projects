package chapter16_thread.dchapter16;

public class TestDaemonThread {	
	public static void main(String args[]){
		Thread t1 = new MyRunner(10);
		t1.setName("�û��߳�t1");
		t1.start();
		
		Thread t2 = new MyRunner(100);
		t2.setDaemon(true);
		t2.setName("��̨�߳�t2");
		t2.start();
		
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName() + ": " + i);	
		}
		System.out.println("���߳̽���!");
    }
}

class MyRunner extends Thread {
	private int n;
	public MyRunner(int n){
		this.n = n;	
	}
	public void run() {
		for(int i=0; i<n; i++) {	
				System.out.println(this.getName() + ": " + i);
		}
		System.out.println(this.getName() + "����!");
	}
}
