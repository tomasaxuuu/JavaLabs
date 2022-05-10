import java.awt.Graphics;

import javax.swing.JPanel;

public class PaintPanel extends JPanel {
	
	private int depth; 
	public void DrawDepth(int gl) {
		depth = gl; 
		repaint();
	}
	private void DrawRecurStar(Graphics g, int x, int y, int size) {
		g.drawLine(x, y - size, x + size / 4, y - size / 4);
		g.drawLine(x + size / 4, y - size / 4, x + size, y);
		g.drawLine(x + size, y, x + size / 4, y + size / 4);
		g.drawLine(x + size / 4, y + size / 4, x, y + size);
		g.drawLine(x, y + size, x - size / 4, y + size / 4);
		g.drawLine(x - size / 4, y + size / 4, x - size, y);
		g.drawLine(x - size, y, x - size / 4, y - size / 4);
		g.drawLine(x - size / 4, y - size / 4, x ,y - size);
	}
	
	private void RecurStar(Graphics g, int x, int y, int size, int depth) { 
		if (depth < 1) {
			return; 
		}
		DrawRecurStar(g, x, y, size);
		RecurStar(g, x + size, y + size /  100, size / 2, depth - 1);
		RecurStar(g, x - size, y - size / 50, size / 2, depth - 1);
		RecurStar(g, x + size / 100, y - size, size / 2, depth - 1);
		RecurStar(g, x - size / 100, y + size, size / 2, depth - 1);
	}
	
@Override
	
	public void paint(Graphics g) {
		super.paint(g);
		RecurStar(g, 300, 200, 100, depth);
	}
	
	
}
