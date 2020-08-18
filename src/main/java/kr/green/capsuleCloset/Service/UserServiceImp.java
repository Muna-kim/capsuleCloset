package kr.green.capsuleCloset.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.capsuleCloset.dao.UserDao;
import kr.green.capsuleCloset.vo.UserVo;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void signup(UserVo userVo) {
		String encPw=passwordEncoder.encode(userVo.getPw());
        userVo.setPw(encPw);
		userDao.signup(userVo);
	}

	@Override
	public UserVo signin(UserVo userVo) {
		UserVo user=userDao.getUser(userVo.getId());
		if(user==null) {
			return null;
		}
		if(passwordEncoder.matches(userVo.getPw(), user.getPw())) {
			return user;
		}
		return null;
	}
	@Override
	public UserVo getUser(HttpServletRequest r) {
		return (UserVo)r.getSession().getAttribute("user");
	}

}