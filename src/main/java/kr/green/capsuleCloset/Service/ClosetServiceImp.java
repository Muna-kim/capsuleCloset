package kr.green.capsuleCloset.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.capsuleCloset.dao.ClosetDao;
import kr.green.capsuleCloset.vo.ClosetVo;
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
	
//	@Override
//	public void setCloset(ClosetVo closetVo) {
//		closetDao.setCloset(closetVo);
//	}

//	@Override
//	public void setCloset(ClosetVo closetVo, UserVo userVo) {
//		closetDao.setCloset(closetVo);
//		
//	}


}
