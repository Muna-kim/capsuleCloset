package kr.green.capsuleCloset.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.capsuleCloset.service.ClosetService;
import kr.green.capsuleCloset.service.UserService;
import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.UserVo;

@Controller
public class ClosetController {
	
	@Autowired
	ClosetService closetService;

	@Autowired
	UserService userService;
	
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
