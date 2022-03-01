/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oop.project.entity;

/**
 *
 * @author Garcia
 */
import java.sql.Date;

public class Reply {
        private int id;
	private String title;
	private String body;
	private int repliedBy;
	private Date dateReplied;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "ansId")
	private Answer answer;
	
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "accId")
	private Account account;

        public Reply(){}
        public Reply(String title, String body, Date dateReplied) {
            this.title = title;
            this.body = body;
            this.dateReplied = dateReplied;
        }
        public Reply(int id, String title, String body, int repliedBy, Date dateReplied) {
            this.id = id;
            this.title = title;
            this.body = body;
            this.repliedBy = repliedBy;
            this.dateReplied = dateReplied;
        }
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getRepliedBy() {
		return repliedBy;
	}
	public void setRepliedBy(int repliedBy) {
		this.repliedBy = repliedBy;
	}
	public Date getDateReplied() {
		return dateReplied;
	}
	public void setDateReplied(Date dateReplied) {
		this.dateReplied = dateReplied;
	}
}
