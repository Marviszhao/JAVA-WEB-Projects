package chapter04.jten;

//���Ա����ⳣ���������
//int �� float ��ת�����ֵľ�����ʧ
//�������͵����������ʵ��
//a + b Ĭ�Ϸ���һ��int���͵�����
public class TestConversion{
	public static void main(String args[]){
		int i1 = 1234567891;
		float f = i1;    //�Ϸ�������Ȼ���ܴ��ھ�����ʧ
		System.out.println(f);
		double d1 = i1;	//�Ϸ��������ھ�����ʧ
		System.out.println(d1);
		double d2 = 3.99;
		int i2 = (int)(d2+0.5);
		System.out.println(i2);		
		
		byte a = 3;		//�Ϸ�
		byte b = 112;		//�Ϸ�
//		//byte c = 200;		//�Ƿ�������������Χ
//		byte d = a + b;	//�Ƿ������ܴ��ھ�����ʧ
		int  e = a + b;		//�Ϸ�
		System.out.println(e);
		int k = 1299;			
		byte b1 = (byte)k;		//�Ƿ������ܴ��ھ�����ʧ		
		System.out.println(b1);
	}		}