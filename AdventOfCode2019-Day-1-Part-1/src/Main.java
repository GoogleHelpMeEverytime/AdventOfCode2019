import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("src/adv.txt");//change file
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		String line = null;
		
		int total = 0;
		
		while((line = buffer.readLine()) != null) {
			total+=Integer.parseInt(line)/3-2;
		}
		
		System.out.println(total);

	}

}
