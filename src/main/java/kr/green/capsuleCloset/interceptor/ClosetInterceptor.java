package kr.green.capsuleCloset.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.capsuleCloset.vo.ClosetVo;
import kr.green.capsuleCloset.vo.UserVo;

public class ClosetInterceptor extends HandlerInterceptorAdapter{

    @Override
    public void postHandle(
        HttpServletRequest request, 
        HttpServletResponse response, 
        Object handler, 
        ModelAndView modelAndView)
        throws Exception {
        ModelMap modelMap = modelAndView.getModelMap();
        ClosetVo closet = (ClosetVo)modelMap.get("closet");
 
        if(closet != null) {
            HttpSession session = request.getSession();
            session.setAttribute("closet", closet);
        }
    }
}
