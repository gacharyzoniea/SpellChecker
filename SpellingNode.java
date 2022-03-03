public class SpellingNode {

	public char value;
	public SpellingNode[] children;
	public boolean correctWord;

	public SpellingNode(char value) {
		this.value = value;
		children = new SpellingNode[26];
		correctWord = false;
	}

	public void setCorrect() {
		correctWord = true;
	}

	public boolean getCorrect() {
		return correctWord;
	}

	public boolean addChild(char val) {
		int loc = val - 97; // Subtracts from ACSII value to respective number in array 
							// Ex: c = 99 so b-97=2 (the location in array)
		System.out.println(val);
		if (children[loc] != null) {
			return false;
		} else {
			children[loc] = new SpellingNode(val);
			return true;
		}
	}

	public SpellingNode getChildAt(char val) {
		return children[val - 97];
	}
	
}
