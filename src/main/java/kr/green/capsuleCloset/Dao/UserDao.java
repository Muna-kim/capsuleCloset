package kr.green.capsuleCloset.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.capsuleCloset.vo.UserVo;

public interface UserDao {

	public void signup(@Param("userVo")UserVo userVo);


	public UserVo getUser(@Param("id")String id);
}
