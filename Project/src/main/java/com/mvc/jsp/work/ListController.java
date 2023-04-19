package com.mvc.jsp.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ListController {
String uploadPath = "C:\\Users\\gram\\git\\Project6\\WorkingAnts\\Project\\src\\main\\resources\\static\\upload";
	
	//WorkService service = new WorkService();
	
	@RequestMapping("/jsp/createList")
	public ModelAndView reviewView(WorkVo wVo, HttpServletResponse resp, HttpSession session) {
		System.out.println("만들어져라 얍");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		ModelAndView mv = new ModelAndView();
		
		//boolean b = service.insert(wVo);
		
		/*
		 * try { PrintWriter out = resp.getWriter(); //if(!b) { out.print("<script>");
		 * out.print("   alert('저장 중 오류 발생')"); out.print("</script>"); //} } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
		//wVo = service.getwVo();
		
		mv.addObject("userNickname", "Allo");
		//mv.addObject("wVo", wVo);
		mv.setViewName("/jsp/view");
		return mv;
		
	}
	
}
