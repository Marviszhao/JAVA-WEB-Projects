package chapter02;

//�������Ƕ����һ���˵���
public class Person{
//����һ���в����Ĺ�����
	public Person(String string) {
		this.name=string;}
//	����һ���޲����Ĺ�����
	public Person() {}
	public String name = "������";
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
		System.out.println(name + "��˯��,������!");	
	} 
}