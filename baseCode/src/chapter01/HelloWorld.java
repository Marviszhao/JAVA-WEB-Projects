package chapter01;

import chapter02.Person;

public class HelloWorld{
//	1�ܳ���ȷ����֤������
//	2 ����Щ���뷭����Լ�������
//	3Ȼ��Ѵ���ɾ�������ܲ���ȫд����
	public static void main(String[] args) {
//			ʵ����person��
//			����person���sleep����
//			��ӡ"Hi,Java!"
		Person person = new Person();
		person.sleep();
		System.out.println("Hi,Java!");
	}
}