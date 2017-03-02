package chapter03.echapter03;

public class TestFloatingPointNumber{
	public static void main(String[] args){
		double d1 = 15000.34;
		double d2 = 1.24e2;
		System.out.println(d1);
		System.out.println(d2);
		
		double c1 = 3.0/0;
		System.out.println(c1);
		System.out.println(-3/0.0);
		System.out.println(0.0/0);
		
		float f1 =  (float)3.12345678901;
		System.out.println("f1|||"+f1);
	}	
}