package kr.green.capsuleCloset.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	public String getId(@Param("id")String id);
}
