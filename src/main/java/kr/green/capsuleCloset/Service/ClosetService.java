package kr.green.capsuleCloset.service;

import java.util.ArrayList;

import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.FileVo;

public interface ClosetService {

	void setCloset(ClosetVo closetVo);

	ClosetVo getCloset(String id);

	void registerFile(FileVo fileVo, String id);

	ArrayList<FileVo> getTop(String id, String clothes);

	ArrayList<FileVo> getBottom(String id, String clothes);

	ArrayList<FileVo> getOuter(String id, String clothes);

	ArrayList<FileVo> getShoes(String id, String clothes);

	ArrayList<ClosetVo> getClosetVo();

	String getRegisterdate(String id);

	ClosetVo getCloset2(Integer closetNum);



}
