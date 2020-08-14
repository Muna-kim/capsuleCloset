package kr.green.capsuleCloset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.capsuleCloset.dao.UserDao;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public String getId(String id) {
		return userDao.getId(id);
	}

}
