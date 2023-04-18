package com.mvc.jpa.user;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImple implements UserService {

	private final UserRepository repo;
	
	@Override
	public Long register(UserDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
