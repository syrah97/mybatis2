package com.mbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mbs.dto.MemberDto;
import com.mbs.service.MemberService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/member")
@Log4j
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@GetMapping("/join")
	public String getjoin() throws Exception{
		
		return "/member/join";
	}
	
	@PostMapping("/join")
	public String postjoin(MemberDto dto) throws Exception {
		
		service.joinObject(dto);
		log.info(dto);
		return "redirect:/";
	}
	
//	@GetMapping("/login")
//	void loginform() {
//		log.info("login get...");
//	}
	
	@PostMapping("/login")
	public String login(MemberDto dto, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		log.info("login complete...");
		
		HttpSession session = req.getSession();
		MemberDto login = service.loginObject(dto);
		
		if(login == null) {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);	
		}else {
			session.setAttribute("member", login);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		
		session.invalidate();
		
		log.info("logout complete...");
		
		return "redirect:/";
	}
	
	
	@GetMapping("/memberUpdateView")
	public String registerUpdateView() throws Exception{
		
		log.info("memberUpdate...");
		
		return "/member/memberUpdateView";
	}
	
	@PostMapping("/memberUpdate")
	public String registerUpdate(MemberDto dto, HttpSession session) throws Exception{
		
		log.info("memberupdate complete...");
		
		service.memberUpdate(dto);
		
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	
	
}
