package lab6Sample;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JPanel;

public class ArrayPanel extends JPanel 
{
	private int[][] arr;
	private int w; // Width
	private int h; // Height
	
	public ArrayPanel()
	{
		try 
		{
			Scanner sc = new Scanner(new File("E:\\Input.txt"));
			
			w = sc.nextInt();
			h = sc.nextInt();
			arr = new int[w][h];
			
			for (int y = 0; y < h; y++)
			{
				for (int x = 0; x < w; x++)
				{
					arr[x][y] = sc.nextInt();
				}
			}
			
			sc.close();
;		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		
		int k = 100;
		int m = 100;
		
		for (int y = 0; y < h; y++)
		{
			for (int x = 0; x < w; x++)
			{
				switch (arr[x][y])
				{
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
					g.setColor(new Color(0, 0, 0));
					break;
					
				case 5:
					g.setColor(new Color(128, 128, 128));
					break;
					
				case 6:
					g.setColor(new Color(255, 255, 0));
					break;
					
				case 7:
					g.setColor(new Color(255, 0, 255));
					break;
					
				case 8:
					g.setColor(new Color(0, 0, 127));
					break;
					
				case 9:
					g.setColor(new Color(0, 127, 127));
					break;
				}
				if (arr[x][y] > 9) {
					g.setColor(new Color(255, 0, 0));
				}
				g.fillRect(k, m, 10, 10);
				
				k += 10;
			}
			
			k = 100;
			m += 10;
		}
	}
	
	public void UpdateArray(Graphics g)
	{
		super.paint(g);
		for (int y = 0; y < h; y++)
		{
			for (int x = 0; x < w; x++)
			{
				
			}
		}
		
		repaint();
	}
}