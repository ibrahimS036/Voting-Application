package com.voting.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.voting.app.model.entity.Admin;
import com.voting.app.model.entity.User;
import com.voting.app.model.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin")
	public String addmin() {
		return "admin";
	}
	@GetMapping("/adminLogout")
	public String adminLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}

	@PostMapping("/admincheck")
	public String addminCheck(@ModelAttribute Admin admin, Model m, HttpSession session) {
		boolean b = this.adminService.adminCheck(admin, session);
		if (b) {
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
		} else {
			m.addAttribute("add", "User Name our Password are Wrong");
			return "admin";
		}
	}
}