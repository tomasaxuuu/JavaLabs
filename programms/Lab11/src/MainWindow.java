import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;


import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class MainWindow {

	private JFrame frame;
	private JTable table;
	private List list = new List();
	private boolean position = false;
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
		String[][] data = {
	            {"Мухаметзянов", "Тимур", "Александрович", "Мужской"},
	            {"Ятманова", "Влада", "Валерьевна", "Женский"},
	            {"Аронов", "Владимир", "Владимирович", "Мужской"},
	            {"Мухаметзянова", "Анастасия", "Александровна", "Женский"},
	            {"Чанков", "Дмитрий", "Сергеевич", "Мужской"},
	            {"Гаязов", "Тимур", "Рамисович", "Мужской"},
	        };

	        for (int i = 0; i < data.length; i++) {
	            list.addLast(data[i][0], data[i][1], data[i][2], data[i][3]);
	        }
	        
	        
	        DefaultTableModel model = (DefaultTableModel)table.getModel();
            Node cur = list.getHead();

            model.setRowCount(0);

            while (cur != null) {
                model.addRow(new Object[] {cur.lastName, cur.Name, cur.middleName, cur.gender});
                cur = cur.next;
            } 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frame = new JFrame();
		 frame.setTitle("\u041B\u0430\u0431\u043E\u0440\u0430\u0442\u043E\u0440\u043D\u0430\u044F \u0440\u0430\u0431\u043E\u0442\u0430 \u211611");
	        frame.setBounds(100, 100, 816, 514);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.getContentPane().setLayout(null);
	        
	        table = new JTable();
	        table.setForeground(Color.BLACK);
	        table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        table.setFillsViewportHeight(true);
	        table.setFont(new Font("Times New Roman", Font.BOLD, 16));
	        table.setModel(new DefaultTableModel(
	            new String[][] {},
	            new String[] {
	                "LastName", "Name", "MiddleName", "Gender"
	            }
	        ));
	        table.setBounds(10, 10, 594, 426);
	        table.setRowHeight(24);
	        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 14));

	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(10, 11, 575, 452);
	        frame.getContentPane().add(scrollPane);
	        
	        JButton btnNewButton = new JButton("\u041E\u0442\u043E\u0431\u0440\u0430\u0436\u0435\u043D\u0438\u0435 \u0441\u043F\u0438\u0441\u043A\u0430");
	        btnNewButton.setBackground(Color.GREEN);
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		DefaultTableModel model = (DefaultTableModel)table.getModel();
	        		position = !position;
	        		Node cur;
	                if(!position) {
	                	cur = list.getTail();
                    } else {
                    	cur = list.getHead();
                    }
	                model.setRowCount(0);

	                while (cur != null) {
	                    model.addRow(new Object[] {cur.lastName, cur.Name, cur.middleName, cur.gender});
	                    if(!position) {
	                    	cur = cur.prev;
	                    } else {
	                    	cur = cur.next;
	                    }
	                }
	                
	        	}
	        });
	        btnNewButton.setBounds(595, 14, 195, 31);
	        frame.getContentPane().add(btnNewButton);
	        JTextArea textArea = new JTextArea();
	        
	        JButton btnNewButton_1 = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0432 \u0441\u043F\u0438\u0441\u043E\u043A");
	        btnNewButton_1.setForeground(Color.WHITE);
	        btnNewButton_1.setBackground(Color.BLUE);
	        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) { //добавление пользователя
	        		String lastName = JOptionPane.showInputDialog("Введите фамилию!");
	        		String Name = JOptionPane.showInputDialog("Введите имя!");
	        		String midName = JOptionPane.showInputDialog("Введите отчество!");
	        		String gender = JOptionPane.showInputDialog("Введите пол!");
	        		DefaultTableModel model = (DefaultTableModel)table.getModel();
	        		list.addLast(lastName, Name, midName, gender);
	                model.addRow(new Object[] {lastName, Name, midName, gender});
	        	}
	        });
	        btnNewButton_1.setBounds(595, 56, 195, 31);
	        frame.getContentPane().add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("\u0423\u0434\u0430\u043B\u0438\u0442\u044C \u0438\u0437 \u0441\u043F\u0438\u0441\u043A\u0430");
	        btnNewButton_2.setBackground(Color.YELLOW);
	        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {// удаление
	        		String lastName = JOptionPane.showInputDialog("Введите фамилию для удаления пользователя!");
	        		DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.setRowCount(0);
                    list.removeAt(lastName, true);
	        		Node cur = list.getHead();

                     while (cur != null) {
                         model.addRow(new Object[] {cur.lastName, cur.Name, cur.middleName, cur.gender});
                         cur = cur.next;
                     } 
                     

	        	}
	        });
	        btnNewButton_2.setBounds(595, 98, 195, 31);
	        frame.getContentPane().add(btnNewButton_2);
	        
	        JButton btnNewButton_3 = new JButton("\u041D\u0430\u0439\u0442\u0438 \u043F\u043E \u0438\u043C\u0435\u043D\u0438");
	        btnNewButton_3.setBackground(Color.RED);
	        btnNewButton_3.setForeground(Color.WHITE);
	        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
	        btnNewButton_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String Name = JOptionPane.showInputDialog("Введите имя для поиска");
	        		DefaultTableModel model = (DefaultTableModel)table.getModel();
                    model.setRowCount(0);
                    list.removeAt(Name, true);
	        		Node cur = list.getHead();

                     while (cur != null) {
                    	 if (cur.Name.equals(Name) == true) {
                    		 model.addRow(new Object[] {cur.lastName, cur.Name, cur.middleName, cur.gender});
                         }
                         cur = cur.next;
                     } 
	        	}
	        });
	        btnNewButton_3.setBounds(595, 140, 195, 31);
	        frame.getContentPane().add(btnNewButton_3);
	       
	}
}
