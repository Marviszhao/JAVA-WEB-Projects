package chapter02;

class Car{
	public int price;	
}
class Stundent{
	public void rob (Car car){
		System.out.println(car.toString()+"�ҿɲ����˰�");
	}
}
public class DirectAccess{
	public static void main(String[] args){
//		������������һ����
//		���ǻ�����Ǯ����һƿˮ���ܵĶ���Ȼ�����������
		Car benz = new Car();
		benz.price = 2000000;
		
		Stundent xiaoWang = new Stundent();
		xiaoWang.rob(benz);
		
//�Ѵ���ű�����
//	1 �ȰѴ���ǣ����
//	2 ���������
//	3 С����
//	4 ������Ź�����
//	5 С���ˣ���һ�������Ѵ���Ž�ȥ
	
		
	}
}