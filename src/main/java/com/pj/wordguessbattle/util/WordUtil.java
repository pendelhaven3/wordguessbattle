package com.pj.wordguessbattle.util;

import java.util.HashSet;
import java.util.Set;

public class WordUtil {

	public static Set<Character> getUniqueLetters(String attackWord) {
		Set<Character> letters = new HashSet<>();
		for (char c : attackWord.toCharArray()) {
			letters.add(c);
		}
		return letters;
	}
	
}