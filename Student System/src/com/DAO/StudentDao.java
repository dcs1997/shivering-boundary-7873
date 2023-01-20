package com.DAO;

import com.Exception.StudentException;
import com.Model.Student;

public interface StudentDao  {

	public String registerStudent(Student student) throws StudentException;
}
