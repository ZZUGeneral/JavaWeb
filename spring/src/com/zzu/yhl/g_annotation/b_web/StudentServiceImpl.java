package com.zzu.yhl.g_annotation.b_web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	@Qualifier("studentDaoId")
	private StudentDao studentDao;

	/**
	 * @param studentDao the studentDao to set
	 */
	/*
	 * @Autowired
	 * 
	 * @Qualifier("studentDaoId") public void setStudentDao(StudentDao studentDao) {
	 * this.studentDao = studentDao; }
	 */

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		studentDao.save();
	}

}
