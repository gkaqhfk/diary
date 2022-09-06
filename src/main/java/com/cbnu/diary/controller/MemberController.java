package com.cbnu.diary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cbnu.diary.domain.Member;
import com.cbnu.diary.service.MemberService;

@Controller
@RequestMapping("members")
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping
	public String members(Model model) {
		Member member = memberService.getMember("e200uk");
		model.addAttribute("member", member);
		return "member";
	}
	
}
