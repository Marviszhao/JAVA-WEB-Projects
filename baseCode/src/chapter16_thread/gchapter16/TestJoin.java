package chapter16_thread.gchapter16;

public class TestJoin {	
	public static void main(String args[]){
		MyRunner r = new MyRunner();
		Thread t = new Thread(r);
		t.start();
		try{
			t.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		for(int i=0;i<50;i++){
			System.out.println("���߳�:" + i);
		}
    }
}

class MyRunner implements Runnable {
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println("SubThread: " + i);
		}
	}
}
