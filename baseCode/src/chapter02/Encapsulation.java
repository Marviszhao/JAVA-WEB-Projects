package chapter02;



public class Encapsulation{
	//��������ĳ�Ա�������Լ��в����Ĺ�����
	public static void main(String[] args){
		Person person= new Person();
		person.setAge(34);
		System.out.println(person.getAge()+"person");
		person.setAge(-3);
		person.setName("Tom");
		System.out.println(person.getName() + "|||" + person.getAge());
	}
}