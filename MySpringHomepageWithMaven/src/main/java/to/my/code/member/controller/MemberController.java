package to.my.code.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import to.my.code.member.service.MemberService;
import to.my.code.member.status.MemberStatus;
import to.my.code.member.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService<MemberVo> memberService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm() {
		return "/member/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@ModelAttribute final MemberVo memberVo, final HttpServletRequest request) {
		MemberStatus memberStatus = memberService.join(memberVo);
		
		HttpSession session = request.getSession();
		
		if(memberStatus == MemberStatus.INSERT_FAIL) {
			
		}else {
			session.setAttribute("memberVo", memberVo);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "/member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute final MemberVo memberVo, HttpServletRequest request) {
		MemberStatus memberStatus = memberService.login(memberVo);
		HttpSession session = request.getSession();
		
		
		if(memberStatus == MemberStatus.LOGIN_FAIL) {
			return "redirect:login";
		}else {
			session.setAttribute("memberVo", memberVo);
			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		
		return "redirect:/";
	}
}
