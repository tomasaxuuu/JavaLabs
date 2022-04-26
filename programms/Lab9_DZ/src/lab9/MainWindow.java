package lab9;

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
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MainWindow {
	public int count = 0;
	String s = "";
	String str1 = "";
	String [] words;
	String [] words2;
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
						s = fileName;
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
		textArea_1.setBounds(151, 238, 89, 23);
		frame.getContentPane().add(textArea_1);
		
		JButton btnNewButton_2 = new JButton("\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C \u043F\u043E\u0441\u043B\u0435\u0434\u043E\u0432\u0430\u0442\u0435\u043B\u044C\u043D\u043E\u0441\u0442\u044C");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				str1 = textArea_1.getText();
			}
		});
		
		btnNewButton_2.setBounds(90, 266, 220, 23);
		frame.getContentPane().add(btnNewButton_2);
		JButton btnNewButton = new JButton("\u041E\u0431\u0440\u0430\u0431\u043E\u0442\u0430\u0442\u044C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sd = textArea.getText();
				words = sd.split("\n");
				words2 = sd.split(" ");
				for(String word : words){
					if((word.startsWith(str1))) {
						count++;
					}
				}
				for(String words : words2){
					if((words.startsWith(str1))) {
						count++;
					}
				}
					textArea.setText("Успешно обработано!");
					textArea_1.setText("Успешно обработано!");
			}
		});
		btnNewButton.setBounds(253, 238, 118, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u0421\u043E\u0445\u0440\u0430\u043D\u0438\u0442\u044C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hl = "<HTML><HEAD><TITLE>Лабораторная работа №9</TITLE></HEAD><BODY><p align=\"center\"><b>Лабораторная работа №9</b><br><i>Вариант B</i></p><br>Выполнил студент группы <i>ИВТАПбд-11</i><b><i> Мухаметзянов Т. А.</i></b><br>Файл: <b>";
				String h2 = "</b><br>Количество найденных слов: ";
				String h3 = "<br>Начало слова: ";
				JFileChooser sfd = new JFileChooser();
				if(sfd.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
					String fileName = sfd.getSelectedFile().getAbsolutePath();
					try {
						BufferedWriter sw = new BufferedWriter(new FileWriter(new File(fileName)));
						sw.write(hl + s + h2 + "<b>" + count);
						sw.write("</b>");
						sw.write(h3 + "<b>" + str1 + "</b>");
						sw.write("</BODY></HTML>");
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