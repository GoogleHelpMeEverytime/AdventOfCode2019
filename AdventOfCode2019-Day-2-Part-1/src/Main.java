import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("src/adv2.txt");
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		
		String line, line2 = null;
		
		while((line = buffer.readLine()) != null) {
			line = line.replace(",", "\n");
			line2 = line;
		}
		
		String[] sv = line2.split("\n");
		
		int [] vec = new int [sv.length];
		
		for(int i = 0; i<sv.length;i++) {
			vec[i] = Integer.parseInt(sv[i]);
		}
		
		
		int result = calc(vec, 12, 2);
		
		
		System.out.println(result);	
	}
	
	
	public static int calc(int[] a, int first, int second) {
		a[1] = first;
		a[2] = second;
		
		for(int i = 0; i < a.length; i = i + 4) {
			
			if(a[i] == 1) {
				
				a[a[i+3]] = a[a[i+1]] + a[a[i+2]];
				
			}
			
			if(a[i] == 2) {
				
				a[a[i+3]] = a[a[i+1]] * a[a[i+2]];
				
			}
		}

		return a[0];
		
	}

}
