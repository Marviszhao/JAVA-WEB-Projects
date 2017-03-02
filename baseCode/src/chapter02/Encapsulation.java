package chapter02;



public class Encapsulation{
	//操作对象的成员变量，以及有参数的构造器
	public static void main(String[] args){
		Person person= new Person();
		person.setAge(34);
		System.out.println(person.getAge()+"person");
		person.setAge(-3);
		person.setName("Tom");
		System.out.println(person.getName() + "|||" + person.getAge());
	}
}