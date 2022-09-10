package com.cbnu.diary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cbnu.diary.domain.Member;
import com.cbnu.diary.mapper.MemberMapper;

@Service
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	public MemberService(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}
	
	public Member getMember(String memberId) {
		return memberMapper.findOne(memberId);
	}

	public List<Member> getMembers() {
		return memberMapper.findAll();
	}

}
