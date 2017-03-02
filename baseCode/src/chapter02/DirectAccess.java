package chapter02;

class Car{
	public int price;	
}
class Stundent{
	public void rob (Car car){
		System.out.println(car.toString()+"我可不还了啊");
	}
}
public class DirectAccess{
	public static void main(String[] args){
//		隔壁老王买了一辆车
//		我们花两块钱，买一瓶水能跑的动，然后给他抢过来
		Car benz = new Car();
		benz.price = 2000000;
		
		Stundent xiaoWang = new Stundent();
		xiaoWang.rob(benz);
		
//把大象放冰箱里
//	1 先把大象牵过来
//	2 借个冰箱来
//	3 小超人
//	4 冰箱打开门关上门
//	5 小超人，有一个方法把大象放进去
	
		
	}
}