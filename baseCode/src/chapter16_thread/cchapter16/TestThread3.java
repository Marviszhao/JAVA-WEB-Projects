package chapter16_thread.cchapter16;

public class TestThread3 {	
	public static void main(String args[]){
		Thread t = new Runner3();
		t.start();
    }
}

class Runner3 extends Thread {
	public void run() {
		for(int i=0; i<30; i++) {	
			System.out.println("No. " + i);
		}
	}
}
