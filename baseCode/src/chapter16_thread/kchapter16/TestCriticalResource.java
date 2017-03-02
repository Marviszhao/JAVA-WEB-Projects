package chapter16_thread.kchapter16;

public class TestCriticalResource{
	public static void main(String args[]){
		Stack s = new Stack();
		s.push('a');
		s.push('b');
		Runner1 r1 = new Runner1(s);
		Runner2 r2 = new Runner2(s);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);	
		t1.start();
		t2.start();
	}	
}

class Runner1 implements Runnable{
	private Stack s;
	public Runner1(Stack s){
		this.s = s;
	}
	public void run(){
		for(int i=0;i<15;i++){
			System.out.print(i+ "  ");
		}
		s.push('c');
	}	
}

class Runner2 implements Runnable{
	private Stack s;
	public Runner2(Stack s){
		this.s = s;
	}
	public void run(){
		System.out.print("**����" + s.pop() + "**");
	}	
}
