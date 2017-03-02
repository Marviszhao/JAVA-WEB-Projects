package chapter08_exception.jchapter08;

import java.io.*;
public class TestThrowsException{
	public static void main(String[] args){
		TestThrowsException t = new TestThrowsException();
		try{
		 	t.readFile();
		 }catch(IOException e){
		 	System.out.println(e); 
		 }
	}
	public void readFile()throws IOException {
		FileInputStream in=new FileInputStream("myfile.txt");
		int b;	
		b = in.read();
		while(b!= -1)   {
			System.out.print((char)b);
			b = in.read();
		}
		in.close();	
	}
}
