package kr.green.capsuleCloset.dao;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.FileVo;
import kr.green.capsuleCloset.vo.TodaysClothesVo;
import kr.green.capsuleCloset.vo.UserVo;

public interface ClosetDao {

	void setCloset(@Param("closetVo")ClosetVo closetVo);

	ClosetVo getCloset(@Param("id")String id);
//	void registerFile(@Param("closetVo")ClosetVo closetVo,@Param("id")String id);
//	void registerFile(@Param("closetVo")ClosetVo closetVo, @Param("id")String id);
//
//	void updateFile(@Param("closetVo")ClosetVo closetVo);

	void registerFile(@Param("fileVo")FileVo fileVo,@Param("id") String id);

	ArrayList<FileVo> getTop(@Param("id")String id, @Param("clothes")String clothes);

	ArrayList<FileVo> getBottom(@Param("id")String id, @Param("clothes")String clothes);

	ArrayList<FileVo> getOuter(@Param("id")String id, @Param("clothes")String clothes);

	ArrayList<FileVo> getShoes(@Param("id")String id, @Param("clothes")String clothes);

	ArrayList<ClosetVo> getClosetVo();

	String getRegisterdate(@Param("id")String id);

	ClosetVo getCloset2(@Param("closetNum")Integer closetNum);

	void setTodaysClothes(@Param("todaysClothesVo")TodaysClothesVo todaysClothesVo,@Param("id") String id);

	ArrayList<TodaysClothesVo> getTodaysClothes();

	ArrayList<FileVo> getFileVo();

	void setDelCloset(@Param("id")String id);

	void setDelFile(@Param("id")String id);




	


}
