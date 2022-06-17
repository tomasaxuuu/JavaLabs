import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Person {
	private int w;
	private int h;
	private int [][]arr;
	private int count = 0;
	private String s = "";
	
	public void Update(int w, int h, int[][]arr) {
		try {
			Scanner sc = new Scanner(new File("D:\\Input.txt"));
			
			w = sc.nextInt();
			h = sc.nextInt();
			arr = new int[w][h];
			
			for (int i = 0; i < w; i++){
				for (int j = 0; j < h; j++){
					arr[i][j] = sc.nextInt();
				}
			}

			sc.close();
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < w; i++){
			for (int j = 0; j < h; j++){
				if(i % 2 == 0) {
					if (arr[i][j] % 2 == 0) {
						count++;
					}
				}
			}
		}
		s += count;
	}

	public String getCount() {
		return s;
	}
	
	public int getW() {
		return w;
	}
	
	public int getH() {
		return h;
	}
	
	public int[][] getArr() {
		return arr;
	}
	
}
