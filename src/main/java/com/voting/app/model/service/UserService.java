package com.voting.app.model.service;

import javax.servlet.http.HttpSession;

import com.voting.app.model.entity.User;

public interface UserService {

	boolean votesSave(User user, HttpSession session);

}
