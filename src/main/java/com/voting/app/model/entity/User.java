 package com.voting.app.model.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_VOTES")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	@Column(name = "USER_NAME",nullable = false,length = 50)
	private String userName;
	@Column(name = "CANDITATES",nullable = false,length = 100)
	private String candidates;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCandidates() {
		return candidates;
	}
	public void setCandidates(String candidates) {
		this.candidates = candidates;
	}
	public User(long id, String userName, String candidates) {
		super();
		this.id = id;
		this.userName = userName;
		this.candidates = candidates;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", candidates=" + candidates + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(candidates, id, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(candidates, other.candidates) && id == other.id
				&& Objects.equals(userName, other.userName);
	}
}
