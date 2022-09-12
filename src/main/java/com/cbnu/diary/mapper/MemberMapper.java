package com.cbnu.diary.mapper;

import java.util.List;

import com.cbnu.diary.entity.Member;
import org.springframework.stereotype.Repository;

public interface MemberMapper {

	List<Member> findAll();

	Member findOne(String memberId);

}
