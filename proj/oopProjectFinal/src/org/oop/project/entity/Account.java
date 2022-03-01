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
public class Account {
	private int id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String middle_name;
	private String type;

	//@OneToMany(mappedBy = "account")
	private List<Post> posts;

	//@OneToMany(mappedBy = "account")
	private List<Answer> answers;

	//@OneToMany(mappedBy = "account")
	private List<Reply> replies;

	//@OneToOne(mappedBy = "account")
	private Faculty faculty;

	//@OneToOne(mappedBy = "account")
	private Student student;

        public Account() { }
        public Account(int id, String username, String password, String first_name, String last_name, String middle_name, String type) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.first_name = first_name;
            this.last_name = last_name;
            this.middle_name = middle_name;
            this.type = type;
        }
        
	//getters and setters
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public List<Reply> getReplies() {
		return replies;
	}
	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
