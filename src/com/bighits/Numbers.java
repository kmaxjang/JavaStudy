package com.bighits;

public class Numbers {

	private final int min = 1;
	private final int max = 45;
	private final int length = 6;
	private int[] numbers = new int[length];

	private int limet = -1;
	private final boolean uplist = false;
	private int up = -1, down = 1;
	{
		if (uplist) {
			up = 1;
			down = -1;
		}
	}

	public void setNumber(int number[]) {
		if (!isLimet()) {
			return;
		}
		for (int i = 0; i < number.length; i++) {
			setNumber(number[i]);
		}
	}

	public void setNumber(int number) {
		if (!isLimet() || !isRange(number)) {
			return; // 유효성검사
		}
		if (-1 == limet) { // 등록번호 없을때
			limet++;
			numbers[0] = number;
		} else {
			int tmp = 0;
			for (int c = limet; c >= 0; c--) {
				tmp = compare(numbers[c], number);
				switch (tmp) {
				case 0:
					return; // 번호중복
				case -1:
					if (c != 0) {
						break;
					} // 마지막 자리까지 중복 없을때 아래실행
				case 1:
					if (tmp == 1) {
						c += 1;
					}
					limet++;
					for (tmp = limet; tmp > c; tmp--) {
						numbers[tmp] = numbers[tmp - 1];
					}
					numbers[c] = number;
					return;
				}
			}
		}
	}

	public void deleteNumber() {
		limet = -1;
	}

	public void deleteNumber(int number) {
		for (int c = limet; c >= 0; c--) {
			if (numbers[c] == number) {
				for (int dp = c; dp < limet; dp++) {
					numbers[dp] = numbers[dp + 1];
				}
				limet--;
				return;
			}
		}
	}

	public void changeNumber(int delete, int number) {
		if (0 > delete || limet < delete)
			return;

		for (int dp = delete; dp < limet; dp++) {
			numbers[dp] = numbers[dp + 1];
		}
		limet--;
		setNumber(number);
	}

	public int getLimet() {
		return limet + 1;
	}

	public int[] getNumbers() {
		if (-1 >= limet)
			return null;
		int[] copy = new int[limet + 1];
		System.arraycopy(numbers, 0, copy, 0, limet + 1);
		return copy;
	}

	public int getNumbers(int point) {
		return (-1 != limet && limet <= point && 0 <= point) ? numbers[point] : null;
	}

	public boolean isLimet() {
		return (limet < length - 1) ? true : false;
	}

	public boolean isRange(int number) {
		return (number <= max && number >= min) ? true : false;
	}

	public int compare(int number, int number2) {
		if (number == number2) {
			return 0;
		}
		// 오름차순 내림차순
		return (number > number2) ? up : down;
	}

	public void change(long number) {
		while (number != 0) {
			setNumber((int) (number % 100));
			number = number / 100;
		}
	}

	public long change() {
		long number = 0;
		for (int p = 0; p <= limet; p++) {
			number = (number * 100) + numbers[p];
		}
		return number;
	}
}
