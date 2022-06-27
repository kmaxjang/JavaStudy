package com.sample.binary;

import java.util.Random;

public class Sort {

	// 배열 화면표시
	public static void screen(String msg, int[] arr) {
		if (null != msg) {
			System.out.println(msg);
		}
		System.out.print("[ ");
		for (int d : arr) {
			if(d%600 == 0) System.out.println(" "); // 화면라인 오버시 라인교체				
			System.out.print(d + " ");
		}
		System.out.println("]");
	}

	// 배열 랜덤섞음
	public static void random(int[] arr) {
		Random r = new Random();
		int seed = 0;
		for (int p = 0; p < arr.length; p++) {
			seed = r.nextInt(arr.length);
			if (p == seed) {
				if (p > 0) {
					p--;
				}
				continue;
			}
			arr[p] = arr[seed] + arr[p];
			arr[seed] = arr[p] - arr[seed];
			arr[p] = arr[p] - arr[seed];
		}
	}
	
	// 배열 정렬
	public static void sort(int[] arr, boolean s) {
		int seed = arr.length;
		do {
			seed--;
			for (int p = 0; p < seed; p++) {
				if (s) { // 오름차순
					if (arr[p] < arr[p + 1]) {
						arr[p] = arr[p + 1] + arr[p];
						arr[p + 1] = arr[p] - arr[p + 1];
						arr[p] = arr[p] - arr[p + 1];
					}
				} else { // 내림차순
					if (arr[p] > arr[p + 1]) {
						arr[p] = arr[p + 1] + arr[p];
						arr[p + 1] = arr[p] - arr[p + 1];
						arr[p] = arr[p] - arr[p + 1];
					}
				}
			}
		} while (seed > 1);
	}

	public static void main(String[] args) {
		// 1234567890
		// max min
		// max 6621 화면라인
		// max 50000 이상 오래걸림
		int size = 10000; // 배열크기
		int[] array = new int[size];
		{
			while (size > 0) {
				size--;
				array[size] = size; // 배열 초기화
			}
		}		

		random(array);
		screen("무작위 배열", array);
		sort(array, false);
		screen("배열정렬", array);
	}
}
