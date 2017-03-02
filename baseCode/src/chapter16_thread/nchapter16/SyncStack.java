package chapter16_thread.nchapter16;

public class SyncStack{  //֧�ֶ��߳�ͬ�������Ķ�ջ��ʵ��
	private int index = 0;
	private char []data = new char[6];	
	public synchronized void push(char c){
		while(index == data.length){
		try{
				this.wait();
			}catch(InterruptedException e){}
			}
		this.notify();
		data[index] = c;
		index++;
		System.out.println("produced��"+c);
	}
	public synchronized char pop(){
		while(index ==0){
			try{
				this.wait();
			}catch(InterruptedException e){}
			    	}
		this.notify();
		index--;
		System.out.println("��ѣ�"+data[index]);
		return data[index];
	}
}

