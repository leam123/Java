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

public class Department {
        private int id;
	private String name;

	//@OneToOne(mappedBy = "department")
	private Faculty faculty;

	//@OneToMany(mappedBy = "department")
	private List<Post> posts;

        public Department(){}
        public Department(int id,String name) {
            this.id = id;
            this.name = name;
        }

	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
