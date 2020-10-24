package com.leetcode.august;

public class WordDictionary {

	public class Node {
		private Node[] children = new Node[26];
		private boolean isWord;

		private Node getAnyChild() {
			for (int i = 0; i < 26; i++) {
				if (children[i] != null) {
					return children[i];
				}
			}
			return null;
		}

		private Node getChild(char letter) {
			return children[letter - 'a'];
		}

		private Node setChild(char letter, Node n) {
			children[letter - 'a'] = n;
			return n;
		}
	}

	private Node root;

	WordDictionary() {
		root = new Node();
	}

	public void addWord(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node child = curr.getChild(c);
			if (child == null) {
				child = curr.setChild(c, new Node());
			}
			curr = child;
		}
		curr.isWord = true;
	}

	public boolean search(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			Node child;
			if (c == '.') {
				child = curr.getAnyChild();
				for(Node n : curr.children) {
//					n.get
					//TODO
				}
			} else {
				child = curr.getChild(c);
			}
			if (child == null)
				return false;
			curr = child;
		}
		return curr != null && curr.isWord;
	}

	public static void main(String[] args) {
		WordDictionary trie = new WordDictionary();

		trie.addWord("at");
		trie.addWord("and");
		trie.addWord("bat");
		trie.addWord("an");
		trie.addWord("add");
		System.out.println(trie.search(".at"));
	}

}
