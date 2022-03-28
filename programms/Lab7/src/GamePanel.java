import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GamePanel extends JPanel {
	private int x;
	private int y;
	private int h;
	private int w;
	private int[][] arr;
	private int numberLvl = 1;
	
	public GamePanel() {
		newLvl();
	}
	
	public void newLvl() {
		String LVL = "E:\\JAVA\\";
		LVL += numberLvl + ".txt";
		try {
			Scanner sc = new Scanner(new File(LVL));
			h = sc.nextInt();
			w = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			arr = new int[h][w];
			
			for (int j = 0; j < h; j++) {
				for (int i = 0; i < w; i++) {
					arr[j][i] = sc.nextInt();
				}
			}
			
			sc.close();		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
	
	private void colorGame(Graphics g) {
		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
					switch (arr[j][i]) {
						case 0:
							g.setColor(new Color(221, 160, 221));
							break;
						case 1:
							g.setColor(new Color(70, 70, 70));
							break;
						case 2:
							g.setColor(new Color(255, 0, 0));
							break;
						case 3:
							g.setColor(new Color(255, 0, 0));
							break;
						case 5:
							g.setColor(new Color(255, 0, 0));
							break;
						default:
							g.setColor(new Color(0, 0, 128));
					}
				g.fillRect(35 + i * 35, 35 + j * 35, 40, 40);
				g.setColor(new Color(0, 0, 0));
				g.drawRect(35 + i * 35, 35 + j * 35, 40, 40);
				
			}
		}
		g.setColor(new Color(154, 205, 50));
		g.fillRect(38 + x * 35, 38 + y * 35, 30, 30);
	}
	
	public void moveLeft() {
		if (arr[y][x - 1] == 0) {
			x--;
		}
		else if (arr[y][x - 1] == 4) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Lose!", "Sorry!" , JOptionPane.INFORMATION_MESSAGE);
            x--;
            newLvl();
		}
		else if (arr[y][x - 1] == 2) {
			numberLvl = 2;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level one completed!" , JOptionPane.INFORMATION_MESSAGE);
            x--;
            newLvl();
		}
		else if (arr[y][x - 1] == 3) {
			numberLvl = 3;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level two completed!" , JOptionPane.INFORMATION_MESSAGE);
			x--;
			newLvl();
		}
		else if (arr[y][x - 1] == 5) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Cool!", "The game is over!" , JOptionPane.INFORMATION_MESSAGE);
			x--;
			newLvl();
		}
		repaint();
	}
	
	public void moveUp() {
		if (arr[y - 1][x] == 0) {
			y--;
		}
		else if (arr[y - 1][x] == 4) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Lose!", "Sorry!" , JOptionPane.INFORMATION_MESSAGE);
			y--;
			newLvl();
		}
		else if (arr[y - 1][x] == 2) {
			numberLvl = 2;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level one completed!" , JOptionPane.INFORMATION_MESSAGE);
			y--;
			newLvl();
		}
		else if (arr[y - 1][x] == 3) {
			numberLvl = 3;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level two completed!" , JOptionPane.INFORMATION_MESSAGE);
			y--;
			newLvl();
		}
		else if (arr[y - 1][x] == 5) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Cool!", "The game is over!" , JOptionPane.INFORMATION_MESSAGE);
			y--;
			newLvl();
		}
		repaint();
	}
	
	public void moveRight() {
		if (arr[y][x + 1] == 0) {
			x++;
		}
		else if (arr[y][x + 1] == 4) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Lose!", "Sorry!" , JOptionPane.INFORMATION_MESSAGE);
            x++;
            newLvl();
		}
		else if (arr[y][x + 1] == 2) {
			numberLvl = 2;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level one completed!" , JOptionPane.INFORMATION_MESSAGE);
            x++;
            newLvl();
		}
		else if (arr[y][x + 1] == 3) {
			numberLvl = 3;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level two completed!" , JOptionPane.INFORMATION_MESSAGE);
			x++;
			newLvl();
		}
		else if (arr[y][x + 1] == 5) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Cool!", "The game is over!" , JOptionPane.INFORMATION_MESSAGE);
			x++;
			newLvl();
		}
		repaint();
	}
	
	public void moveDown() {
		if (arr[y + 1][x] == 0) {
			y++;
		}
		else if (arr[y + 1][x] == 4) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Lose!", "Sorry!" , JOptionPane.INFORMATION_MESSAGE);
			y++;
			newLvl();
		}
		else if (arr[y + 1][x] == 2) {
			numberLvl = 2;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level one completed!" , JOptionPane.INFORMATION_MESSAGE);
			y++;
			newLvl();
		}
		else if (arr[y + 1][x] == 3) {
			numberLvl = 3;
			JOptionPane.showMessageDialog(null, "Go next Lvl!", "Level two completed!" , JOptionPane.INFORMATION_MESSAGE);
			y++;
			newLvl();
		}
		else if (arr[y + 1][x] == 5) {
			numberLvl = 1;
			JOptionPane.showMessageDialog(null, "Cool!", "The game is over!" , JOptionPane.INFORMATION_MESSAGE);
			y++;
			newLvl();
		}
		repaint();
	}
	
	@Override
	
	public void paint(Graphics g) {
		super.paint(g);
		colorGame(g);
	}
}
