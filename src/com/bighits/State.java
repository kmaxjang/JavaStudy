package com.bighits;

public class State {

private static State state = new State();

public State(){
  
}

public static State getCon(){
  return state;
}


}
/*
화면정보저장 이름
가로       속성
세로       속성
방향       속성

상위정보    위치
하위정보
최상위 root
이름 root
속성 string list
위치 0

*/