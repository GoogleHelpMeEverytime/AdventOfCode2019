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

		while ((line = buffer.readLine()) != null) {
			line = line.replace(",", "\n");
			line2 = line;
		}

		String[] sv = line2.split("\n");

		int[] vec = new int[sv.length];

		for (int i = 0; i < sv.length; i++) {
			vec[i] = Integer.parseInt(sv[i]);
		}

		vec[1] = 12;
		vec[2] = 2;

		int[] tmp = vec.clone();
		int verb = 0, noun = 0;
		
		for(noun = 0; noun < 100; noun++) {
			for(verb = 0; verb < 100; verb++) {
				tmp = vec.clone();
				tmp = calc(tmp, noun, verb);
				if(tmp[0] == 19690720) {
					System.out.println("NOUN: " + noun);
					System.out.println("VERB: " + verb);
					System.out.println("TOTAL(100 * NOUN + VERB): " + (100*noun+verb));
				}
			}
		}
	}
	
	
	public static int[] calc(int[] a, int noun, int verb) {
		
		a[1] = noun;
		a[2] = verb;
		
		for(int i = 0; i < a.length; i = i + 4)
		{
			if(a[i] == 1) {
				a[a[i+3]] = a[a[i+1]] + a[a[i+2]];
			}
			
			if(a[i] == 2) {
				a[a[i+3]] = a[a[i+1]] * a[a[i+2]];
			}
		}

		return a;
		
	}
	
}
