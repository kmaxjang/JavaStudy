package com;

public class MainClass {
    
// 간단 메시지 출력 import static com.MainClass.msg;
    public static void msg(String... msg) {
	for (String m : msg) {
	    System.out.println(m);
	}
    }

    public static void main(String[] args) {
	msg("자바 연습(깃허브 연동)");
	
    }
}
