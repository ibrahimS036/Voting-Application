package com.voting.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.voting.app.model.entity.User;
import com.voting.app.model.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping("/vote")
	public String votesSave(@ModelAttribute User user,HttpSession session,Model model) {
		if(user.getCandidates()==null) {
			model.addAttribute("pending","Your Vote Is Pending");
			return "index";
		}
		boolean b = this.service.votesSave(user,session);
		if (b) {
			model.addAttribute("mess","Voted successfully");
		} else {
			model.addAttribute("wrong","You already Voted");
		}
		return "success";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "index";
	}
}