import java.util.Scanner;

public class Lab1two {
	public static void main(String[] args) {
		int i = 2013;
		Scanner sc = new Scanner(System.in);
		System.out.print("Введите численность населения:\n");
		double count = sc.nextDouble();
		do {
			System.out.printf("В %d году население = %.0f\n", i, count);
			count = count + count * 0.03;
			i++;
		} while (i <= 2040);
	}
}
