package chapter02;

//这是我们定义的一个人的类
public class Person{
//这是一个有参数的构造器
	public Person(String string) {
		this.name=string;}
//	这是一个无参数的构造器
	public Person() {}
	public String name = "无名氏";
	public int age;
	public String getName() {
		return name;
		}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void sleep(){
		System.out.println(name + "在睡觉,呼噜噜!");	
	} 
}