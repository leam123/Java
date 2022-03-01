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
public class Student {
        private int id;
	private String studentId;
	private int votes;
	private int postCount;
	private int answerCount;

	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "AccId")
	private Account account;

        public Student(){}
        public Student(int id, String studentId, int votes, int postCount, int answerCount) {
            this.id = id;
            this.studentId = studentId;
            this.votes = votes;
            this.postCount = postCount;
            this.answerCount = answerCount;
        }

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getPostCount() {
		return postCount;
	}
	public void setPostCount(int postCount) {
		this.postCount = postCount;
	}
	public int getAnswerCount() {
		return answerCount;
	}
	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
}
