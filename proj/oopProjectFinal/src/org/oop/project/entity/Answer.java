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
import java.util.List;
import java.sql.Date;

public class Answer {
        private int id;
	private String body;
	private int votes;
	private Date dateAccepted;
	private Date dateAnswered;

	//@OneToMany(mappedBy = "answer")
	private List<Reply> replies;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "postId")
	private Post post;

	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "accId")
	private Account account;

        public Answer(){}
        public Answer(String body, Date dateAnswered, int votes) {
            this.body = body;
            this.votes = votes;
            this.dateAnswered = dateAnswered;
        }
        public Answer(int id,String body, int votes, Date dateAccepted, Date dateAnswered) {
            this.id = id;
            this.body = body;
            this.votes = votes;
            this.dateAccepted = dateAccepted;
            this.dateAnswered = dateAnswered;
        }
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Date getDateAccepted() {
		return dateAccepted;
	}
	public void setDateAccepted(Date dateAccepted) {
		this.dateAccepted = dateAccepted;
	}
	public Date getDateAnswered() {
		return dateAnswered;
	}
	public void setDateAnswered(Date dateAnswered) {
		this.dateAnswered = dateAnswered;
	}
}
