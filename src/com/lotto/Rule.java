package com.lotto;

public class Rule {

	private int max_number = 45;
	private int min_number = 1;
	private int length = 6;
	private int[] winningnum = new int[length];
	private int bounsnum;

	private boolean register = false;

	public Rule() {

	}

	public boolean setWinningNumbers(int[] winningnum, int bounsnum) {
		if (winningnum.length == length) {
			for (int i = 0; i < length; i++) {
				if (winningnum[i] < min_number && winningnum[i] > max_number) {
					return false;
				}
				if (winningnum[i] == bounsnum) {
					return false;
				}
				for (int b = i + 1; b < length; b++) {
					if (winningnum[i] == winningnum[b]) {
						return false;
					}
				}
			}
			System.arraycopy(winningnum, 0, this.winningnum, 0, this.winningnum.length);
			this.bounsnum = bounsnum;
			register = true;
			return true;
		}
		return false;
	}

	public int[] getWinningNumbers() {
		if (!register)
			return null;
		return winningnum;
	}

	public int Rank(int[] numbers) {

		int[] result = Compare(winningnum, numbers, false);
		if (result == null)
			return 1;
		switch (result.length) {
		case 1:
			if (bounsnum == result[0]) {
				return 2;
			}
			return 3;
		case 2:
			return 4;
		case 3:
			return 5;
		}
		return 0;
	}

	// continue;
	public int[] Compare(int[] compare_a, int[] compare_b, boolean check) {

		int count = 0, b = 0;
		for (int a = 0; a < compare_a.length; a++) {
			for (b = count; b < compare_b.length; b++) {
				if (compare_a[a] == compare_b[b]) {
					if (b != count) {
						compare_b[count] += compare_b[b];
						compare_b[b] = compare_b[count] - compare_b[b];
						compare_b[count] -= compare_b[b];
					}
					count++;
					break;
				}
			}
		}

		if (check && count == 0)
			return null;
		if (!check && count == compare_b.length)
			return null;

		int[] result = null;
		if (check) {
			result = new int[count];
			System.arraycopy(compare_b, 0, result, 0, result.length);
		} else {
			result = new int[compare_b.length - count];
			System.arraycopy(compare_b, count, result, 0, result.length);
		}
		return result;
	}

	public int compare(int number, int[] comparenum) {
		for (int i = 0; i < comparenum.length; i++) {
			if (i == comparenum[i])
				return i;
		}
		return -1;
	}

	public static void main(String[] arg) {

		int[] winningnum = { 1, 2, 3, 4, 5, 6 };
		int[][] numbers = { { 7, 8, 9, 10, 11, 12 }, { 5, 7, 8, 9, 4, 3 }, { 3, 11, 12, 13, 16, 5 },
				{ 1, 2, 3, 4, 15, 16 }, { 1, 2, 3, 4, 15, 6 }, { 1, 2, 3, 4, 5, 16 }, { 1, 2, 3, 4, 5, 6 },
				{ 11, 12, 13, 14, 15, 6 } };

		int bouns = 16;

		Rule rule = new Rule();
		rule.setWinningNumbers(winningnum, bouns);

		for (int i = 0; i < numbers.length; i++) {
			System.out.print("���Ǵ�÷");
			for (int a = 0; a < numbers[i].length; a++) {
				System.out.print("[" + numbers[i][a] + "]");
			}
			System.out.print("\t");
			int result = rule.Rank(numbers[i]);
			if (result == 0) {
				System.out.println("��");
				continue;
			}
			System.out.println("[ " + result + "�� ]");
		}
		
		
		
		
		

	}

}
