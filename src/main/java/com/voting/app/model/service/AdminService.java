package com.voting.app.model.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.voting.app.model.entity.Admin;
import com.voting.app.model.entity.User;

public interface AdminService {

	boolean adminCheck(Admin admin, HttpSession session);

	List<User> findTheVoteResult();

}
