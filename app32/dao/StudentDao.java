package com.marina.app32.dao;

import com.marina.app32.dto.Student;

public interface StudentDao {
	public String add(Student student);
	public String search(Student sid);
	public String update(Student student);
	public String delete(Student sid);
}
