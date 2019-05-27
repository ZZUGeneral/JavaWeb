package com.zzu.yhl.g_annotation.b_web;

import org.springframework.stereotype.Repository;

@Repository("studentDaoId")
public class StudentDaoImpl implements StudentDao {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("dao");
	}

}
