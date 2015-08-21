package com.pj.wordguessbattle.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pj.wordguessbattle.model.Game;

@Controller
@RequestMapping("/game")
public class GameController {

	@RequestMapping("/new")
	public String game(Model model, HttpSession session) {
		session.setAttribute("game", new Game());
		return "game";
	}
	
	@RequestMapping
	public String game() {
		return "game";
	}
	
	@RequestMapping("/attack")
	public String attack(Model model,
			HttpSession session,
			@RequestParam("word") String attackWord) {
		Game game = (Game)session.getAttribute("game");
		game.attack(attackWord);
		return "redirect:/game";
	}
	
}