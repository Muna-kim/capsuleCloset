package kr.green.capsuleCloset.service;

import kr.green.capsuleCloset.vo.UserVo;

public interface UserService {

	void signup(UserVo userVo);

	public UserVo signin(UserVo userVo);
}
