/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdpcsample.dao;

import com.leapfrog.jdpcsample.Entity.Student;
import java.sql.SQLException;
import java.util.List;



/**
 *
 * @author milan
 */
public interface StudentDAO {
    
    int insert(Student s) throws SQLException, ClassNotFoundException ;
    int update(Student s) throws SQLException, ClassNotFoundException ;
    int delete(int id) throws SQLException, ClassNotFoundException ;
    Student getById(int id)throws SQLException, ClassNotFoundException ;
    List<Student> getAll() throws SQLException, ClassNotFoundException ;
    
    
}
