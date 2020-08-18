package kr.green.capsuleCloset.service;

import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.UserVo;

public interface ClosetService {

	void setCloset(ClosetVo closetVo);

	ClosetVo getCloset(String id);

//	void setCloset(ClosetVo closetVo, UserVo userVo);

}
