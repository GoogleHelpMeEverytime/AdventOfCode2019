import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int total = 0;
		
		File file = new File("src/adv.txt");//change file
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		String line;
		
		while((line = buffer.readLine()) != null) {
			total += calcFuel(Integer.parseInt(line));
		}
		
		System.out.println(total);
	}
	
	public static int calcFuel(int mass) {
		if((mass/3-2)<=0) return 0;
		return (mass / 3 - 2) + calcFuel(mass / 3 - 2);
		
	}

}
