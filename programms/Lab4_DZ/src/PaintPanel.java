import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	private int figureType = 0;
	
	public void setFigureType(int fType) {
		figureType = fType;
		repaint();
	}
	private void drawSquare(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(20, 20, 50, 50);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		if (figureType == 0) {
			// горизонт
			g.setColor(new Color(135, 206, 235));
			g.fillRect(0, 0, 575, 260);
			g.setColor(Color.blue);
			g.fillRect(0, 260, 575, 219);
			// солнце
			g.setColor(Color.yellow);
			g.fillOval(450, 20, 70, 70);
			// рыба
			g.setColor(Color. red);
			g.fillOval(100, 300, 100, 60);
			g.setColor(Color. yellow);
			g.fillOval(170, 323, 10, 10);
			// плавники
			g.setColor(Color. yellow);
			int x[] = { 130, 130, 170 };
			int y[] = { 302, 272, 302};
			g.fillPolygon(x, y, 3);

			int x1[] = { 130, 130, 170 };
			int y1[] = { 360, 390, 360};
			g.fillPolygon(x1, y1, 3);
			
			int x2[] = { 200, 210, 210 };
			int y2[] = { 330, 325, 335};
			g.fillPolygon(x2, y2, 3);
			
			int x3[] = { 100, 80, 80 };
			int y3[] = { 330, 345, 315};
			g.fillPolygon(x3, y3, 3);
			// птицы
			g.setColor(Color.black);
			g.drawLine(20, 20, 40, 40);
			g.drawLine(40, 40, 60, 20);
			
			g.drawLine(50, 50, 60, 60);
			g.drawLine(60, 60, 70, 50);
			
			g.drawLine(100, 70, 120, 90);
			g.drawLine(120, 90, 140, 70);
			
			// ма€к
			g.setColor(new Color(222, 184, 135));
			g.fillRect(200, 220, 140, 40);
			g.setColor(Color.white);
			g.fillRect(235, 100, 70, 120);
			g.setColor(Color.red);
			int mx[] = { 220, 270, 320 };
			int my[] = { 100, 70, 100};
			g.fillPolygon(mx, my, 3);
			g.setColor(Color.black);
			g.fillOval(257, 115, 20, 20);
			g.fillOval(254, 145, 28, 28);
			g.fillOval(251, 180, 35, 35);
			// лодка
			g.setColor(new Color(139, 69, 19));
			int lx[] = { 400, 430, 510, 550 };
			int ly[] = { 300, 350, 350, 300 };
			g.fillPolygon(lx, ly, 4);
			
			g.setColor(Color.white);
			int m1[] = { 420, 460, 460 };
			int m2[] = { 295, 250, 295 };
			g.fillPolygon(m1, m2, 3);
			
			int m3[] = { 465, 465, 520 };
			int m4[] = { 215, 295, 295 };
			g.fillPolygon(m3, m4, 3);
			
			g.setColor(new Color(135, 206, 235));
			g.fillOval(430, 310, 20, 20);
			g.fillOval(460, 310, 20, 20);
			g.fillOval(490, 310, 20, 20);
			
			g.setColor(Color.green);
			g.fillRect(290, 370, 10, 70);
			g.fillRect(310, 350, 10, 90);
			g.fillRect(330, 370, 10, 70);
		}
		else {
			drawSquare(g);
		}
	}
}
