package kr.green.capsuleCloset.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.capsuleCloset.dao.ClosetDao;
import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.FileVo;
import kr.green.capsuleCloset.vo.UserVo;

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





}
