import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Quiz 
{
	private static List<String> list;
	private static int questions;
	private static int correctAnswers;
	private static Random randomizer;
	private static Scanner scanner;
	private static String filename = "exampleQuiz.txt";

	public static void main(String [] args) 
	{
		initData();
		readFileIntoList();
		startQuiz();
		endQuiz();
	}

	private static void initData() 
	{
		File f = new File(filename);
		if(!f.exists() || f.isDirectory()) 
		{
			System.out.println("Could not find file in path, or file is a directory.");
			System.out.println("Program quitting.");
			System.exit(1);
		}
		list = new ArrayList<String>();
		questions = 0;
		correctAnswers = 0;
		randomizer = new Random();
		scanner = new Scanner(System.in);
	}

	private static void readFileIntoList()
	{
		//still have to do a try-catch even though we know it exists if we reached here
		try {
			FileReader fr = new FileReader(filename); 
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) 
			{
				list.add(line);
				questions += 1;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(2);
		}
		System.out.println(filename + " loaded");
	}

	private static void startQuiz() {
		//randomly get line instead of same order each time
		while(list.size() > 0) {
			int random = randomizer.nextInt(list.size());
			String line = list.get(random);
			list.remove(random);

			String[] tokens = line.split("\\?");
			System.out.println(tokens[0]+"?");
			waitForEnterKey();
			System.out.println(tokens[1].substring(1)+"\n");
		}
		/*for(String line : list) 
		{
			String[] tokens = line.split("\\?");
			System.out.println(tokens[0]+"?");
			waitForEnterKey();
			System.out.println(tokens[1].substring(1)+"\n");
		}*/
	}

	/// Wait until enter key is presse
	private static void waitForEnterKey() {
		while(true) {
			String enterKey = "enterKey";
			enterKey = scanner.nextLine();
			if (enterKey.equals("")) {
				return;
			}
		}
	}

	private static void endQuiz() {
		System.out.println("\n-----------------\nQuiz is complete.\n-----------------");
	}
}