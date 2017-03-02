package chapter09_obj_senior.dchapter09;
//���Ծ����ʵ����⣬
public class TestEquals2{
	public static void main(String[] args){
		String s1 = new String("abc");
		String s2 = new String("abc");
		String s3 = "abc";
		String s4 = "abc";
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
		
		s2 = s1;
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));
	}	
}