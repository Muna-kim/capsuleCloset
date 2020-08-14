package kr.green.capsuleCloset.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.capsuleCloset.service.ClosetService;

@Controller
public class ClosetController {
	
	@Autowired
	ClosetService closetService;
	
	
	@RequestMapping(value="/aboutCloset" , method=RequestMethod.GET)
	public ModelAndView aboutClosetGet(ModelAndView mv) {
		mv.setViewName("/closet/aboutCloset");
		return mv;
	}
	
	@RequestMapping(value="/myCloset" , method=RequestMethod.GET)
	public ModelAndView myClosetGet(ModelAndView mv) {
	    	mv.setViewName("/closet/myCloset");
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
