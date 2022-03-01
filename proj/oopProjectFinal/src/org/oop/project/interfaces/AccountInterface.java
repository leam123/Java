/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.oop.project.interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import org.oop.project.entity.Account;

/**
 *
 * @author Garcia
 */
public interface AccountInterface{
    
    //to display data on jtable
    public ArrayList<?> allList() throws SQLException;
    public void showList() throws SQLException;
    
    //display data on jtable to the textfields
    public void displayTf() throws SQLException; 
    
    //to manage the data
    public boolean search(String u) throws SQLException;
    public void add(String f,String l,String m,String u,String p,String t) throws SQLException;
    public void update(String i, String f,String m,String l,String u,String p,String t) throws SQLException;
    public void delete(String str) throws SQLException;
}
