package com.cbnu.diary.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.cbnu.diary.entity.Member;
import com.cbnu.diary.mapper.MemberMapper;

@RequiredArgsConstructor
@Service
public class MemberService {
	
	private final MemberMapper memberMapper;
	
	public Member getMember(String memberId) {
		return memberMapper.findOne(memberId);
	}

	public List<Member> getMembers() {
		return memberMapper.findAll();
	}

}
