package com.ex01;

public enum MoveState {
  
  ROUTE, // 이동경로(포 마 상)
  HURDLE, // 넘는기물(포)
  POO, // 포 이동경로 (이동불가)
  SUPPORT, // 같은편 경로(이동불가)
  TAKE, // 잡을수 있는 경로(이동가능)
  MOVE, // 이동가능 경로
  DEFEND; // 장군 이동불가
  
}
