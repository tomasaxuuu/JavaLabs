import java.util.Scanner;

public class Lab3 {
	public static void main(String[] args) {
		System.out.println("¬ведите размер фигуры:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i = 1;
		while (i <= n) {
			int j = 1;
			int cnt = n;
			while (j <= i) {
					System.out.print(cnt + " ");
					cnt--;
					j++;
			}
			System.out.println();
			i++;
		}
		sc.close();
	}
}