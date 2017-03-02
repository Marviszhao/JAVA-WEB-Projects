package chapter16_thread.nchapter16;

public class SyncTest{
    public static void main(String args[]){
		SyncStack stack = new SyncStack();
		Runnable p=new Producer(stack);
		Runnable c = new Consumer(stack);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
    }
}


class  Producer implements Runnable{
	SyncStack stack;	
	public Producer(SyncStack s){
		stack = s;
	}
	public void run(){
		for(int i=0; i<20; i++){
			char c =(char)(Math.random()*26+'A');
			stack.push(c);
			try{							        
				Thread.sleep((int)(Math.random()*300));
			}catch(InterruptedException e){
			}
		}
	}
}

class Consumer implements Runnable{
	SyncStack stack;	
	public Consumer(SyncStack s){
		stack = s;
	}
	public void run(){
		for(int i=0;i<20;i++){
			char c = stack.pop();
			try{							           
				Thread.sleep((int)(Math.random()*500));
			}catch(InterruptedException e){
			}
		}
	}
}
