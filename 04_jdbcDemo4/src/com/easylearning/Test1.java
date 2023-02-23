package com.easylearning;

public class Test1 {
	
	public static void main(String[] args) {
		String s1 ="abc";
		s1.concat("xyz");
		
		StringBuilder sb = new StringBuilder("abc");
		sb.append("xyz");
		
		System.out.println(s1);
		System.out.println(sb);
	}

}
