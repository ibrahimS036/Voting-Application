package com.voting.app.model.service;

import javax.servlet.http.HttpSession;

import com.voting.app.model.entity.Registration;

public interface RegistrationService {

	boolean save(Registration bean);

	Registration loginMatch(Registration bean,HttpSession httpSession);
}