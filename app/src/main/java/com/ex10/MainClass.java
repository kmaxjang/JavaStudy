package com.ex10;

import com.ex09.Message;
import com.ex10.FactoryMethod.Client;
import com.ex10.Singleton.Singleton;

public final class MainClass implements Message {

  public static final Message me = new MainClass();


  public static void main(String[] args) {
    me.println("Java EX10 2025.03.30");
    Singleton A = Singleton.getInstance("A");
    Singleton B = Singleton.getInstance("B");

    me.println("싱글톤 A="+A);
    me.println("싱글톤 B="+B);
    
    Client client = new Client();
//    client.setUI(new MacUI());
    client.button();
    client.line();
  }
}
/*
 Java Design Pattern
1. 생성패턴(Creationl Patterns) 객체생성 효율관리
  - 싱글턴(Singleton)
     단 하나 고유 인스턴스만 생성
  - 팩토리 메소드(Factory Method)
     객체 생성을 서브클래스에서 결정
  - 추상 팩토리(Abstract Factory)
     관련된 객체들을 묶어서 생성
  - 빌더(Builder)
     복잡한 객체 생성을 단계별로 나누어 처리
  - 프로토타입(Prototype)
     객체를 복사해서 새로운 객체 생성
2. 구조패턴(Structural Patterns) 객체 조합 더큰 구조형성
   - 어댑터(Adapter)
      서로다른 인테페이스를 연결
   - 데코레이터(Decorator)
      기존 객체에 새로운 기능을 추가
   - 프록시(Proxy)
      접근제어나 성능 최적화를 위해 대리 객체를 사용
   - 퍼사드(Facade)
      독립한 시스템을 단순한 인터페이스로 감쌈
   - 브리지(Bridge)
      구현과 인터페이스를 분리하여 독립적으로 확장
   - 컴포지트(Composite)
      객체들을 트리 구조로 구성하여 계층적인 구조를 표현
   - 플라이웨이트(Flyweight)
      동일한 객체를 공유하여 메모리 사용을 최적화
3. 행위패턴(Behavioral Patterns) 객체간 상호작용과 책임분배
   - 옵져버(Observer)
      객체의 상태 변화를 관찰하고 자동으로 업데이트
   - 전략(Stratgy)
      실행할 알고리즘을 동적으로 선택
   - 템플릿 메소드(Template Method)
      알고리즘의 골격을 정의하고 하위클래스에서 구현
   - 컨맨드(Command)
      요청을 객체로 캡슐화하여 실행취소 기능을 재공
   - 책임연쇄(Chain of Responsibility)
      요청을 처리할수 있는 객체들이 연결된 체인을 따라 전달
   - 상태(State)
      객체의 상태에 따라 행동을 변경
   - 방문자(Visitor)
      객체 구조를 변경하지않고 기능을 확장
   - 미디에이터(Mediator)
      객체간의 직접적인 통신을 줄이고 중재자를 통해 협력
   - 메멘토(Memento)
      객체의 상태를 저장하고 복원
   - 인터프리터(Interpreter)
      특정 문법을 해석
 */     
