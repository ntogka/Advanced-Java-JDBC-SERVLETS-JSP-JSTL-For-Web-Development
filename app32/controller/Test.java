package com.marina.app32.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.marina.app32.dto.Student;
import com.marina.app32.factory.StudentServiceFactory;
import com.marina.app32.service.StudentService;

public class Test {

	public static void main(String[] args) {
		BufferedReader br = null;
		System.out.println("-----------------------------");
		System.out.println("Student Management System");
		System.out.println("-----------------------------");
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			String sid = "";
			String sname = "";
			String saddr = "";
			String status = "";
			Student student = null;
			StudentService studentService = StudentServiceFactory.getStudentService();
			
			while(true) {
				System.out.println();
				System.out.println("1. ADD Student");
				System.out.println("2. SEARCH Student");
				System.out.println("3. UPDATE Student");
				System.out.println("4. DELETE Student");
				System.out.println("5. EXIT");
				System.out.print("Your Option  : ");
				int option = Integer.parseInt(br.readLine());
				
				switch (option) {
				case 1:
					System.out.print("Student Id      : ");
					sid = br.readLine();
					System.out.print("Student Name    : ");
					sname = br.readLine();
					System.out.print("Student Address : ");
					saddr = br.readLine();
					
					student = new Student();
					student.setSid(sid);
					student.setSname(sname);
					student.setSaddr(saddr);
					
					status = studentService.addStudent(student);
					if(status.equalsIgnoreCase("success")) {
						System.out.println("Status : Student Added Successfully");
					}
					if (status.equalsIgnoreCase("existed")) {
						System.out.println("Status : Student Existed Successfully");
					}
					if (status.equalsIgnoreCase("failure")) {
						System.out.println("Status : Student Insertion Successfully");
					}
					
					break;
				case 2:
					System.out.print("Student Id     : ");
					sid = br.readLine();
					student = studentService.searchStudent(sid);
					if (student == null) { 
						System.out.println("Status   : Student not existed");
					}else {
						System.out.println("Status   : Student Existed");
						System.out.println("Student Details");
						System.out.println("-----------------");
						System.out.println("Student Id        : " + student.getSid());
						System.out.println("Student Name      : " + student.getSname());
						System.out.println("Student Address   : " + student.getSaddr());
					}
					
					break;
				case 3:
					System.out.print("Student Id       : ");
					sid = br.readLine();
					student = studentService.searchStudent(sid);
					if(student == null) {
						System.out.println("Status    : Student Not Existed");
					} else {
						System.out.print("Student Name [Old : " + student.getSname() + "] New : ");
						sname = br.readLine();
						System.out.print("Student Address [Old : " + student.getSaddr() + "] New : ");
						saddr = br.readLine();
						
						Student newStudent = new Student();
						newStudent.setSid(sid);
						newStudent.setSname(sname);
						newStudent.setSaddr(saddr);
						
						status = studentService.updateStudent(newStudent);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Status   : Student Updated Successfully");
						}
						if (status.equalsIgnoreCase("failure")) {
							System.out.println("Status   : Student Updation Failure");
						}
					}
					break;
				case 4:
					System.out.print("Student Id    : ");
					sid = br.readLine();
					status = studentService.deleteStudent(sid);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Status   : Student Updated Successfully");
					}
					if (status.equalsIgnoreCase("failure")) {
						System.out.println("Status   : Student Deletion Failure");
					}
					if (status.equalsIgnoreCase("notexisted")) {
						System.out.println("Status   : Student Not Existed");
					}
					break;
				case 5:
					System.out.println("*****Thank You for using Student Management System*******");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option You Selected, Provide the numbers from 1, 2, 3, 4 and 5");
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
