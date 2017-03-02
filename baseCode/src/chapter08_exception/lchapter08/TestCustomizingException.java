package chapter08_exception.lchapter08;
class MyException extends Exception {
   	private int idnumber;
 	public MyException(String message, int id) {
		super(message);
		this.idnumber = id;} 
	public int getId() {
		return idnumber;
 	}}
public class TestCustomizingException{
	public void regist(int num) throws MyException {
		if (num < 0) {
			throw new MyException("����Ϊ��ֵ��������",3);}
		System.out.println("�Ǽ�����:" + num );}
	public void manager() {
		try {
			regist(-100);
		} catch (MyException e) {
			System.out.println("�Ǽ�ʧ�ܣ���������"+e.getId());	
		}
		System.out.print("���εǼǲ�������");
	}
	public static void main(String args[]){
		new TestCustomizingException().manager();
	}}