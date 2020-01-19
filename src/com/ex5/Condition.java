package com.ex5;

public class Condition {
	
// 접근 공통 인터페이스	
	private interface Lock{
		public boolean key();
		public void lock();
	}
	
// 잠근상태 클래스 구현	
	private class StateA implements Lock{		
		
		public boolean key() {
			state = flags[1];
			System.out.println("열쇠로 열었습니다.");
			return true;
		}
		
		public void lock() {
			System.out.println("잠겨있습니다.");						
		}
	}
	
// 열림상태 클래스 구현	
	private class StateB implements Lock{
		
		public boolean key() {
			state = flags[0];
			System.out.println("잠금니다.");
			return false;
		}
		
		public void lock() {
			System.out.println("작업을 합니다.");
		}
	}
	
// 자물쇠 생성과 상태저장	
	private Lock[] flags = {new StateA(), new StateB()};
	private Lock state = flags[0];
	
// 잠금변경 함수	
	public void key() {
		state.key();
	}
	
// 조건검사 없이 작업실행	
	public void msg() {				
		state.lock();
	}	
	
	public static void main(String[] args) {
		Condition c = new Condition();
		// 접근 상태및 실행
		while(true) {
			c.msg();
			c.key();
		}
	}
}