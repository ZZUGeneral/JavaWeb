package com.zzu.yhl.c_inject.c_lifecycle;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("c_lifecycle General is writing!");
	}

	public void Init() {
		System.out.println("General init!");
	}

	public void Destroy() {
		System.out.println("General destory!");
	}
}
