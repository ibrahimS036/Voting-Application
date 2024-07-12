package com.voting.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.voting.app.model.entity.Registration;
import com.voting.app.model.entity.User;
import com.voting.app.model.service.AdminService;
import com.voting.app.model.service.RegistrationService;

@Controller
public class RagistrationController {

	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private AdminService adminService;
	
	
	@GetMapping("/")
	public String view() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login(Model m) {
		return "login";
	}
	@PostMapping("/login1")
	public String loginCheck( @ModelAttribute Registration bean , Model m,HttpSession httpSession) {
		Registration match = this.registrationService.loginMatch(bean,httpSession);
		if(match==null) {
			m.addAttribute("mess","Your User Name And Password desn't match Please Register first");
			return "login";
			}
		else if(match.getUserName().equals("Admin123")&&match.getPassword().equals("Admin***")) {
			m.addAttribute("mess", "Login Seccessfully Check All The Result");
			List<User> all = this.adminService.findTheVoteResult();
			int Count1 = 0;
			int Count2 = 0;
			int Count3 = 0;
			int Count4 = 0;
			for (User user : all) {
				if (user.getCandidates().equals("Candidate 1")) {
					Count1++;
				} else if (user.getCandidates().equals("Candidate 2")) {
					Count2++;
				} else if (user.getCandidates().equals("Candidate 3")) {
					Count3++;
				} else if (user.getCandidates().equals("Candidate 4")) {
					Count4++;
				}
			  }
			m.addAttribute("Candidate1",Count1);
			m.addAttribute("Candidate2",Count2);
			m.addAttribute("Candidate3",Count3);
			m.addAttribute("Candidate4",Count4);
			return "seeAllVotes";
		}
		else {
			httpSession.setAttribute("ses", match);
			return "vote";
		}
	}
	@GetMapping("/regsiter")
	public String register() {
		return "regsiter";
	}
	@PostMapping("/register")
	public String Registration(@ModelAttribute Registration bean , Model m) {
		
		boolean bn = this.registrationService.save(bean);
		if(bn) {
			m.addAttribute("success","Register successfully now login");
			return "login"; 
		}
		else {
			m.addAttribute("already","You are already register now login");
			return "login";
		}
	}
}