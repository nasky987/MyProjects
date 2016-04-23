package to.my.code.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import to.my.code.member.dao.MemberDao;
import to.my.code.member.service.MemberService;
import to.my.code.member.status.MemberStatus;
import to.my.code.member.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberService<MemberVo> memberService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinForm(Model model) {
		model.addAttribute("memberVo", new MemberVo());
		return "/member/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(@Valid @ModelAttribute final MemberVo memberVo, BindingResult bindingResult, Model model, final HttpServletRequest request) {
		if(bindingResult.hasErrors()) {
			List<ObjectError> erros = bindingResult.getAllErrors();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			for(ObjectError error : erros) {
				System.out.println(error);
				stringBuilder.append(error.getDefaultMessage()).append("<br/>");
			}
			
			model.addAttribute("msg", stringBuilder.toString());
			
			return "/member/join";
		} else {
			MemberStatus memberStatus = memberService.join(memberVo);
			
			HttpSession session = request.getSession();
			
			if(memberStatus == MemberStatus.INSERT_FAIL) {
				
			}else {
				session.setAttribute("memberVo", memberVo);
			}
			
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "/member/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute final MemberVo memberVo, HttpServletRequest request) {
		MemberStatus memberStatus = memberService.login(memberVo);
		HttpSession session = request.getSession();
		System.out.println("[session ID] : " + session.getId());
		
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
	
	@RequestMapping(value="/listAll")
	public String listAll(Model model) {
		List<MemberVo> members = memberService.listAll();
		
		
		if(members.size() == 0 ) {
			return "redirect:/";
		}
		
		model.addAttribute("members", members);
		return "/member/listAll";
	}
}
