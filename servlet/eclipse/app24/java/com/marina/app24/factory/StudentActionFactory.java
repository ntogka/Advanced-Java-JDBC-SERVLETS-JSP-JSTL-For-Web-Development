package com.marina.app24.factory;

import com.marina.app24.action.StudentAction;

public class StudentActionFactory {
	
	private static StudentAction studentAction = null;
	static {
		studentAction = new StudentAction();
	}
	public static StudentAction getStudentAction() {
		return studentAction;
	}
}
