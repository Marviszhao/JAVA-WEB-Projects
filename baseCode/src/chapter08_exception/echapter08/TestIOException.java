package chapter08_exception.echapter08;

import java.io.*;
public class TestIOException{
	public static void main(String[] args) throws IOException    {
		FileInputStream in=new FileInputStream("myfile.txt");
		int b;
		b = in.read();
		while(b!= -1) {
			System.out.print((char)b);
			b = in.read();
		}
		in.close();
	}
}
