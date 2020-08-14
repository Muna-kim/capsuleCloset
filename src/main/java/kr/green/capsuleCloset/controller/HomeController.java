package kr.green.capsuleCloset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.capsuleCloset.service.UserService;
import kr.green.capsuleCloset.vo.UserVo;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService userService;
	
	@RequestMapping(value= {"/"})
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
	    System.out.println(userService.getId("aaa"));
	    return mv;
	}

	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
	    	mv.setViewName("/main/login");
	    return mv;
	}
	
	@RequestMapping(value="/signup" , method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
	    	mv.setViewName("/main/signup");
	    return mv;
	}
	
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo userVo) {
			mv.setViewName("/main/signup");
	    	System.out.println(userVo);
	    return mv;
	}
}
