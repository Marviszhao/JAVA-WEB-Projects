package chapter05_arrays.bchapter05;

class MyDate{
    private int day;
    private int month;
    private int year;
    public MyDate(int d, int m, int y){
		day = d;    
		month = m;    
		year = y;
    }
    public void display(){
		System.out.println(day + "-" + month + "-" + year);
    }
}
public class TestArray2{
	public static void main(String args[]){
		MyDate[] m;
		m = new MyDate[10];
		for ( int i=0; i<m.length; i++ ) {
			m[i] =new MyDate(i+1, i+1, 1990+i);
			m[i].display();
		}
	}
}