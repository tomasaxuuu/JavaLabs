import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import java.awt.BorderLayout;
import java.awt.Font;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setResizable(false);
		frame.setTitle("\u041B\u0430\u0431\u043E\u0440\u0430\u0442\u043E\u0440\u043D\u0430\u044F \u0440\u0430\u0431\u043E\u0442\u0430 \u21163");
		frame.setBounds(100, 100, 769, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 567, 414);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Courier New", Font.PLAIN, 14));
		panel.add(textArea, BorderLayout.CENTER);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(581, 79, 162, 31);
		spinner.setValue(2);
		frame.getContentPane().add(spinner);
		
		JLabel lblNewLabel = new JLabel("\u0423\u043A\u0430\u0436\u0438\u0442\u0435 \u0440\u0430\u0437\u043C\u0435\u0440:");
		lblNewLabel.setBounds(581, 53, 162, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("do While");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				String result = "";
				int i = 1;
				do {
					int j = 1;
					int cnt = n;
					do {
						result += cnt + " ";
						cnt--;
						j++;
					} while (j <= i);
					result += "\n";
					i++;
				} while (i <= n);
				textArea.setText(result);
			}
		});
		btnNewButton.setBounds(581, 11, 162, 31);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("While");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = (int)spinner.getValue();
				String result = "";
				int i = 1;
				while (i <= n) {
					int j = 1;
					int cnt = n;
					while (j <= i) {
						result += cnt + " ";
						cnt--;
						j++;
					}
					result += "\n";
					i++;
				}
				textArea.setText(result);
			}
		});
		btnNewButton_1.setBounds(581, 136, 162, 31);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("C\u0431\u0440\u043E\u0441\u0438\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("—брошено");
			}
		});
		btnNewButton_2.setBounds(587, 402, 156, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		
	}
}
