package lab2two;

import java.util.Scanner;

public class lab2two {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¬ведите размер фигуры:");
		int n = sc.nextInt();
		int i = 1;
		do {
			int j = 1;
			int cnt = n;
			do {
				System.out.print(cnt + " ");
				cnt--;
				j++;
			} while (j <= i);
			System.out.println();
			i++;
		} while (i <= n);
		sc.close();
	}
}