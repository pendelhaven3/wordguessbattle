package com.pj.wordguessbattle.model;

import java.util.ArrayList;
import java.util.List;

import com.pj.wordguessbattle.util.RandomUtil;
import com.pj.wordguessbattle.util.WordUtil;

public class WordPool {

	private List<String> words = new ArrayList<>();
	
	public String getRandomWord() {
		String word = null;
		do {
			word = RandomUtil.getRandomElement(words);
		} while (hasDuplicateLetters(word));
		
		return word;
	}

	private boolean hasDuplicateLetters(String word) {
		return WordUtil.getUniqueLetters(word).size() != word.length();
	}

	public void addWords(List<String> words) {
		this.words.addAll(words);
	}

	public boolean contains(String word) {
		return words.contains(word);
	}
	
}