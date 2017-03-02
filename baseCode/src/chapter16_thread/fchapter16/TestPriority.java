package chapter16_thread.fchapter16;

public class TestPriority {	
	public static void main(String args[]){
		System.out.println("�߳���\t���ȼ�");
		Thread current = Thread.currentThread();
		System.out.print(current.getName() + "\t");
		System.out.println(current.getPriority());		
		Thread t1 = new Runner();
		Thread t2 = new Runner();
		Thread t3 = new Runner();
		t1.setName("First");		
		t2.setName("Second");		
		t3.setName("Third");		
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(8);
       	t1.start();
		t2.start();
       	t3.start();
    }
}

class Runner extends Thread {
	public void run() {
		System.out.print(this.getName() + "\t");
		System.out.println(this.getPriority());		
	}
}
