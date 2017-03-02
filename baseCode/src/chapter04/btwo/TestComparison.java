package chapter04.btwo;

public class TestComparison{
	public static void main(String args[]){
		int a = 4;
		int b = 5;
		
		if(a == b){
			System.out.println("a等于b");
		} else {
			System.out.println("a不等于b");
		}
		if(a != b)
			System.out.println("a不等于b");
		if(a > b)
			System.out.println("a大于b");
		if(a < b)
			System.out.println("a小于b");
		if(a >= b)
			System.out.println("a大于等于b");
		if(a <= b)
			System.out.println("a小于等于b");
	}	
}