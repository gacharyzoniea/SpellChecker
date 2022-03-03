# SpellChecker by Zachary Goniea, Fall 2021
For this program, I are built a word tree (a Trie) for a spell checker.

The program consists of three classes: SpellingNode, SpellingTree, and SpellChecker.

The SpellingNode class represents one node in the SpellingTree. Each SpellingNode contains a letter, an array of its children, 
and a Boolean representing if this letter is the end of a word.

The SpellingTree class implements a tree of SpellingNodes.

The SpellChecker class runs the whole program utilizing the above classes.
