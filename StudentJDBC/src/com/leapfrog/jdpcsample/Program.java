/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jdpcsample;

import com.leapfrog.jdpcsample.Entity.Student;
import com.leapfrog.jdpcsample.dao.StudentDAO;
import com.leapfrog.jdpcsample.daoimpl.StudentDAOImpl;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author milan
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StudentDAO studentdao = new StudentDAOImpl();
        Student student = new Student();

        System.out.println("MENU : Student Records");
        System.out.println("***********************");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Search Record By Id");
        System.out.println("5. Display All records");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choice(1-6): ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter Name of Student");
                student.setStudentName(input.next());
                System.out.println("Enter Major Subject");
                student.setMajorSubject(input.next());
                System.out.println("Enter Minor Subject");
                student.setMinorSubject(input.next());
                System.out.println("Enter Name of Teacher");
                student.setTeacherName(input.next());
                System.out.println("Enter Fee");
                student.setFee(input.nextInt());
                System.out.println("Enter Status of Student[true/false]");
                student.setStatus(input.hasNext());
                try {
                    int result = studentdao.insert(student);
                    if (result > 0) {
                        System.out.println("Inserted Record");
                    } else {
                        System.out.println("Not successful");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 2:
                System.out.println("Enter id of student to update");
                student.setId(input.nextInt());
                System.out.println("Enter Name of Student");
                student.setStudentName(input.next());
                System.out.println("Enter Major Subject");
                student.setMajorSubject(input.next());
                System.out.println("Enter Minor Subject");
                student.setMinorSubject(input.next());
                System.out.println("Enter Name of Teacher");
                student.setTeacherName(input.next());
                System.out.println("Enter Fee");
                student.setFee(input.nextInt());
                System.out.println("Enter Status of Student[true/false]");
                student.setStatus(input.hasNext());
                try {
                    int result = studentdao.update(student);
                    if (result > 0) {
                        System.out.println("Updated Record");
                    } else {
                        System.out.println("Not successful");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 3:
                try {
                    System.out.println("Enter id of student to delete: ");
                    int result = studentdao.delete(input.nextInt());
                    if (result > 0) {
                        System.out.println("Deleted Record");
                    } else {
                        System.out.println("Not successful");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 4:
                try {
                    System.out.println("Enter id of student to Show: ");
                    student = studentdao.getById(input.nextInt());

                    System.out.println(student.toString());

                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 5:
                try {
                    studentdao.getAll().forEach(s -> {
                        System.out.println(s);
                    });

                } catch (SQLException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 6:
                System.exit(0);
                ;
                break;

        }
    }

}
