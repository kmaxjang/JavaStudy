package com.bighits;

public class NumbersBuild {
// 번호 조건 1~45사이 6섯자리 번호
	public final static int min = 1;
	public final static int max = 45;
	public final static int length = 5;

	private int[] numbers = new int[length + 1];
	private int count = -1; // 현재 등록 번호수	

	
	 // 번호범위
	public boolean isRange(int number) {
		return (min <= number && max >= number) ? true : false;
	}
	
	// 입력가능여부
	public boolean isLimet() { 
		return (count < length) ? true : false;
	}

	public boolean set(int numbers[]) {
		if (!isLimet()) {
			return false;
		}
		for (int i = 0; i < numbers.length; i++) {
			set(numbers[i]);
		}
		return true;
	}

	public boolean set(int number) {
		if (!isLimet() || !isRange(number)) {
			return false; // 유효성검사
		}
		if (-1 == count) { // 등록번호 없을때
			count++;
			numbers[0] = number;
		} else {
			int tmp = 0;
			for (int c = count; c >= 0; c--) {
				tmp = compare(numbers[c], number);				
				if(tmp != 0) {
					// 오름차순 내림차순
					tmp = (1 < tmp)? 1: -1;
				}
				switch (tmp) {
				case 0:
					return false; // 번호중복
				case 1:
					if (c != 0) {
						break;
					} // 마지막 자리까지 중복 없을때 아래실행
				case -1:
					if (tmp == 1) {
						c += 1;
					}
					count++;
					for (tmp = count; tmp > c; tmp--) {
						numbers[tmp] = numbers[tmp - 1];
					}
					numbers[c] = number;
					return true;
				}
			}
		}		
		return true;
	}

	public void delete() {
		count = -1;
	}

	public boolean delete(int number) {
		for (int c = count; c >= 0; c--) {
			if (numbers[c] == number) {
				for (int dp = c; dp < count; dp++) {
					numbers[dp] = numbers[dp + 1];
				}
				count--;
				return true;
			}
		}
		return false;
	}

	public boolean change(int deletepoint, int number) {		
		if (0 > count || 0 > deletepoint || deletepoint > count) {
			return false;
		}
		for (int dp = deletepoint; dp < count; dp++) {
			numbers[dp] = numbers[dp + 1];
		}
		count--;
		return set(number);
	}

	public int getCount() {
		return count + 1;
	}

	public int[] get() {
		if (-1 >= count)
			return null;
		int[] copy = new int[count + 1];
		System.arraycopy(numbers, 0, copy, 0, count + 1);
		return copy;
	}

	public int get(int point) {
		return (-1 != count && count <= point && 0 <= point) ? numbers[point] : null;
	}

	public int compare(int number1, int number2) {		
		return number1 - number2;
	}
	
	 // 긴번호로 입력
	public void set(long number) {
		while (number != 0) {
			set((int) (number % 100));
			number = number / 100;
		}
	}
	
	// 한번호로 출력
	public long get(int numbers[]) { 
		long number = 0;
		for (int p = 0; p <= numbers.length; p++) {
			number = (number * 100) + numbers[p];
		}
		return number;
	}
}
