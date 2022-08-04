package com.example.ProductManagment.Pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Users {
	
	@Id
	private String username;
	private String question;
	private String answer;
	private String newpassword;
	private String confirmpass;
	
	
	
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpass() {
		return confirmpass;
	}
	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}
	@Override
	public String toString() {
		return "Users [username=" + username + ", question=" + question + ", answer=" + answer + ", newpassword="
				+ newpassword + ", confirmpass=" + confirmpass + "]";
	}
	public Users(String username, String question, String answer, String newpassword, String confirmpass) {
		super();
		this.username = username;
		this.question = question;
		this.answer = answer;
		this.newpassword = newpassword;
		this.confirmpass = confirmpass;
	}

	


}
