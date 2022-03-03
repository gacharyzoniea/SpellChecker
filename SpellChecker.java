import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SpellChecker {
	
	public static SpellingTree myTree;
	
	public static int checkWords(String filename) throws FileNotFoundException {
		int numWrong = 0;
		filename = "spellCheck.txt";
		String dirty = "";
		String clean = "";
		File f = new File(filename);
		Scanner fScan = new Scanner(f);
		while (fScan.hasNext()) {
			clean = "";
			dirty = fScan.next().toLowerCase();
			for (char c : dirty.toCharArray()) {
				if (Character.isLetter(c)) {
					clean += c;
				}
			}
			System.out.println(clean);
			if (!myTree.checkWord(clean)) {
				numWrong++;
				System.out.println(dirty);
				//out += traceScan.next();
			}
			
			
			
		}
		return numWrong;
	}
	
	public static void readWords(String filename) throws FileNotFoundException {
		File f = new File(filename);
		Scanner lower = new Scanner(f);
		PrintWriter pw = new PrintWriter("in.txt");
//		lower.useDelimiter("\n");
		while (lower.hasNext()) {
			pw.write(lower.next().toLowerCase() + " ");
		}
		pw.close();
		Scanner sc = new Scanner(new File("in.txt"));
		while (sc.hasNext()) {
		myTree.addWord(sc.next());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		myTree = new SpellingTree();
		readWords("input.txt");
		myTree.printWords("", myTree.root);
		System.out.println("*******");
		System.out.println(checkWords("spellCheck.txt"));
	}

}
