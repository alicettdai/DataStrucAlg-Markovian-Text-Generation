import java.io.File;

public class WordMarkovDriver {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		//String filename = "data/trump-un-sept19-17.txt";
		String filename= "data/hawthorne.txt";
		if (args.length > 0) {
			filename = args[1];
		}
		File f = new File(filename);
		String text = TextSource.textFromFile(f);
		
		for(int k=1; k <= 5; k++) {
			MarkovInterface<WordGram> markov = new EfficientWordMarkov(k); //tester for EfficientWordMarkov(k);
			markov.setTraining(text);
			String random = markov.getRandomText(50);
			System.out.printf("%d markov model with %d words\n", k,random.split("\\s").length);
			printNicely(random,60);
		}
		long endTime=System.currentTimeMillis()-startTime;
		System.out.println("time elapsed is " + endTime);
	}

	private static void printNicely(String random, int screenWidth) {
		String[] words = random.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > screenWidth) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
}
