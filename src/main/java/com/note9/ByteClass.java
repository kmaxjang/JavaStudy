package com.note9;

public class ByteClass {

	private final int length = 6;
	private final int max = 45;
	private final int min = 1;
	private int limet = -1; // 현재 등록번호수
	private long number = 0l;

	// 복수의 번호 등록
	public void set(int[] number) {
		if (!isLimet()) {
			return;
		}
		for (int i = 0; i < number.length; i++) {
			set(number[i]);
		}
	}

	// 번호 등록
	public void set(int number) {
		if (!isLimet() || !isRange(number)) {
			// 유효성 검사
			return;
		}
		if (-1 == limet) {
			// 등록번호 없을때
			limet++;
			this.number = number;
		} else {
			int c_tmp = 0, point = 0;
			long num = this.number;
			while (num != 0) {
				c_tmp = compare((int) ((num <= max) ? num : num % 100), number);
				switch (c_tmp) {
				case 0:
					// 번호 중복 종료
					return;
				case -1:
					if (point != limet) {
						// 마지막자리까지 중복없으면 종료
						break;
					}
				case 1:
					if (c_tmp == 1) {
						point--;
					}
					limet++;
					this.number = ((num * 100) + number) + number % (long) Math.pow(100, point - 1);
					return;
				}
				num = num / 100;
			}
			/*
			 * length 0 limet 0 point num number
			 * 
			 * 12 34 56 < 35 num number%100 number num+ number number
			 * 
			 */
		}
		if (7 > limet) {
			this.number = (this.number * 100) + number;
			limet++;
		}
		System.out.printf("Integer :%10d(Byte :%10x)%n", number, number);
		System.out.println(Integer.toBinaryString(number));
	}

	public void setChange(int num, int point) {

		long tmp = number, p = (long) Math.pow(100, point - 1);
		tmp = tmp - getSimple(point) * p;
		tmp = tmp + num * p;
		System.out.println(
		        "orginal : " + number + "\nchange  : " + tmp + "p" + p + "n" + getSimple(point) + "c" + (num * p));
		long ex = 1234567890;
		for (int c = 1; c < 7; c++) {
			System.out.println("" + ex % (long) Math.pow(100, c));
			System.out.println("" + ex / (long) Math.pow(100, c));
			long ev = (long) Math.pow(100, c);
			System.out.println(" " + ex % ev / (ev / 100));
		}
	}

	public int get(int point) {

		if (point <= limet) {
			long tmp = number, num = 0;
			for (int c = 1; c <= point; c++) {
				num = tmp % 100;
				tmp = tmp / 100;
			}
			return (int) num;
		}

		return 0;
	}

	public int getSimple(int point) {
		long tmp = number;
		if (point != 1) {
			tmp = tmp / (long) Math.pow(100, point - 1);
		}
		return (int) (tmp % 100);
	}

	public int compare(int number, int number2) { // 번호 비교
		if (number == number2) {
			return 0;
		}
		// 오름차순 내림차순 결정
//		return (number > number2) ? 1 : -1;
		return (number > number2) ? -1 : 1;
	}

	// 등록가능 확인
	public boolean isLimet() {
		return (limet < length - 1) ? true : false;
	}

	// 등록번호 범위 확인
	public boolean isRange(int number) {
		return (number <= max && number >= min) ? true : false;
	}

	// 번호를 직렬로 받음
	public void setSerialNumber(long number) {
		this.number = number;
	}

	// 번호를 직렬로 돌려줌
	public long getSerialNumber() {
		return number;
	}
}// end