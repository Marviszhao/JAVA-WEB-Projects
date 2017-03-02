package chapter08_exception.gchapter08;

//try catch �����ڸ�ôʲô��
//finally ��Ĵ�����������е�
//finally final
public class Test{
	public static void main(String[] args)    {
		String friends[]={"Lisa","Billy","Kessy"};
		try {
			for(int i=0;i<5;i++) {
				System.out.println(friends[i]);
			}
		} catch(ArrayIndexOutOfBoundsException e)  {
			System.out.println("index err");
			return;
		}finally{
			System.out.println("in finally block!");	
		}
		System.out.println("this is the end");
	}
}