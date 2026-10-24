package com.lotto.tools;

public class NumberRegister {

	private int[] count = new int[45];

	public void add(int[] number) {
		for (int c = 0; c < number.length; c++) {
			count[number[c] - 1]++;
		}
	}

	public void print() {
		for (int c = 0; c < count.length; c++) {
			System.out.print("[" + count[c] + "]");
			if ((c + 1) % 9 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n");
		int num = 0;
		for (int c = 0; c < count.length; c++) {
			if (count[c] != 0) {
				System.out.print("[" + ((c + 1) < 10 ? "0" : "") + (c + 1) + "]");
				num++;
			}
			if ((c + 1) % 9 == 0) {
				System.out.println();
			}
		}
		System.out.println("===" + num);
	}
	
// ��ȣ Ȯ�� �� �������
	public int ruckCompare(int[] ruck, int[] number) {
		int rc = 0; // �´� ��ȣ����
		int rp = 0, np = 0; // ��÷��ȣ �ڸ� ���Թ�ȣ �ڸ�
		while (true) {
			if (ruck[rp] == number[np]) {
//				System.out.println("ruck" + rp + "[" + ruck[rp] + "] = [" + number[np] + "]" + np + "number");
				rc++;
				if (rp >= ruck.length - 2 || np >= number.length - 1) {
					break;
				} else {
					rp++;
					np++;
				}
			} else if (ruck[rp] > number[np]) {
//				System.out.println("ruck" + rp + "[" + ruck[rp] + "] > [" + number[np] + "]" + np + "number");
				if (np >= number.length - 1) {
					break;
				} else {
					np++;
				}
			} else {
//				System.out.println("ruck" + rp + "[" + ruck[rp] + "] < [" + number[np] + "]" + np + "number");
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
			for (int c = 0; c < number.length; c++) {
				if (ruck[ruck.length - 1] == number[c]) {
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

	public static void main(String[] args) {
		int[][] number = { { 8, 12, 26, 27, 30, 44 }, { 4, 7, 11, 16, 30, 37 }, { 9, 12, 29, 36, 39, 40 },
				{ 1, 17, 30, 32, 37, 40 }, { 4, 14, 18, 34, 35, 38 } };

		int[] ruck = { 5, 11, 14, 30, 33, 38, 24 };
		NumberRegister nr = new NumberRegister();
		nr.add(number[0]);
		nr.add(number[1]);
		nr.add(number[2]);
		nr.add(number[3]);
		nr.add(number[4]);
		nr.print();
		int[] n = { 9, 12, 26, 27, 30, 45, 44 };
		System.out.println(nr.ruckCompare(n, number[0]));

	}
}
