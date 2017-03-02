package chapter05_arrays.achapter05;

public class TestArray1{
	public static void main(String[] args){
		int[] a = new int[10];
		System.out.println(a[2]);    
		
		for(int i=0;i<10;i++){
			a[i] = 2 * i + 1;
			
		}
	}	
}