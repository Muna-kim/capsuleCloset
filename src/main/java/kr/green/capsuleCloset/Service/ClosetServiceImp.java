package kr.green.capsuleCloset.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.capsuleCloset.dao.ClosetDao;
import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.FileVo;
import kr.green.capsuleCloset.vo.MainPhotoVo;
import kr.green.capsuleCloset.vo.TodaysClothesVo;

@Service
public class ClosetServiceImp implements ClosetService {

	@Autowired
	ClosetDao closetDao;

	@Override
	public void setCloset(ClosetVo closetVo) {
		closetDao.setCloset(closetVo);
		
	}

	@Override
	public ClosetVo getCloset(String id) {
		return closetDao.getCloset(id);
	}

	@Override
	public void registerFile(FileVo fileVo, String id) {
		closetDao.registerFile(fileVo, id);
		
	}

	@Override
	public ArrayList<FileVo> getTop(String id, String clothes) {
		return closetDao.getTop(id,clothes);
	}

	@Override
	public ArrayList<FileVo> getBottom(String id, String clothes) {
		return closetDao.getBottom(id,clothes);
	}

	@Override
	public ArrayList<FileVo> getOuter(String id, String clothes) {
		return closetDao.getOuter(id,clothes);
	}

	@Override
	public ArrayList<FileVo> getShoes(String id, String clothes) {
		return closetDao.getShoes(id,clothes);
	}

	@Override
	public ArrayList<ClosetVo> getClosetVo() {
		return closetDao.getClosetVo();
	}

	@Override
	public String getRegisterdate(String id) {
		return closetDao.getRegisterdate(id);
	}

	@Override
	public ClosetVo getCloset2(Integer closetNum) {
		return closetDao.getCloset2(closetNum);
	}

	@Override
	public void setTodaysClothes(TodaysClothesVo todaysClothesVo,String id) {
		closetDao.setTodaysClothes(todaysClothesVo,id);
	}

//	@Override
//	public void setTodaysClothes(TodaysClothesVo todaysClothesVo,String id) {
//		FileVo fileTop = closetDao.getFile(todaysClothesVo.getTodaystop());
//		FileVo fileBottom = closetDao.getFile(todaysClothesVo.getTodaysbottom()());
//		closetDao.setTodaysClothes(fileTop);
//		
//	}
	
	@Override
	public ArrayList<TodaysClothesVo> getTodaysClothes() {
		return closetDao.getTodaysClothes();
	}

	@Override
	public ArrayList<FileVo> getFileVo() {
		return closetDao.getFileVo();
	}


	@Override
	public void setDelCloset(String id) {
		closetDao.setDelCloset(id);
	}

	@Override
	public void setDelFile(String id) {
		closetDao.setDelFile(id);
	}

	@Override
	public TodaysClothesVo getToday(int numToday) {
		return closetDao.getToday(numToday);
		
	}

//	@Override
//	public void setMainPhoto(TodaysClothesVo todaysClothes) {
//		closetDao.setMainPhoto(todaysClothes);
//		
//	}

	@Override
	public ArrayList<MainPhotoVo> getMainPhotoVo() {
		return closetDao.getMainPhotoVo();
	}

//	@Override
//	public ArrayList<FileVo> getFileVo2(ArrayList<MainPhotoVo> mainPhotoVo) {
//		ArrayList<FileVo> list = new ArrayList<FileVo>();
//		for(int i = 0; i<mainPhotoVo.size();i++) {
//			FileVo fileTopTmp = closetDao.getFileVo2(mainPhotoVo.get(i).getMainTop());
//			list.add(fileTopTmp);
//		}
//		return list;
//	}

	@Override
	public ArrayList<FileVo> getFileVo3() {
		return closetDao.getFileVo3();
	}

	@Override
	public void setMainPhoto(TodaysClothesVo todaysClothes) {
		MainPhotoVo mainVo = closetDao.getMainPhoto(todaysClothes.id);
		if(mainVo !=null) {
			closetDao.updateMainPhoto(todaysClothes,mainVo.getId());
		}
		else{
			closetDao.setMainPhoto(todaysClothes);
		}
		
	}


	









}
