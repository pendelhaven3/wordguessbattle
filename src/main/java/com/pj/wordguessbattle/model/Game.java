package com.pj.wordguessbattle.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class Game {

	private WordPool wordPool = new WordPool();
	private String targetWord;
	private List<WordAttack> attacks = new ArrayList<>();
	
	public Game() {
		assignTargetWord();
	}

	private void assignTargetWord() {
		loadWordPool();
		targetWord = wordPool.getRandomWord();
	}

	private void loadWordPool() {
		try {
			wordPool.addWords(IOUtils.readLines(getClass().getClassLoader().getResourceAsStream("words-4-letters.txt")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void attack(String attackWord) {
		attacks.add(new WordAttack(attackWord, getHits(attackWord)));
	}

	private int getHits(String attackWord) {
		int hits = 0;
		for (char c : getUniqueLetters(attackWord)) {
			if (doesTargetWordContainLetter(c)) {
				hits++;
			}
		}
		return hits;
	}

	private boolean doesTargetWordContainLetter(char c) {
		return targetWord.indexOf(c) != -1;
	}

	private Set<Character> getUniqueLetters(String attackWord) {
		Set<Character> letters = new HashSet<>();
		for (char c : attackWord.toCharArray()) {
			letters.add(c);
		}
		return letters;
	}
	
	public String getTargetWord() {
		return targetWord;
	}
	
	public List<WordAttack> getAttacks() {
		return attacks;
	}
	
}