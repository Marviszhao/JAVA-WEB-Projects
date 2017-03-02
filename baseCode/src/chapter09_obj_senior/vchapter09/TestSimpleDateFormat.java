package chapter09_obj_senior.vchapter09;

import java.util.Date;
import java.text.SimpleDateFormat;

public class TestSimpleDateFormat{
	public static void main(String args[]){
		SimpleDateFormat sdf1 = new SimpleDateFormat();
		SimpleDateFormat sdf2 = new SimpleDateFormat(
			"yyyy/MM/dd hh:mm:ss");
		SimpleDateFormat sdf5 = new SimpleDateFormat(
			"yyyy��MM��dd�� E a HH��mm��ss��");
		SimpleDateFormat sdf6 = new SimpleDateFormat(
			"'On 'yyyy-MM-dd HH' 0''clock,We tested it.'");
		Date d = new Date();
		System.out.println(sdf1.format(d));
		System.out.println(sdf2.format(d));
		
		System.out.println(sdf5.format(d));
		System.out.println(sdf6.format(d));
		try{
			d = sdf2.parse("2008/08/08 17:23:45");
			System.out.println(d);
			d = sdf5.parse("2007��04��17�� ���ڶ� ���� 10��02��54��");
			System.out.println(d);
		}catch(java.text.ParseException e){
			e.printStackTrace();	
		}
	}
}