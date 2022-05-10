
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
import java.awt.Font;
import java.awt.Color;

public class MainWindow {
	private JFrame frame;
	String sort = "";
	char[] charArray;
	String[] a;
	String sortedString = "";
	int temp = 0;
	int co = 0;
	int[] numArr;
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
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_1.setBounds(10, 11, 597, 23);
		frame.getContentPane().add(textArea_1);
		
		JButton btnNewButton = new JButton("\u041E\u0431\u0440\u0430\u0431\u043E\u0442\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sort = textArea.getText();
				String strArr[] = sort.split(", ");
			    int[] numArr = new int[strArr.length];
			    for (int i = 0; i < strArr.length; i++) {
			    	numArr[i] = Integer.parseInt(strArr[i]);
			    }
			    boolean k = true;
			    for (int i = 0; i < numArr.length - 1; i++) {
			    	if (numArr[i + 1] < numArr[i]) {
			    		temp = numArr[i];
			    		numArr[i] = numArr[i + 1];
			    		numArr[i + 1] = temp;
			    		k = false;
			    	}
			    }
			    a = Arrays.toString(numArr).split("[\\[\\]]")[1].split(", ");
		    	textArea.setText(Arrays.toString(a).replaceAll("^\\[|\\]$", ""));
		    	if (k) {
		    		textArea.setText("Сортировка закончена!");
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
						sw.write(Arrays.toString(a).replaceAll("^\\[|\\]$", ""));
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