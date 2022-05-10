import java.awt.Button;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import javax.swing.JTextArea;

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
	
	public static double func(double x, int m) {
        if(m == 1) {
        	return 2 * x;
        }
        return 2 * Math.pow(x, 2*m-1) / (2*m-1) + func(x, --m);
    }
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u041B\u0430\u0431\u043E\u0440\u0430\u0442\u043E\u0440\u043D\u0430\u044F \u0440\u0430\u0431\u043E\u0442\u0430 \u21165");
		frame.setBounds(100, 100, 812, 477);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 13, 584, 367);
		frame.getContentPane().add(textArea);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(680, 10, 84, 20);
		spinner.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(0)));
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(680, 42, 84, 20);
		spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		
		Button button = new Button("\u0412\u044B\u0447\u0438\u0441\u043B\u0438\u0442\u044C");
		button.setBounds(629, 91, 135, 36);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double N = (double)spinner.getValue();
		        double w = Math.log((1+N) / (1-N));
		        int m = (int)spinner_1.getValue();
		        if(N == 1 || N == -1) {
		        	textArea.setText("Недопустимое значение X");
		        } else {
		        	double u = func(N,m);
		        	textArea.setText("" + w + "\n" + u);
		        }
			}
			
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		frame.getContentPane().add(spinner);
		frame.getContentPane().add(spinner_1);
	}
}
