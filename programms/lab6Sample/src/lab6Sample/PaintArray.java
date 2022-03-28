package lab6Sample;
import java.awt.EventQueue;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;

public class PaintArray {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaintArray window = new PaintArray();
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
	public PaintArray() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 959, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ArrayPanel panel = new ArrayPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBounds(10, 10, 774, 572);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("\u041F\u0440\u0435\u043E\u0431\u0440\u0430\u0437\u043E\u0432\u0430\u0442\u044C");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
//		btnNewButton.setBackground(new Color(124, 252, 0));
//		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.update();
			}
		});
		btnNewButton.setBounds(789, 234, 144, 44);
		frame.getContentPane().add(btnNewButton);
	}

}
