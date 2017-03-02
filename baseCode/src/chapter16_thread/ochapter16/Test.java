package chapter16_thread.ochapter16;

import java.io.*;
public class Test{
	public static void main(String args[]){
		PipedInputStream pin = new PipedInputStream();
		PipedOutputStream pout = new PipedOutputStream();
		try{
			pin.connect(pout);
		}catch(IOException e){
			e.printStackTrace();
		}
		Thread t1 = new Sender(pout);
		Thread t2 = new Receiver(pin);
		t1.start();
		t2.start();	
	}		
}

class Sender extends Thread{
	private DataOutputStream dos;
	public Sender(PipedOutputStream p){
		dos = new DataOutputStream(p);	
	}
	public void run(){
		try{
			dos.writeUTF("HelloWorld");
			dos.close();
		}catch(IOException e){
			e.printStackTrace();	
		}
	}
}

class Receiver extends Thread{
	private DataInputStream dis;
	public Receiver(PipedInputStream p){
		dis = new DataInputStream(p);	
	}
	public void run(){
		try{
			System.out.println(dis.readUTF());
			dis.close();
		}catch(IOException e){
			e.printStackTrace();	
		}
	}		
}
