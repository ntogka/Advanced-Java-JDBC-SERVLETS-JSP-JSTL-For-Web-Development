package com.marina.app32.factory;

import com.marina.app32.service.StudentService;
import com.marina.app32.service.StudentServiceImpl;

public class StudentServiceFactory {
	private static StudentService studentService;
	static {
		studentService = new StudentServiceImpl();
	}
	public static StudentService getStudentService() {
		return studentService;
	}

}
