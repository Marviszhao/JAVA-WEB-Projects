package chapter02;

class ElephantAni{
	public String name ="hadoop"; 
}
class Fridge{
	public void openDoor(ElephantAni elephantAni){
		System.out.println("别放了这么肥"+elephantAni.name+"就说你呢");
	}
	public void closeDoor(SuperBoy superBoy){
		System.out.println("关的就是你");
	}
}
class SuperBoy{
	public String name = "xiaochaoren";
	public ElephantAni push(){
		return new ElephantAni();
	}
}

public class Elephant {
	//把大象放冰箱里
//	1 先把大象牵过来
//	2 借个冰箱来
//	3 小超人
//	4 冰箱打开门关上门
//	5 小超人，有一个方法把大象放进去
	public static void main(String[] args) {
		Fridge fridge = new Fridge();
		SuperBoy superBoy = new SuperBoy();
		fridge.openDoor(superBoy.push());
		fridge.closeDoor(superBoy);
	}
	
}
