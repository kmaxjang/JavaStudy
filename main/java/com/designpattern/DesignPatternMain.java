package com.designpattern;
/*
 * 디자인 패턴이란?
소프트웨어를 설계할 때 특정 맥락에서 자주 발생하는 고질적인 문제들이 또 발생했을 때 재사용할 할 수 있는 훌륭한 해결책이다.
“바퀴를 다시 발명하지 마라(Don’t reinvent the wheel)” 이미 만들어져서 잘 되는 것을 처음부터 다시 만들 필요가 없다는 의미이다.

패턴이란?
각기 다른 소프트웨어 모듈이나 기능을 가진 다양한 응용 소프트웨어 시스템들을 개발할 때도 서로 간에 공통되는 설계 문제가 존재하며 이를 처리하는 해결책 사이에도 공통점이 있다. 이러한 유사점을 패턴이라 한다.
패턴은 공통의 언어를 만들어주며 팀원 사이의 의사 소통을 원활하게 해주는 아주 중요한 역할을 한다.
디자인 패턴의 종류
이미 알려진 디자인 패턴은 다음과 같이 23개로 나누어져 있다. 크게 생성(Creational), 구조(Structural), 행위(Behavioral) 3가지로 분류된다. 이는 GoF(Gang of Four) 디자인 패턴이라고 불리며, 에리히 감마(Erich Gamma), 리차드 헬름(Richard Helm), 랄프 존슨(Ralph Johnson), 존 블리시디스(John Vissides) 4명의 유명한 개발자들에 의해 고안되었다. 4명의 개발자는 ‘경험’이나 ‘내적인 축적’을 <디자인 패턴>이라는 형태로 정리하였다. 이 4명을 the Gang of Four 또는 GoF라고 부른다.

생성 패턴 (Creational Pattern)
객체 생성에 관련된 패턴으로, 객체의 생성과 조합을 캡슐화해 특정 객체가 생성되거나 변경되어도 프로그램 구조에 영향을 크게 받지 않도록 유연성을 제공한다.

추상 팩토리 메서드 (Abstract Factory Methods) : 관련된 부품을 조립해서 제품을 만든다.
팩토리 메서드 (Factory Methods) : 인스턴스 작성을 하위 클래스에게 맡긴다.
빌더 (Builder) : 잡한 인스턴스를 조립한다.
프로토타입 (Prototype) : 복사해서 인스턴스를 만든다.
싱글톤 (Singleton) : 단 하나의 인스턴스.
구조 패턴 (Structural Pattern)
클래스나 객체를 조합해 더 큰 구조를 만드는 패턴으로 예를 들어 서로 다른 인터페이스를 지닌 2개의 객체를 묶어 단일 인터페이스를 제공하거나 객체들을 서로 묶어 새로운 기능을 제공하는 패턴이다.

어댑터 (Adapter) : 한 꺼풀 덧씌워 재사용.
브리지 (Bridge) : 기능의 계층과 구현의 계층을 분리한다.
컴퍼지트 (Composite) : 그릇과 내용물의 동일시.
데코레이터 (Decorator) : 장식과 내용물의 동일시.
퍼사드 (Facade) : 간단한 창구.
플라이웨이트 (Flyweight) : 동일한 것을 공유해서 낭비를 없앤다.
프록시 (Proxy) : 필요해지면 만든다.
행위 패턴 (Behavioral Pattern)
객체나 클래스 사이의 알고리즘이나 책임 분배에 관련된 패턴으로, 한 객체가 혼자 수행할 수 없는 작업을 여러 개의 객체로 어떻게 분배하는지, 또 그렇게 하면서도 객체 사이의 결합도를 최소화하는 것에 중점을 둔다.

책임 연쇄 (Chain of Responsibility) : 책임 떠넘기기.
커맨드 (Command) : 명령을 클래스로 만든다.
인터프리터 (Interpreter) : 문법 규칙을 클래스로 표현한다.
이터레이터 (Iterator) : 하나씩 세다.
미디에이터 (Mediator) : 상대는 카운셀러 한사람뿐.
메멘토 (Memento) : 상태를 보존한다.
옵저버 (Observer) : 상태의 변화를 통지한다.
스테이트 (State) : 상태를 클래스로서 표현한다.
스트레티지 (Strategy) : 알고리즘을 모두 교체한다.
템플릿 메서드 (Template Meothods) : 체적인 처리를 하위 클래스에게 맡긴다.
비지터 (Visitor) : 구조 안을 돌아다니면서 일을 한다.
 */
public class DesignPatternMain {

	public static void msg(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		try {
			Class instance = Class.forName("com.designpattern.DesignPatternMain");
			msg(""+instance.getCanonicalName());
		} catch (ClassNotFoundException e) {
			msg("클래스 불러오기 실패");
			e.printStackTrace();
		}

	}

}
