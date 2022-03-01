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
import java.util.List;

public class Post {
        private int id;
	private String title;
	private String body;
	private int votes;
	private Date dateCreated;
	private Date dateUploaded;
	private String tag;
        private String postName;
        
	private List<Answer> answers;
	private Account account;
	private Department department;

        public Post(){}
        public Post(String title, Date dateUploaded, int votes, String tag, String postName) {
            this.title = title;
            this.votes = votes;
            this.dateUploaded = dateUploaded;
            this.tag = tag;
            this.postName = postName;
        }
        public Post(int id,String title, String body, Date dateCreated, Date dateUploaded, int votes, String tag) {
            this.id = id;
            this.title = title;
            this.body = body;
            this.votes = votes;
            this.dateCreated = dateCreated;
            this.dateUploaded = dateUploaded;
            this.tag = tag;
        }

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
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
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUploaded() {
		return dateUploaded;
	}
	public void setDateUploaded(Date dateUploaded) {
		this.dateUploaded = dateUploaded;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
        public String getPostName() {
            return postName;
        }
        public void setPostName(String postName) {
            this.postName = postName;
        }
}
