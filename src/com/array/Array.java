package com.array;

public class Array {

	public final int[] data;
	public final int row;
	public final int colum;

	public Array(int row, int colum) {
		this.row = scope(row);
		this.colum = scope(colum);

		data = new int[row * colum];
		for (int c = 0; c < data.length; c++) {
			data[c] = c + 1;
		}
	}

	// 범위
	private int scope(int velue) {
		if (velue < 1) {
			return 1;
		} else if (velue > 100) {
			return 100;
		}
		return velue;
	}

	public void arrayPrint(int[][] array) {
		StringBuffer sb = new StringBuffer((data.length * 4) + row);
		sb.append("< Cube Array >\n");
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[0].length; y++) {
				sb.append("[" + String.format("%02d", array[x][y]) + "]");
			}
			sb.append("\n");
		}
		sb.append("============");
		System.out.println(sb);
	}

	public void arrayPrint(int[] array) {
		StringBuffer sb = new StringBuffer((data.length * 4) + row);
		sb.append("< Line Arry >\n");
		for (int c = 0; c < data.length; c++) {
			sb.append("[" + String.format("%02d", data[c]) + "]");
		}
		sb.append("\n==============");
		System.out.println(sb);
	}

	public int[][] cubeArray(int[] data, int col, int row) {
		int[][] ca = new int[col][row];
		int count = 0;
		for (int colc = 0; colc < col; colc++) {
			for (int rowc = 0; rowc < row; rowc++) {
				ca[colc][rowc] = data[count++];
			}
		}
		return ca;
	}

	public int[][] rotateMatrix(int[][] matrix, boolean rotate) {
		/* W and H are already swapped */
		int mx = matrix.length;
		int my = matrix[0].length;
		int[][] ret = new int[my][mx];
		for (int x = 0; x < my; x++) {
			for (int y = 0; y < mx; y++) {
				if (rotate) {
					ret[x][y] = matrix[y][my - x - 1];
				} else {
					ret[x][y] = matrix[mx - y - 1][x];
				}
			}
		}
		return ret;
	}

	public static void main(String[] arg) {

		Array a = new Array(9, 9);

		a.arrayPrint(a.data);

		boolean rotate = false;
		int[][] array;
		array = a.rotateMatrix(a.cubeArray(a.data, a.colum, a.row), rotate);
		a.arrayPrint(array);
		array = a.rotateMatrix(array, rotate);
		a.arrayPrint(array);
		array = a.rotateMatrix(array, rotate);
		a.arrayPrint(array);
		array = a.rotateMatrix(array, rotate);
		a.arrayPrint(array);
	}
}