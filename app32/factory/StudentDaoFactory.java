package com.marina.app32.factory;

import com.marina.app32.dao.StudentDao;
import com.marina.app32.dao.StudentDaoImp;

public class StudentDaoFactory {
	private static StudentDao studentDao;
	static {
		studentDao = new StudentDaoImp();
	}
	public static StudentDao getStudentDao() {
		return studentDao;
	}

}
