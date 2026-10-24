package com.lotto.tools;

import com.lotto.Rule;

public class Combination {
/*
	private int length;
	private int[] numbers;
	private int max_number;
	private int min_number;
*/
	Rule rule;
	public int[] luky = new int[6];

	public Combination() {
		rule = new Rule();
		int[] winningnum = { 3, 11, 13, 21, 33, 37 };
		rule.setWinningNumbers(winningnum, 18);
		for (int i = 0; i < luky.length; i++) {
			luky[i] = 0;
		}

	}

	public void number(int[] numbers) {
		int length = 6; // �� ����
		int[] ball = new int[length];
		int[] ball_point = new int[length];
		int[] ball_pointmax = new int[length];
		int count = 0;
		int point = length - 1;
		boolean flag = true;
		// �ʱ�ȭ
		for (int cycle = 0; cycle < ball.length; cycle++) {
			ball_point[cycle] = cycle;
			ball_pointmax[cycle] = (numbers.length - (ball.length - cycle));
		}
//		print("�ʱ��ڸ���ġ", ball_point);
//		print("�ڸ��� ��ġ �ִ����", ball_pointmax);
		do {
			for (int cycle = 0; cycle < ball.length; cycle++) {
				ball[cycle] = numbers[ball_point[cycle]];
			}
			// ��ȣ��°� Ƚ��üũ------------------
			count++;
			output(count, ball);
			// ------------------------------
			while (flag && (point >= 0)) {
				if (ball_point[point] >= ball_pointmax[point]) {
					point--;
				} else {
					ball_point[point]++;
					for (; point < length - 1; point++) {
						ball_point[point + 1] = ball_point[point] + 1;
					}
					flag = false;
				}
			}

			if (true) {// count < 1004) {
				flag = true;
			}
		} while (flag && (point >= 0));

//		print("�����ڸ� ������", ball_point);
		print("ī����( " + count + " ) ���������: ", ball);
	}

	public void print(String title, int[] number) {
		System.out.println(title);
		for (int i = 0; i < number.length; i++) {
			System.out.print("[" + number[i] + "]");
		}
		System.out.println(" ");
	}

	public void output(int count, int[] ball) {
		luky[rule.Rank(ball)]++;
/*		
//		print("��ȣ���(" + count + ")", ball);
		int result = rule.Rank(ball);
		if (result == 0) {
			System.out.println("[ �� ]");
		} else {
			System.out.println("[ " + result + "�� ]");
		}
		luky[result]++;
//		*/
	}

	public void luky(int win) {
		luky[win]++;
	}

	public void lukyprint() {
		for (int i = 0; i < luky.length; i++) {
			System.out.println(i + "�� ��÷" + luky[i]);
		}
	}

	public static void main(String[] args) {

		Combination chance = new Combination();

		int[] number = new int[45];
		int random = 0;
		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}

		int count = 0;
		while (100 > count) {
			for (int i = 0; i < number.length; i++) {
				random = (int) (Math.random() * 45);
				if (i != random) {
					number[i] += number[random];
					number[random] = number[i] - number[random];
					number[i] -= number[random];
				}
			}
			count++;
		}
		chance.print("100�� ������", number);
		
		int seed = 5; // 1~5 ����
		int[] snum = new int[45/seed];
		for (int c = 0; c < seed; c++) {
			for (int i = 0; i < snum.length; i++) {
				snum[i] = number[i + (c * (45/seed))];
			}
			chance.print("ball", snum);
			chance.number(snum);
			chance.lukyprint();
		}
	}
}
