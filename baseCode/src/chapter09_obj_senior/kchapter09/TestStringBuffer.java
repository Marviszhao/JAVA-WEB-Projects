package chapter09_obj_senior.kchapter09;

import java.util.*;
//StringBuffer�������Ч����Ҫ��string���
public class TestStringBuffer{
	public static void main(String args[]){
		StringBuffer sb = new StringBuffer("abc");
		sb.append("defg");
		System.out.println(sb);
		sb.insert(3,"---");		
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.append(new Date());
		System.out.println(sb);
	}
}