package chapter16_thread.kchapter16;

class Stack{
	int idx=0;
	char[ ] data = new char[6];
	public void push(char c){
		data[idx] = c;
		System.out.print("ѹ���ַ�" + c + "->");  //p1
		idx++;
		System.out.println("->ѹ��" + c + "������ɣ�");		
	}
	public char pop(){
		idx--;
		return data[idx];
	}
}