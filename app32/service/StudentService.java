package com.marina.app32.service;

import com.marina.app32.dto.Student;

public interface StudentService {
	public String addStudent(Student student);
	public String searchStudent(String sid);
	public String updateStudent(Student student);
	public String deleteStudent(String sid);
}
