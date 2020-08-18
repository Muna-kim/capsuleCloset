package kr.green.capsuleCloset.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.capsuleCloset.vo.ClosetVo;

public interface ClosetDao {

	void setCloset(@Param("closetVo")ClosetVo closetVo);

	ClosetVo getCloset(@Param("id")String id);
	


}
