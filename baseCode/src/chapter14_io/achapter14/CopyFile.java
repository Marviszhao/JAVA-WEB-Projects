package chapter14_io.achapter14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile{
	public static void main(String[] args) {
		try {
			//把磁盘上的数据信息读入到jvm里
			FileInputStream fis = new FileInputStream ("H://a.jpg");
			//从jvm当中把信息写入到目标文件当中
			FileOutputStream fos = new FileOutputStream ("H://temp.jpg");
			//第一次从fis对象当中读取数据
			int read = fis.read();		
			while ( read != -1 ) {
//				把已经读取到的数据写入到fos对象当中
				fos.write(read);	
//				接着读取fis中的数据
				read = fis.read();
			}			
			fis.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
