package kr.green.capsuleCloset.service;

import javax.servlet.http.HttpServletRequest;

import kr.green.capsuleCloset.vo.UserVo;

public interface UserService {

	void signup(UserVo userVo);

	public UserVo signin(UserVo userVo);

	UserVo getUser(HttpServletRequest r);
}
