import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Task {
	private int w;
	private int[]arr;
	private String s = "";
	public void Update(int w, int[]arr) {
		try {
			Scanner sc = new Scanner(new File("D:\\Input.txt"));
			w = sc.nextInt();
			arr = new int[w];
			for(int i = 0; i < w; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i = 0; i < w; i++) {
				if(arr[i] > 99 && arr[i] < 1000) {
					arr[i] *= 3;
				}
				s += arr[i] + " ";
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int[] getArr() {
		return arr;
	}
	public String getArr2() {
		return s;
	}
	public int getW() {
		return w;
	}
}
		
		
	


