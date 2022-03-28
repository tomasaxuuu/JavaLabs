package lab6Sample;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

public class ArrayPanel extends JPanel {
	private int[][] arr;
	private int w; // Width
	private int h; // Height
	private int max;
	private int min;
	private int imax = 0;
	private int imin = 0;
	
	public ArrayPanel() {
		try {
			Scanner sc = new Scanner(new File("F:\\Input.txt"));
			
			h = sc.nextInt();
			w = sc.nextInt();
			arr = new int[h][w];
			
			for (int y = 0; y < h; y++)
			{
				for (int x = 0; x < w; x++)
				{
					arr[y][x] = sc.nextInt();
				}
			}
			
			sc.close();
;		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				switch (arr[y][x]) {
				case 0:
					g.setColor(new Color(255, 255, 255));
					break;
					
				case 1:
					g.setColor(new Color(221, 160, 221));
					break;
					
				case 2:
					g.setColor(new Color(245, 222, 179));
					break;
					
				case 3:
					g.setColor(new Color(139, 69, 19));
					break;
					
				case 4:
					g.setColor(new Color(123, 0, 0));
					break;
					
				case 5:
					g.setColor(new Color(128, 128, 128));
					break;
					
				case 6:
					g.setColor(new Color(255, 255, 0));
					break;
					
				case 7:
					g.setColor(new Color(0, 0, 0));
					break;
					
				case 8:
					g.setColor(new Color(0, 0, 127));
					break;
					
				case 9:
					g.setColor(new Color(0, 127, 127));
					break;
				default:
					g.setColor(new Color(255, 132, 123));
					break;
				}
				
				g.fillRect(45 + x * 45, 45 + y * 45, 40, 40);
			}
		}
	}
	
	public void update() {
		max = arr[0][0];
		min = arr[0][0];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if(max < arr[y][x]) {
					max = arr[y][x];
					imax = x;
				}
				if(min > arr[y][x]) {
					min = arr[y][x];
					imin = x;
				}
			}
		}
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				int temp = arr[y][imax];
				arr[y][imax] = arr[y][imin];
				arr[y][imin] = temp;
			}
		}
		repaint();
	}
}