package chapter01;

import chapter02.Person;

public class HelloWorld{
//	1能抄正确，保证不报错
//	2 把这些代码翻译成自己的语言
//	3然后把代码删掉，看能不完全写出来
	public static void main(String[] args) {
//			实例化person类
//			调用person里的sleep方法
//			打印"Hi,Java!"
		Person person = new Person();
		person.sleep();
		System.out.println("Hi,Java!");
	}
}