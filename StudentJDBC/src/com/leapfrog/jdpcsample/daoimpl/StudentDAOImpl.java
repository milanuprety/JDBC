/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdpcsample.daoimpl;

import com.leapfrog.jdpcsample.Entity.Student;
import com.leapfrog.jdpcsample.dao.StudentDAO;
import com.leapfrog.jdpcsample.dbutil.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milan
 */
public class StudentDAOImpl implements StudentDAO {

    private DbConnection dbconn;

    public StudentDAOImpl() {
        dbconn = new DbConnection();
    }

    @Override
    public int insert(Student s) throws SQLException, ClassNotFoundException {
        dbconn.open();
        String sql = "INSERT INTO student_table(name,major_subject,minor_subject,teacher,fee, status) VALUES(?,?,?,?,?,?) ";
        PreparedStatement stmt = dbconn.initStatement(sql);
        stmt.setString(1, s.getStudentName());
        stmt.setString(2, s.getMajorSubject());
        stmt.setString(3, s.getMinorSubject());
        stmt.setString(4, s.getTeacherName());
        stmt.setInt(5, s.getFee());
        stmt.setBoolean(6, s.isStatus());
        int result = dbconn.executeUpdate();
        dbconn.close();
        return result;
    }

    @Override
    public int update(Student s) throws SQLException, ClassNotFoundException {
        dbconn.open();
        String sql = "UPDATE student_table set name=?,major_subject=?,minor_subject=?,teacher=?,fee=?, status=? WHERE id=? ";
        PreparedStatement stmt = dbconn.initStatement(sql);
        stmt.setString(1, s.getStudentName());
        stmt.setString(2, s.getMajorSubject());
        stmt.setString(3, s.getMinorSubject());
        stmt.setString(4, s.getTeacherName());
        stmt.setInt(5, s.getFee());
        stmt.setBoolean(6, s.isStatus());
        stmt.setInt(7, s.getId());
        int result = dbconn.executeUpdate();
        dbconn.close();
        return result;
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        dbconn.open();
        String sql = "DELETE from student_table WHERE id=? ";
        PreparedStatement stmt = dbconn.initStatement(sql);
        stmt.setInt(1, id);
        int result = dbconn.executeUpdate();
        dbconn.close();
        return result;
    }

    @Override
    public Student getById(int id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * from student_table where id = ?";
        Student student = new Student();
        dbconn.open();
        PreparedStatement stmt = dbconn.initStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = dbconn.executeQuery();
        while (rs.next()) {
            student.setId(rs.getInt("id"));
            student.setStudentName(rs.getString("name"));
            student.setMajorSubject(rs.getString("major_subject"));
            student.setMinorSubject(rs.getString("minor_subject"));
            student.setTeacherName(rs.getString("teacher"));
            student.setStatus(rs.getBoolean("status"));

        }
        dbconn.close();
        return student;

    }

    @Override
    public List<Student> getAll() throws SQLException, ClassNotFoundException {
   List<Student> studentList = new ArrayList<>();
    String sql = "SELECT * from student_table";
         dbconn.open();
        PreparedStatement stmt = dbconn.initStatement(sql);
        
        ResultSet rs = dbconn.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setStudentName(rs.getString("name"));
            student.setMajorSubject(rs.getString("major_subject"));
            student.setMinorSubject(rs.getString("minor_subject"));
            student.setTeacherName(rs.getString("teacher"));
            student.setStatus(rs.getBoolean("status"));
            studentList.add(student);

        }
        dbconn.close();
   return studentList;
    }

}
