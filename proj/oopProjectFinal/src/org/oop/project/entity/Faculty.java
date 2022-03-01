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
public class Faculty {
        private int id;
	private String facultyId;

	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "AccId")
	private Account account;

	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JoinColumn(name = "depId")
	private Department department;

        public Faculty(){}
        public Faculty(int id, String facultyId) {
            this.id = id;
            this.facultyId = facultyId;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}
}
