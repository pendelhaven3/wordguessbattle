package com.pj.wordguessbattle.controller;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.pj.wordguessbattle.model.Game;

@Controller
@RequestMapping("/game")
public class GameController {

	private Gson gson = new Gson();
	
	@RequestMapping("/new")
	public String game(Model model, HttpSession session) {
		session.setAttribute("game", new Game());
		return "redirect:/game";
	}
	
	@RequestMapping
	public String game(HttpSession session) {
		Game game = (Game)session.getAttribute("game");
		if (game != null) {
			if (game.isVictoryConditionMet()) {
				return "victory";
			} else {
				return "game";
			}
		} else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping("/victory")
	public String victory(Model model) {
		return "victory";
	}
	
	@RequestMapping(value = "/attack", produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody String attack(Model model, HttpSession session, @RequestParam("word") String attackWord) {
		Game game = (Game)session.getAttribute("game");
		
		if (!game.isValidAttackWord(attackWord)) {
			return invalidAttackWordResponse();
		}
		
		return gson.toJson(game.attack(attackWord));
	}

	private String invalidAttackWordResponse() {
		return gson.toJson(Collections.singletonMap("error", "invalidAttackWord"));		
	}
	
}