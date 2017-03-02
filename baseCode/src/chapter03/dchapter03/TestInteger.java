package chapter03.dchapter03;

import java.math.BigInteger;

public class TestInteger{
	public static void main(String[] args){
		int a = 39;
		byte abyte= 127;
		short ashort = 12345;
		int aint = 2134567890;
		long along = 0;
		
		int b = 0x4b;//十六进制的数据  0-9 abcdef 10,11,12,13,14,15
		int c = 021;//八进制的数据 0-7 逢8进一位的数据 2*8 +1
		int d = a + 0x12 + 012;  //等价于d=39 + 18 + 10;
		int e = 1234567890;//-65536   65535 2 16 2 32
		int f = e+e+e+e;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(f);
	}	
}