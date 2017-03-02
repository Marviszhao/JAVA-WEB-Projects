package chapter08_exception.dchapter08;

class Person{
	public void display(Person p){
		System.out.println( p.age);
	}
	public int age;
}

public class TestNullPointerException{
	public static void main(String[] args) {
		new Person().display(null);
//		System.out.println(p.age);
	}
}

