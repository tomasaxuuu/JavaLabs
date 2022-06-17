import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main extends Person {
	public static void main (String[] args) throws IOException {
		Person arr = new Person();
		arr.Update(arr.getW(), arr.getH(), arr.getArr());
		File file = new File("D:\\Output.txt");
	    FileOutputStream fileOutputStream = new FileOutputStream(file);
	    fileOutputStream.write(arr.getCount().getBytes());
	    fileOutputStream.close();
	}
}
