package com.pj.wordguessbattle.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.pj.wordguessbattle.util.WordUtil;

public class Game {

	private WordPool wordPool = new WordPool();
	private String targetWord;
	private List<WordAttack> attacks = new ArrayList<>();
	
	public Game() {
		assignTargetWord();
		System.out.println(targetWord);
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
	
	public WordAttack attack(String attackWord) {
		WordAttack attack = new WordAttack(attackWord, getHits(attackWord));
		attacks.add(attack);
		return attack;
	}

	private int getHits(String attackWord) {
		int hits = 0;
		for (char c : WordUtil.getUniqueLetters(attackWord)) {
			if (doesTargetWordContainLetter(c)) {
				hits++;
			}
		}
		return hits;
	}

	private boolean doesTargetWordContainLetter(char c) {
		return targetWord.indexOf(c) != -1;
	}

	public String getTargetWord() {
		return targetWord;
	}
	
	public List<WordAttack> getAttacks() {
		return attacks;
	}

	public boolean isVictoryConditionMet() {
		if (!attacks.isEmpty()) {
			return attacks.get(attacks.size() - 1).getWord().equals(targetWord);
		} else {
			return false;
		}
	}

	public boolean isValidAttackWord(String attackWord) {
		return wordPool.contains(attackWord);
	}
	
}