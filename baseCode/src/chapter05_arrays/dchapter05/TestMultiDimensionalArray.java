package chapter05_arrays.dchapter05;

public class TestMultiDimensionalArray{
	public static void main(String args[]){
		int[][] a = {{1,2},{3,4,0,9,2,3},{5,6,7}};
		TestMultiDimensionalArray tmda = new TestMultiDimensionalArray();
		tmda.show(a);
		
		System.out.println("---------------------------");
		int[][] b = new int[2][3];
		b[1][0] = 4;
		b[1][1] = 5;
		b[1][2] = 6;
		tmda.show(b);
	}
	
	public void show(int[][] s){
		for(int i=0;i<s.length;i++){
			for(int j=0;j<s[i].length;j++){
				System.out.print(s[i][j] + "\t");	
			}
			System.out.println();	
		}	
	}
}