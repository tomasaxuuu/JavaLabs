import java.util.Scanner;

public class Lab1 {
	public static void main(String[] args) {
		int i = 2013;
		Scanner sc = new Scanner(System.in);
		System.out.print("������� ����������� ���������:\n");
		double count = sc.nextDouble();
		while (i <= 2040) {
			System.out.printf("� %d ���� ��������� = %.0f\n", i, count);
			count = count + count * 0.03;
			i++;
		}
	}
}
