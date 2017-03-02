package chapter01;

import java.util.LinkedList;

class People {
    String name;
    public People() {
        System.out.print(1);
    }
    public People(String name) {
        System.out.print(2);
        this.name = name;
    }
}
class Child extends People {
    People father;
    
    public Child(String name) {
        System.out.print(3);
        this.name = name;
        father = new People(name + ":F");
    }
    public Child() {
        System.out.print(4);
    }
}
public class Example{
	public static void main(String[] args) {
		new Child("mike");
	}
}
