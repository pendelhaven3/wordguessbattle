package com.pj.wordguessbattle;

import java.util.ArrayList;
import java.util.List;

import com.pj.wordguessbattle.util.RandomUtil;

public class WordPool {

	private List<String> words = new ArrayList<>();
	
	public String getRandomWord() {
		return RandomUtil.getRandomElement(words);
	}

	public void addWords(List<String> words) {
		this.words.addAll(words);
	}
	
}