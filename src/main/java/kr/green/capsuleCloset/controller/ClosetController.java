package kr.green.capsuleCloset.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.capsuleCloset.service.ClosetService;
import kr.green.capsuleCloset.service.UserService;
import kr.green.capsuleCloset.utils.UploadFileUtils;
import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.FileVo;
import kr.green.capsuleCloset.vo.MainPhotoVo;
import kr.green.capsuleCloset.vo.TodaysClothesVo;
import kr.green.capsuleCloset.vo.UserVo;

@Controller
public class ClosetController {
	
	@Autowired
	ClosetService closetService;

	@Autowired
	UserService userService;
	
	private String uploadPath="D:\\Muna\\git\\2020-spring\\capsuleCloset\\src\\main\\webapp\\resources\\image";
	
	@RequestMapping(value="/aboutCloset" , method=RequestMethod.GET)
	public ModelAndView aboutClosetGet(ModelAndView mv) {
		mv.setViewName("/closet/aboutCloset");
		return mv;
	}
	
	@RequestMapping(value="/myCloset" , method=RequestMethod.GET)
	public ModelAndView myClosetGet(ModelAndView mv,HttpServletRequest r) {
			UserVo user = userService.getUser(r);
			if(user==null) {
				mv.setViewName("/closet/myCloset");
			}
			else {
				ClosetVo closetVo = closetService.getCloset(user.getId());
				if(closetVo != null) {
					mv.setViewName("redirect:/myCloset2");
				}
				else {
					mv.setViewName("/closet/myCloset");
				}
				
			}
	    return mv;
	}
	@RequestMapping(value="/myCloset" , method=RequestMethod.POST)
	public ModelAndView myClosetPost(ModelAndView mv,ClosetVo closetVo,HttpServletRequest r) {
			UserVo user = userService.getUser(r);
				closetVo.setId(user.getId());
				closetService.setCloset(closetVo);
				mv.setViewName("redirect:/myCloset2");
	    	return mv;
	}
	@RequestMapping(value="/myCloset2" , method=RequestMethod.GET)
	public ModelAndView myCloset2Get(ModelAndView mv,HttpServletRequest r) {
			UserVo user= userService.getUser(r);
			if(user!=null) {
				ClosetVo closet = closetService.getCloset(user.getId());
				mv.addObject("closet",closet);
				mv.setViewName("/closet/myCloset2");
				
				ArrayList<FileVo> fileTop=closetService.getTop(user.getId(),"top");
				mv.addObject("fileTop", fileTop);
				
				ArrayList<FileVo> fileBottom=closetService.getBottom(user.getId(),"bottom");
				mv.addObject("fileBottom", fileBottom);
				
				ArrayList<FileVo> fileOuter=closetService.getOuter(user.getId(),"outer");
				mv.addObject("fileOuter", fileOuter);
				
				ArrayList<FileVo> fileShoes=closetService.getShoes(user.getId(),"shoes");
				mv.addObject("fileShoes", fileShoes);
				
				String registerdate=closetService.getRegisterdate(user.getId());
				mv.addObject("registerdate",registerdate);
				
			}
			else {
				mv.setViewName("/closet/myCloset");
			}
	    return mv;
	}

	@RequestMapping(value="/myCloset2" , method=RequestMethod.POST)
	public ModelAndView myCloset2Post
		(ModelAndView mv,FileVo fileVo,MultipartFile [] file2,MultipartFile [] file3,MultipartFile [] file4,MultipartFile [] file5,HttpServletRequest r)
			throws IOException, Exception {
		UserVo user= userService.getUser(r);
			if(file2 != null) {
				System.out.println(file2.length);
				for(MultipartFile tmp : file2) {
					if(tmp.getOriginalFilename().length() > 0) {
					String fileName=UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
					System.out.println(fileName);
					fileVo.setFile(fileName);
					fileVo.setClothes("top");
					closetService.registerFile(fileVo,user.getId());
					System.out.println(fileVo);
					
					}
				}
			}
			if(file3 != null) {
				for(MultipartFile tmp : file3) {
					if(tmp.getOriginalFilename().length() > 0) {
					String fileName=UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
					System.out.println(fileName);
					fileVo.setFile(fileName);
					fileVo.setClothes("bottom");
					closetService.registerFile(fileVo,user.getId());
					System.out.println(fileVo);
					}
				}
			}
			if(file4 != null) {
				for(MultipartFile tmp : file4) {
					if(tmp.getOriginalFilename().length() > 0) {
					String fileName=UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
					System.out.println(fileName);
					fileVo.setFile(fileName);
					fileVo.setClothes("outer");
					closetService.registerFile(fileVo,user.getId());
					System.out.println(fileVo);
					}
				}
			}
			if(file5 != null) {
				for(MultipartFile tmp : file5) {
					if(tmp.getOriginalFilename().length() > 0) {
					String fileName=UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
					System.out.println(fileName);
					fileVo.setFile(fileName);
					fileVo.setClothes("shoes");
					closetService.registerFile(fileVo,user.getId());
					System.out.println(fileVo);
					}
				}
		}
		mv.setViewName("redirect:/myCloset3");
		mv.addObject("fileVo",fileVo);
		return mv;
	}
	

	@RequestMapping(value="/myCloset3" , method=RequestMethod.GET)
	public ModelAndView myCloset3Get(ModelAndView mv,HttpServletRequest r,Integer closetNum) {
		UserVo user= userService.getUser(r);
		if(user!=null) {
			mv.setViewName("/closet/myCloset3");
			ArrayList<FileVo> fileTop = null;
			ArrayList<FileVo> fileBottom = null;
			ArrayList<FileVo> fileOuter = null;
			ArrayList<FileVo> fileShoes = null;
			ClosetVo closet = null;
			if(closetNum == null) {
				closet = closetService.getCloset(user.getId());
				fileTop=closetService.getTop(user.getId(),"top");
				fileBottom=closetService.getBottom(user.getId(),"bottom");
				fileOuter=closetService.getOuter(user.getId(),"outer");
				fileShoes=closetService.getShoes(user.getId(),"shoes");
			}else {
				closet = closetService.getCloset2(closetNum);
				fileTop=closetService.getTop(closet.getId(),"top");
				fileBottom=closetService.getBottom(closet.getId(),"bottom");
				fileOuter=closetService.getOuter(closet.getId(),"outer");
				fileShoes=closetService.getShoes(closet.getId(),"shoes");
			}
			mv.addObject("closet",closet);
			mv.addObject("fileTop", fileTop);
			mv.addObject("fileBottom", fileBottom);
			mv.addObject("fileOuter", fileOuter);
			mv.addObject("fileShoes", fileShoes);
			mv.addObject("user", user);
			ArrayList<FileVo> fileVo=closetService.getFileVo();
			mv.addObject("fileVo",fileVo);
		}
		else {
			mv.setViewName("/closet/myCloset");
		}
	    return mv;
	}
	@RequestMapping(value="/myCloset3" , method=RequestMethod.POST)
	public ModelAndView myCloset3Post(ModelAndView mv,TodaysClothesVo todaysClothesVo,HttpServletRequest r) {
		UserVo user= userService.getUser(r);
	
			closetService.setTodaysClothes(todaysClothesVo,user.getId());
			mv.setViewName("redirect:/myTodays");
			return mv;
	}
	
	@RequestMapping(value="/myCloset4" , method=RequestMethod.POST)
	public ModelAndView myCloset4Post(ModelAndView mv,HttpServletRequest r) {
		UserVo user= userService.getUser(r);
		closetService.setDelCloset(user.id);
		closetService.setDelFile(user.id);
		mv.setViewName("redirect:/myCloset");
		return mv;
	}
	
	
	
	@RequestMapping(value="/othersCloset" , method=RequestMethod.GET)
	public ModelAndView othersClosetGet(ModelAndView mv,HttpServletRequest r) {
			UserVo user= userService.getUser(r);
			mv.setViewName("/closet/othersCloset");
	    	ArrayList<ClosetVo> closetVo=closetService.getClosetVo();
	    	mv.addObject("closetVo", closetVo);
	    	System.out.println(closetVo);
	    	
	    	if(user != null) {
		    	ClosetVo closet=closetService.getCloset(user.getId());
		    	mv.addObject("closet",closet);
	    	}
	    	
	    	ArrayList<MainPhotoVo> mainPhotoVoList=closetService.getMainPhotoVo();
	    	System.out.println(mainPhotoVoList);
	    	mv.addObject("mainPhotoVoList", mainPhotoVoList);
	    	
	    	ArrayList<FileVo> fileList = closetService.getFileVo3();
	    	mv.addObject("fileList", fileList);
	    	System.out.println(fileList);
	    	
	    return mv;
	}
	

	@RequestMapping(value="/othersToday" , method=RequestMethod.GET)
	public ModelAndView othersTodayGet(ModelAndView mv) {
	    	ArrayList<TodaysClothesVo> todaysClothesVo=closetService.getTodaysClothes();
	    	mv.addObject("todaysClothesVo", todaysClothesVo);
	    		    		    	
	    	ArrayList<FileVo> fileVo=closetService.getFileVo();
	    	mv.addObject("fileVo",fileVo);
	    	
	    	mv.setViewName("/closet/othersToday");
	    return mv;
	}
	
	

	@RequestMapping(value="/myTodays" , method=RequestMethod.GET)
	public ModelAndView myTodaysGet(ModelAndView mv,HttpServletRequest r) {
			UserVo user= userService.getUser(r);
			mv.addObject("user", user);
	    	ArrayList<TodaysClothesVo> todaysClothesVo=closetService.getTodaysClothes();
	    	mv.addObject("todaysClothesVo", todaysClothesVo);
	    	ArrayList<FileVo> fileVo=closetService.getFileVo();
	    	mv.addObject("fileVo",fileVo);
	    	mv.setViewName("/closet/myTodays");
	    return mv;
	}
	@RequestMapping(value="/myTodays", method=RequestMethod.POST)
	public ModelAndView myTodaysPost(ModelAndView mv,TodaysClothesVo todaysClothesVo,MainPhotoVo mainPhotoVo) {
			TodaysClothesVo todaysClothes = closetService.getToday(todaysClothesVo.numToday);
			System.out.println(todaysClothes);
			closetService.setMainPhoto(todaysClothes);
			System.out.println(mainPhotoVo.id);
			System.out.println(todaysClothes);
			mv.setViewName("redirect:/othersCloset");
		return mv;
	}
	

}
