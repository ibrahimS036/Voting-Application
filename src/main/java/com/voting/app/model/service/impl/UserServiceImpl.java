package com.voting.app.model.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.app.model.entity.Registration;
import com.voting.app.model.entity.User;
import com.voting.app.model.repositry.UserRepositry;
import com.voting.app.model.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepositry repositry;
	
	@Override
	public boolean votesSave(User user, HttpSession session) {
		 Registration ab = (Registration) session.getAttribute("ses");
		User user2 = repositry.findByUserName(ab.getUserName());
		if(user2==null) {
			user.setUserName(ab.getUserName());
			this.repositry.save(user);
			return true;
		}
		else {			
			return false;
		}
	}
}