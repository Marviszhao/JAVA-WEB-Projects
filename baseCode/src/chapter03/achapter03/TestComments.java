package chapter03.achapter03;

/**
这是一个用于测试目的的Java类，
学习永远不晚！
*/

/*public class Test
 * 这个类主要是为了测试写注释
 * 
 */
public class TestComments{	//这是在描述这个类
	/*
		第二种形式的注释，
		将来不会被提取。
	*/
	//年龄
	private int age;		
	/**
		本方法的功能是设定/修改年龄属性为指定值。
	*/
	public void setAge(int i){
		if(i>=0){//判断条件符合才进行赋值操作
			age = i;
		}		
	}
}

