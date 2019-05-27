package com.zzu.yhl.g_annotation.a_ioc;

import org.springframework.stereotype.Component;

@Component("userService")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("General is writing!");
	}

}
