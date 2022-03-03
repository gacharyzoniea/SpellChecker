public class SpellingTree {
	
SpellingNode root;

public SpellingTree() {
	root = new SpellingNode(' ');
}

public void addWord(String word) { 
	SpellingNode t = root;
	 for (int i = 0; i < word.length(); i++) {
		if (Character.isLetter(i)) {
		t.addChild(word.charAt(i));
		t = t.getChildAt(word.charAt(i));
		}
	}
	t.setCorrect();
}

public boolean checkWord(String word) {
	SpellingNode current = root;
	for (char c : word.toCharArray()) {
		if (current.getChildAt(c) == null) {
			return false;
		}
		else {
			current = current.getChildAt(c);
		}
	}
	if (current.getCorrect() == true) {
		return true;
	}
	return false;
}

public void printWords(String subWord, SpellingNode c) {
	if (c.getCorrect()) {
		System.out.println(subWord);
	}
	for (int i = 0; i < c.children.length; i++) {
		if (c.children[i] != null) {
			//subWord += c.children[i].value;
			printWords(subWord + c.children[i].value, c.getChildAt(c.children[i].value));
		}
		
	}
}
public static void main(String [] ards) {
	SpellingTree s = new SpellingTree();
	s.addWord("cat");
	SpellingNode tmp = s.root;
//	for (int i = 0; i < tmp.children.length; i++) {
//		System.out.print("_" + );
//	}
	System.out.println(tmp.getChildAt('c'));
	System.out.println(tmp.getChildAt('a'));
	s.addWord("c");
//    tmp = tmp.getChildAt('c');
//    System.out.println(tmp.correctWord);
//    tmp = tmp.getChildAt('a');
//    System.out.println(tmp.correctWord);
//    tmp = tmp.getChildAt('t');
//    System.out.println(tmp.correctWord);
	System.out.println(s.checkWord("c"));
	System.out.println(s.checkWord("ca"));
	System.out.println(s.checkWord("cat"));
	
	s.printWords("", s.root);
    
	
}

}


