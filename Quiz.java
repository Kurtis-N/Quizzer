import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

public class Quiz 
{
	private static List<String> list;
	private static int questions;
	private static int correctAnswers;
	private static String filename = "exampleQuiz.txt";

	public static void main(String [] args) 
	{
		initData();
		readFileIntoList();
		startQuiz();
		//printResults();
	}

	private static void initData() 
	{
		list = new ArrayList<String>();
		questions = 0;
		correctAnswers = 0;
		File f = new File(filename);
		if(!f.exists() || f.isDirectory()) 
		{
			System.out.println("Could not find file in path, or file is a directory.");
			System.out.println("Program quitting.");
			System.exit(0);
		}
	}

	private static void readFileIntoList()
	{
		FileReader fr = new FileReader(filename); 
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null) 
		{
			list.add(line);
			questions += 1;
		}
		System.out.println(filename + " loaded");
	}

	private static void startQuiz() {

	}
}