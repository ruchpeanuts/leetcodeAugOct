package com.leetcode.august;

public class Trie {

	public class Node {
		private Node[] children = new Node[26];
		private boolean isWord;

		private Node getChild(char letter) {
			return children[letter - 'a'];
		}

		private Node setChild(char letter, Node n) {
			children[letter - 'a'] = n;
			return n;
		}
	}

	private Node root;

	Trie() {
		root = new Node();
	}

	public void insert(String word) {
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
			Node child = curr.getChild(c);
			if(child == null) return false;
			curr = child;
		}
		return curr != null && curr.isWord;
	}

	public boolean startsWith(String prefix) {
		Node curr = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			Node child = curr.getChild(c);
			if(child == null) return false;
			curr = child;
		}
		return curr != null && curr != root;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		System.out.println(trie.search("ab")); // returns false
		trie.insert("ab");
		System.out.println(trie.search("ab")); // returns false
		System.out.println(trie.startsWith("ab")); // returns true
		System.out.println(trie.startsWith("ab")); // returns true
//		System.out.println(trie.startsWith("hello")); // returns true
//		trie.insert("app");
//		System.out.println(trie.search("app")); // returns true
	}

}
