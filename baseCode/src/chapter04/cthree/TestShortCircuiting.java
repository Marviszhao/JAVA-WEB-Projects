package chapter04.cthree;

class Person{
	private String name;
	private int age;
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}	
	public void setAge(int age){
		this.age = age;	
	}	
	public int getAge(){
		return age;	
	}	
	public void setName(String name){
		this.name = name;	
	}	
	public String getName(){
		return name;	
	}
}

public class TestShortCircuiting{
	public static void main(String args[]){
		Person p1 = null;		
		//���д�������ʵ��if����߼����ʽΪtrue
		p1 = new Person("dashuju",5);
		p1.setAge(50);
		if((p1 != null) && (p1.getAge()>=10)){
			System.out.println("����ѧJava!");
		}else{
			System.out.println("û�����⣬����ѧJava!");
		}				
	}}
