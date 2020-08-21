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
	    	System.out.println(closetVo);
	    return mv;
	}
	@RequestMapping(value="/myCloset2" , method=RequestMethod.GET)
	public ModelAndView myCloset2Get(ModelAndView mv,HttpServletRequest r) {
			UserVo user= userService.getUser(r);
//			ClosetVo c = new ClosetVo();
//			c.setSetGoal(60);
//			c.setTop(7);
//			mv.addObject("closet", c);
			ClosetVo closet = closetService.getCloset(user.getId());
			mv.addObject("closet",closet);
	    	mv.setViewName("/closet/myCloset2");
	    	System.out.println(user);
	    	System.out.println(closet);
	    return mv;
	}
	
//	@RequestMapping(value="/myCloset2" , method=RequestMethod.POST)
//	public ModelAndView myCloset2Post(ModelAndView mv,ClosetVo closetVo,HttpServletRequest r) {
//		closetService.updateFile(closetVo);
//		
//		System.out.println(closetVo);
//		mv.setViewName("redirect:/myCloset2");
//		return mv;
//	}
	
//	@RequestMapping(value="/myCloset2" , method=RequestMethod.POST)
//	public ModelAndView myCloset2Post(ModelAndView mv,ClosetVo closetVo,MultipartFile file,HttpServletRequest request) throws IOException, Exception {
//		mv.setViewName("redirect:/myCloset2");
////			String fileName=
////					UploadFileUtils.uploadFile(uploadPath,file.getOriginalFilename(),file.getBytes());
////	    	closetVo.setFile(fileName);
////	    	closetService.registerFile(closetVo,request);
//					System.out.println(file);
//	    return mv;
//	}
	
//	@RequestMapping(value="/myCloset2" , method=RequestMethod.POST)
//	public ModelAndView myCloset2Post(ModelAndView mv,ClosetVo closetVo,MultipartFile [] file2,HttpServletRequest r) throws IOException, Exception {
//		UserVo user= userService.getUser(r);
//		if(file2 != null) {
//			System.out.println(file2.length);
//			for(MultipartFile tmp : file2) {
//				if(tmp.getOriginalFilename().length() > 0) {
//				String fileName=UploadFileUtils.uploadFile(uploadPath, tmp.getOriginalFilename(), tmp.getBytes());
//				System.out.println(fileName);
//				closetVo.setFile(fileName);
//				closetService.registerFile(closetVo,user.getId());
//				}
//				
//			}
//		}
//		mv.setViewName("redirect:/myCloset2");
//		return mv;
//	}
	
	@RequestMapping(value="/myCloset2" , method=RequestMethod.POST)
	public ModelAndView myCloset2Post(ModelAndView mv,FileVo fileVo,MultipartFile [] file2,MultipartFile [] file3,MultipartFile [] file4,MultipartFile [] file5,HttpServletRequest r) throws IOException, Exception {
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
		return mv;
	}
	

	@RequestMapping(value="/myCloset3" , method=RequestMethod.GET)
	public ModelAndView myCloset3Get(ModelAndView mv,HttpServletRequest r) {
		UserVo user= userService.getUser(r);
		ClosetVo closet = closetService.getCloset(user.getId());
		mv.addObject("closet",closet);
//			mv.addObject("closet",closetVo);
	    	mv.setViewName("/closet/myCloset3");
////	    	System.out.println(user);
////	    	System.out.println(closet);
	    	ArrayList<FileVo> fileTop=closetService.getTop(user.getId(),"top");
	    	System.out.println(fileTop);
	    	mv.addObject("fileTop", fileTop);
	    	
	    	ArrayList<FileVo> fileBottom=closetService.getBottom(user.getId(),"bottom");
	    	mv.addObject("fileBottom", fileBottom);
	    	
	    	ArrayList<FileVo> fileOuter=closetService.getOuter(user.getId(),"outer");
	    	mv.addObject("fileOuter", fileOuter);
	    	
	    	ArrayList<FileVo> fileShoes=closetService.getShoes(user.getId(),"shoes");
	    	mv.addObject("fileShoes", fileShoes);
	    return mv;
	}
	
	@RequestMapping(value="/othersCloset" , method=RequestMethod.GET)
	public ModelAndView othersClosetGet(ModelAndView mv) {
	    	mv.setViewName("/closet/othersCloset");
	    return mv;
	}
	@RequestMapping(value="/todaysClothes" , method=RequestMethod.GET)
	public ModelAndView todaysclothesGet(ModelAndView mv) {
	    	mv.setViewName("/closet/todaysClothes");
	    return mv;
	}
	
}
