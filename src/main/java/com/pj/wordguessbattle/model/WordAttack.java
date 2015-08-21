package com.pj.wordguessbattle.model;

public class WordAttack {

	private String word;
	private int hits;

	public WordAttack(String word, int hits) {
		this.word = word;
		this.hits = hits;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

}