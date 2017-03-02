import java.io.*;
public class Test {
	public static void main(String[] args) {
		try {
			FileReader input = new FileReader("Test.java");
			BufferedReader br = new BufferedReader(input);
			FileWriter output = new FileWriter("temp.txt");
			BufferedWriter bw = new BufferedWriter(output);
			String s = br.readLine();			
			while ( s!=null ) {
				bw.write(s);
				bw.newLine();		
				s = br.readLine();
			}			
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
