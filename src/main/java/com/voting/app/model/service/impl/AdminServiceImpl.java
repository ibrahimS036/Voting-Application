package com.voting.app.model.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.app.model.entity.Admin;
import com.voting.app.model.entity.User;
import com.voting.app.model.repositry.AdminRepositry;
import com.voting.app.model.repositry.UserRepositry;
import com.voting.app.model.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepositry adminRepositry;
	@Autowired
	private UserRepositry repositry;

	@Override
	public boolean adminCheck(Admin admin, HttpSession session) {

		Admin admin2 = this.adminRepositry.findByUserNameAndPassword(admin.getUserName(), admin.getPassword());
		if(admin2!=null) {
			session.setAttribute("admin", admin2);
			return true;
		}
		else {			
			return false;
		}
	}

	@Override
	public List<User> findTheVoteResult() {
		return this.repositry.findAll();
	}
}