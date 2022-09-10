package com.cbnu.diary.controller;

import java.util.List;

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
		List<Member> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "member";
	}
	
}
