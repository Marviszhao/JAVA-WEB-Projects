package chapter02;

class ElephantAni{
	public String name ="hadoop"; 
}
class Fridge{
	public void openDoor(ElephantAni elephantAni){
		System.out.println("�������ô��"+elephantAni.name+"��˵����");
	}
	public void closeDoor(SuperBoy superBoy){
		System.out.println("�صľ�����");
	}
}
class SuperBoy{
	public String name = "xiaochaoren";
	public ElephantAni push(){
		return new ElephantAni();
	}
}

public class Elephant {
	//�Ѵ���ű�����
//	1 �ȰѴ���ǣ����
//	2 ���������
//	3 С����
//	4 ������Ź�����
//	5 С���ˣ���һ�������Ѵ���Ž�ȥ
	public static void main(String[] args) {
		Fridge fridge = new Fridge();
		SuperBoy superBoy = new SuperBoy();
		fridge.openDoor(superBoy.push());
		fridge.closeDoor(superBoy);
	}
	
}
