package kr.green.capsuleCloset.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value= {"/"})
	public ModelAndView openTilesView(ModelAndView mv) throws Exception{
	    mv.setViewName("/main/home");
	    mv.addObject("setHeader", "타일즈");
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
}
