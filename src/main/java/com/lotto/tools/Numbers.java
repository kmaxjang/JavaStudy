package com.lotto.tools;

public class Numbers {

	private int inning;
	private int[] numbers = new int[6];
	private int[] ruck = null;
	private int rank = 0;

	public Numbers(int inning, int[] numbers) {
		this.inning = inning;
		this.numbers = numbers;
	}

	public int getInning() {
		return inning;
	}

	public int[] getNumbers() {
		return numbers;
	}
	
	public int getNumber(int point) {
		return numbers[point];
	}

	public int[] getRuckNumbers() {
		return ruck;
	}

	public int getRank() {
		return rank;
	}

	// ��ȣ Ȯ�� �� �������
	public int ruckCompare(int[] ruck) {
		int rc = 0; // �´� ��ȣ����
		int rp = 0, np = 0; // ��÷��ȣ �ڸ� ���Թ�ȣ �ڸ�
		while (true) {
			if (ruck[rp] == numbers[np]) {
				rc++;
				if (rp >= ruck.length - 2 || np >= numbers.length - 1) {
					break;
				} else {
					rp++;
					np++;
				}
			} else if (ruck[rp] > numbers[np]) {
				if (np >= numbers.length - 1) {
					break;
				} else {
					np++;
				}
			} else {
				if (rp >= ruck.length - 2) {
					break;
				} else {
					rp++;
				}
			}
		}

		switch (rc) {
		case 6:
			return 1;
		case 5:
			for (int c = 0; c < numbers.length; c++) {
				if (ruck[ruck.length - 1] == numbers[c]) {
					return 2;
				}
			}
			return 3;
		case 4:
			return 4;
		case 3:
			return 5;
		case 2:
			return 6;
		case 1:
			return 7;
		}
		return 8;
	}

}
