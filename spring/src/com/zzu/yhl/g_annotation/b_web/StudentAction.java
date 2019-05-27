package com.zzu.yhl.g_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller("studentAction")
public class StudentAction {
	@Autowired
	private StudentService studentService;

	/**
	 * @param studentService the studentService to set
	 */

	/*
	 * @Autowired public void setStudentService(StudentService studentService) {
	 * this.studentService = studentService; }
	 */

	public void execute() {
		studentService.addStudent();
	}

}
