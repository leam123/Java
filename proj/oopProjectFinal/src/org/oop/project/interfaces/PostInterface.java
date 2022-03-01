/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oop.project.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import org.oop.project.entity.Post;

/**
 *
 * @author Garcia
 */
public interface PostInterface{
    
    public boolean search(String u) throws SQLException;
    
    //for the homepage to display all post in the jtable without clicking any department yet
    public ArrayList<?> postList() throws SQLException;
    public void showList() throws SQLException;
    
    //to display posts in the jtable belonging to a certain department
    public ArrayList<?> deptList(String dep) throws SQLException;
    public void showDeptList(String dep) throws SQLException;
    
    //to sort the data
    public ArrayList<?> sortList(String query) throws SQLException;
    public void sortDeptList(String query) throws SQLException;
    public void sort(String str) throws SQLException;
    public void postByDepartment(String dep) throws SQLException;
    public void postByPopular() throws SQLException;
    public void postByOldest() throws SQLException;
    public void postByNewest() throws SQLException;
}
