package kr.green.capsuleCloset.service;

import java.util.ArrayList;

import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.FileVo;
import kr.green.capsuleCloset.vo.MainPhotoVo;
import kr.green.capsuleCloset.vo.TodaysClothesVo;

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

	void setTodaysClothes(TodaysClothesVo todaysClothesVo, String id);

	ArrayList<TodaysClothesVo> getTodaysClothes();

	ArrayList<FileVo> getFileVo();

	void setDelCloset(String id);

	void setDelFile(String id);

	TodaysClothesVo getToday(int numToday);

	void setMainPhoto(TodaysClothesVo todaysClothes);

	ArrayList<MainPhotoVo> getMainPhotoVo();

//	ArrayList<FileVo> getFileVo2(ArrayList<MainPhotoVo> mainPhotoVo);

	ArrayList<FileVo> getFileVo3();











}
