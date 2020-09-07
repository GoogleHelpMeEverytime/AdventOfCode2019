import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Coordinates start = new Coordinates(0, 0);
		ArrayList<Coordinates> movement1 = new ArrayList<Coordinates>();
		ArrayList<Coordinates> movement2 = new ArrayList<Coordinates>();
		ArrayList<String> listMove1 = new ArrayList<String>();
		ArrayList<String> listMove2 = new ArrayList<String>();
		ArrayList<Coordinates> inters = new ArrayList<Coordinates>();

		loadFile("src/adv3.txt", listMove1, listMove2);

		movement1.add(start);

		for (String s : listMove1) {
			movementA(s, movement1, movement1.get(movement1.size() - 1));

		}

		movement2.add(start);

		for (String s : listMove2) {
			movementA(s, movement2, movement2.get(movement2.size() - 1));

		}

		intersection(movement1, movement2, inters);

		ArrayList<Integer> steps = new ArrayList<Integer>();
		for(Coordinates c : inters) {
			steps.add(calcSteps(movement1, c) + calcSteps(movement2, c));
		}

		int min = 999999999;
		for(int i : steps) {
			if(i < min) min = i;
		}
		
		System.out.println(min);
	}

	public static void loadFile(String pathNameFile, ArrayList<String> listMove1, ArrayList<String> listMove2)
			throws IOException {

		File file = new File(pathNameFile);
		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);

		String[] line1 = buffer.readLine().split(",");
		String[] line2 = buffer.readLine().split(",");

		for (String s : line1) {
			listMove1.add(s);
		}
		for (String s : line2) {
			listMove2.add(s);
		}
		buffer.close();
	}

	public static void movementA(String a, ArrayList<Coordinates> movement, Coordinates last) {
		int sub = Integer.parseInt(a.substring(1));
		char dir = a.charAt(0);

		switch (dir) {
		case 'R':
			for (int i = 0; i < sub; i++) {
				Coordinates c = new Coordinates(last.getX() + i + 1, last.getY());
				movement.add(c);
			}
			break;

		case 'L':
			for (int i = 0; i < sub; i++) {
				Coordinates c = new Coordinates(last.getX() - i - 1, last.getY());
				movement.add(c);
			}
			break;

		case 'U':
			for (int i = 0; i < sub; i++) {
				Coordinates c = new Coordinates(last.getX(), last.getY() + i + 1);
				movement.add(c);
			}
			break;

		case 'D':
			for (int i = 0; i < sub; i++) {
				Coordinates c = new Coordinates(last.getX(), last.getY() - i - 1);
				movement.add(c);
			}
			break;

		default:
			break;
		}
	}

	public static void intersection(ArrayList<Coordinates> movement1, ArrayList<Coordinates> movement2,
			ArrayList<Coordinates> inters) {

		for (int i = 1; i < movement1.size() - 1; i++) {
			for (int j = 1; j < movement2.size() - 1; j++) {
				if (movement1.get(i).getX() == movement2.get(j).getX()
						&& movement1.get(i).getY() == movement2.get(j).getY()) {
					inters.add(new Coordinates(movement1.get(i).getX(), movement1.get(i).getY()));
				}
			}
		}

	}

	public static int calcSteps(ArrayList<Coordinates> move, Coordinates inters) {
		
		int steps = 0;
		
		for(Coordinates c : move) {
			if(c.getX() == inters.getX() && c.getY() == inters.getY()) {
				steps = move.indexOf(c);
			}
		}

		return steps;
		
	}

}

