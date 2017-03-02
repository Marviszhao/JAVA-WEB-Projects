package chapter03.fchapter03;

public class TestChar{
	public static void main(String[] args){
		char c1 = 'a';
		char c2 = '\u0045';
		char c3 = '\n';
		System.out.print(c1);
		System.out.print("first");
		System.out.print(c2);
		System.out.print("second");
		System.out.print(c3);	
		System.out.print('\\');
		System.out.print(c3);	
		System.out.print("end");
	}	
}