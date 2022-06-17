import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MainWindow extends Task {
	public static void main (String[] args) throws IOException {
		Task answer = new Task();
		answer.Update(answer.getW(), answer.getArr());
		BufferedWriter sw = new BufferedWriter(new FileWriter(new File("D:\\Output.txt")));
		sw.write(answer.getArr2());
		sw.close();
	}
}
