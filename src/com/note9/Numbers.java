package com.note9;

//6자리 번호등록 클래스
public class Numbers {

	private final int LENGTH = 6; // 최대 자리수
	private final int MAX = 45; // 최대숫자
	private final int MIN = 1; // 최소숫자
	private int limet = -1; // 현재 등록번호수
	private int[] numbers = new int[LENGTH]; // 등록번호

	// 복수의 번호 등록
	public void set(int[] numbers) {
		if (!isLimet()) {
			// 가득참
			return;
		}
		for (int i = 0; i < numbers.length; i++) {
			set(numbers[i]);
		}
	}

	// 번호등록
	public void set(int number) {
		if (!isLimet() || !isRange(number)) {
			// 유효성 검사
			return;
		}
		if (-1 == limet) {
			// 등록번호 없을때
			limet++;
			numbers[0] = number;
		} else {
			int c_tmp = 0;
			for (int count = limet; count >= 0; count--) {
				c_tmp = compare(numbers[count], number);
				switch (c_tmp) {
				case 0:
					// 번호 중복 종료
					return;
				case -1:
					if (count != 0) {
						// 마지막자리까지 중복없으면 종료
						break;
					}
				case 1:
					if (c_tmp == 1) {
						count += 1;
					}
					limet++;
					for (c_tmp = limet; c_tmp > count; c_tmp--) {
						numbers[c_tmp] = numbers[c_tmp - 1];
					}
					numbers[count] = number;
					return;
				}
			}
		}
	}

	// 등록가능 확인
	public boolean isLimet() {
		return (limet < LENGTH - 1) ? true : false;
	}

	// 등록번호 갯수
	public int getLimet() {
		return limet + 1;
	}

	// 번호지우기
	public void delete() {
		limet = -1;
	}

	// 특정번호 지우기
	public void delete(int number) {
		for (int point = limet; point >= 0; point--) {
			if (numbers[point] == number) {
				for (int dp = point; dp < limet; dp++) {
					numbers[dp] = numbers[dp + 1];
				}
				limet--;
				return;
			}
		}
	}

	// 특정자리 번호 지우고 번호등록
	public void change(int del_point, int number) {
		if (0 > del_point || limet < del_point)
			return;
		for (int dp = del_point; dp < limet; dp++) {
			numbers[dp] = numbers[dp + 1];
		}
		limet--;
		set(number);
	}

	// 등록번호 반환
	public int[] get() {
		if (limet < 0) {
			return null;
		}
		int[] copy = new int[limet + 1];
		System.arraycopy(numbers, 0, copy, 0, limet + 1);
		return copy;
	}

	// 특정위치 번호 반환
	public int get(int point) {
		return (limet != -1 && 0 <= point && limet <= point) ? numbers[point] : null;
	}

	// 등록번호 범위 확인
	public boolean isRange(int number) {
		return (number >= MIN && number <= MAX) ? true : false;
	}

	// 번호 비교
	public int compare(int number, int number2) {
		if (number == number2) {
			return 0;
		}
// 오름차순 내림차순 결정
//	return (number > number2) ? 1 : -1;
		return (number > number2) ? -1 : 1;
	}

	// 번호를 직렬로 받음
	public void setSerialNumber(long number) {
		while (number != 0) {
			set((int) ((number <= MAX) ? number : number % 100));
			number = number / 100;
		}
	}

	// 번호를 직렬로 돌려줌
	public long getSerialNumber() {
		long number = 0;
		for (int point = 0; point <= limet; point++) {
			number = (number * 100) + numbers[point];
		}
		return number;
	}
} // end