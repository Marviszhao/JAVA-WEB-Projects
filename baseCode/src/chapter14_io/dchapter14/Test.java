package chapter14_io.dchapter14;

import java.io.*;
public class Test{
	public static void main(String args[]){
		try{
			FileInputStream fis;
			DataInputStream dis;
			FileOutputStream fos;
			DataOutputStream dos;
			fos = new FileOutputStream("H://myfile.data");
			dos = new DataOutputStream(fos);
			dos.writeInt(40);
			dos.close();//把我们java里的数据写入到目标文件当中
			
			
			fis = new FileInputStream("H://myfile.data");
			dis = new DataInputStream(fis);
			System.out.println("age:" + dis.readInt());
			fis.close();
		}catch(IOException e){
			System.out.println(e);	
		}
	}
}