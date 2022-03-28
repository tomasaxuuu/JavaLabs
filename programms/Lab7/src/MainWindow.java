import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class MainWindow {
private int h;
private int w;
private int[][] arr;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		UIManager.setLookAndFeel(UIManeger.getSystemLookAndFeel)
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u041B\u0430\u0431\u043E\u0440\u0430\u0442\u043E\u0440\u043D\u0430\u044F \u0420\u0430\u0431\u043E\u0442\u0430 \u21167");
		frame.setBounds(100, 100, 847, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		GamePanel panel = new GamePanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 11, 811, 475);
		frame.getContentPane().add(panel);
		
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch(keyCode) {
				case KeyEvent.VK_LEFT:
					panel.moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					panel.moveRight();
					break;
				case KeyEvent.VK_UP:
					panel.moveUp();
					break;
				case KeyEvent.VK_DOWN:
					panel.moveDown();
					break;
				default:
					break;
				}
			}
			
		});
	}
}
