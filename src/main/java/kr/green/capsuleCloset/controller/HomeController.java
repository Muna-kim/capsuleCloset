package kr.green.capsuleCloset.controller;

import javax.servlet.http.HttpServletRequest;

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
	    return mv;
	}

	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
	    	mv.setViewName("/main/login");
	    return mv;
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView loginPost(ModelAndView mv,UserVo userVo) {
	    	System.out.println(userVo);
	    	UserVo user = userService.signin(userVo);
	    	if(user!=null) {
	    		mv.setViewName("redirect:/");
	    		mv.addObject("user",user);
	    		System.out.println(user);
	    	}
	    	else {
	    		mv.setViewName("redirect:/signup");
	    		
	    	}
	    return mv;
	}
	
	@RequestMapping(value="/signup" , method=RequestMethod.GET)
	public ModelAndView signupGet(ModelAndView mv) {
	    	mv.setViewName("/main/signup");
	    return mv;
	}
	
	@RequestMapping(value="/signup" , method=RequestMethod.POST)
	public ModelAndView signupPost(ModelAndView mv,UserVo userVo) {
			mv.setViewName("redirect:/");
	    	System.out.println(userVo);
	    	userService.signup(userVo);
	    return mv;
	}
	
	@RequestMapping(value="/logout" , method=RequestMethod.GET)
	public ModelAndView logoutGet(ModelAndView mv,HttpServletRequest request) {
	    	mv.setViewName("redirect:/");
	    	request.getSession().removeAttribute("user");
	    return mv;
	}
}
