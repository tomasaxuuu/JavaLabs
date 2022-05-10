
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

public class MainWindow {
	private JFrame frame;
	String sort = "";
	char[] charArray;
	String[] a;
	String sortedString = "";
	String temp;
	int[] numArr;
	String [] words;
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
		frame.setBounds(100, 100, 633, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 597, 195);
		frame.getContentPane().add(textArea);
		
		JButton button = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser ofd = new JFileChooser();
				if(ofd.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
				String fileName = ofd.getSelectedFile().getAbsolutePath();
					try {
						Scanner sc = new Scanner(new File(fileName));
						String str = "";
						while (sc.hasNext()) {
							str += sc.nextLine() + "\r\n";
						}
						sc.close();
						textArea.setText(str);
					} catch (FileNotFoundException e1){
						e1.printStackTrace();
					}
				};
			}
		});
		
		button.setBounds(10, 238, 131, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("\u041E\u0431\u0440\u0430\u0431\u043E\u0442\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort = textArea.getText();
				words = sort.split("\n");
				boolean k = true;
				for (int i = words.length - 1; i > words.length - 2; i--) {
                    for (int j = 0; j < i; j++) {
                    	if(words[j].compareTo(words[j + 1]) > -1) {
	                    	temp = words[j];
	                    	words[j] = words[j + 1];
	                        words[j + 1] = temp;
	                        k = false;
                    	}
                    } 
                }
				textArea.setText(String.join("\n", words));
				if (k) {
					textArea.setText("Сортировка закончена");
				}
			}
		});
		btnNewButton.setBounds(253, 238, 118, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser sfd = new JFileChooser();
				if(sfd.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					String fileName = sfd.getSelectedFile().getAbsolutePath();
					try {
						BufferedWriter sw = new BufferedWriter(new FileWriter(new File(fileName)));
						sw.write(String.join("\n", words));
						sw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_1.setBounds(467, 238, 140, 23);
		frame.getContentPane().add(btnNewButton_1);

		
	}
}