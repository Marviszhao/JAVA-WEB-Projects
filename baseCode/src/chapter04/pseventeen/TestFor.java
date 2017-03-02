package chapter04.pseventeen;

public class TestFor{
	public static void main(String args[]){
		int i;
		int result = 0;
		
		for(i=0;i<100;i++){
			result += i;	
		}
		System.out.println(result);
		System.out.println(i);
	}
}