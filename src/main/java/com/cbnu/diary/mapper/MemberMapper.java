package com.cbnu.diary.mapper;

import java.util.List;

import com.cbnu.diary.domain.Member;

public interface MemberMapper {

	List<Member> findAll();

	Member findOne(String memberId);

}
