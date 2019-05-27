package com.zzu.yhl.g_annotation.c_other;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service("userServiceId")
// @Scope("prototype")
public class UserServiceImpl implements UserService {

	@Override
	public void addUser() {
		// TODO Auto-generated method stub
		System.out.println("d_scope General is writing!");
	}

	@PostConstruct
	public void Init() {
		System.out.println("General init!");
	}

	@PreDestroy
	public void Destroy() {
		System.out.println("General destory!");
	}

}
