package com.exproject.janggi.interfacemod;

import com.exproject.janggi.util.Point;

// 장기말 정의 인터페이스
// 1 = 한
// 2 = 초
// 1 2 3 4 5 6 7
// 왕졸사상마포차

public interface PieceSet {

	public enum Group {
		HAN("1"), CHO("2");

		public final String number;

		private Group(String number) {
			this.number = number;
		}

		public static Group get(String name) {
			switch (name) {
			case "1":
				return HAN;
			case "2":
				return CHO;
			}
			return null;
		}
	}

	public enum Name {
		KING("1"), JOL("2"), SA("3"), SAG("4"), MA("5"), POO("6"), CHA("7");

		public final String number;

		private Name(String classnumber) {
			this.number = classnumber;
		}

		public static Name get(String name) {
			switch (name) {
			case "1":
				return KING;
			case "2":
				return JOL;
			case "3":
				return SA;
			case "4":
				return SAG;
			case "5":
				return MA;
			case "6":
				return POO;
			case "7":
				return CHA;
			}
			return null;
		}
	}

	public Group getGroup(); // 초 한

	public Name getName(); // 왕 차 포 마 상 쫄(병) 사

	public Point getPosition(); // 현재위치

	public Point getOldPosition(); // 전위치

	public Name getKillPiece(); // 잡은말
}