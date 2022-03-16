package com.lotto;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 ����� ����ϸ� ����� ���� �м� ���α׷�
 ��ڳ���
 
 
 */

public class LottoMain {

	public static void main(String[] args){
		// ��������
		System.out.println("hello word");
		Scanner sc = new Scanner(System.in);
		System.out.print("v"+sc.delimiter());
		System.out.print("v"+sc);
		
		 // Ű����κ��� ���ڿ� �Է¹ޱ�
	    System.out.print("�ƹ� ���ڿ��̳� �Է��� ������: ");
	    System.out.println(sc.nextLine());
	    // Ű����� �Է��� ���ڿ��� �״�� ��µ˴ϴ�.

	    // ���� �Է¹ޱ� (�Ǽ��� �Է��ϸ� ������)
	    System.out.print("�ƹ� ������ �Է��� ������: ");
	    try { // 1.0 ���� �Ǽ��� �߸� �Է��� ��� ���� ó��
	        System.out.println(sc.nextInt() + 1);
	    } catch (InputMismatchException ime) {
	        System.err.println("����! ������ �ƴ� �Ǽ�/���ڸ� �Է��ϼ̱���: " + ime);
	        System.exit(1);
	    }
	    // Ű����� �Է��� ������ 1�� ���Ͽ� ���

		
		 String input = "1 fish 2 fish red fish blue fish";
	     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
	     System.out.println(s.nextInt());
	     System.out.println(s.nextInt());
	     System.out.println(s.next());
	     System.out.println(s.next());
	     
	     s.close();

		sc.close();
	}
}
