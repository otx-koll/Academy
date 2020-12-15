package com.exam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.exam.vo.MemberVo;

// MyBatis에서 Mapper 인터페이스가 실행의 기준이 됨!
public interface MemberMapper {

	@Select("SELECT * FROM member WHERE id = #{id}")
	MemberVo getMemberById(String id);
	
	@Select("SELECT * FROM member ORDER BY id")
	List<MemberVo> getAllMembers();
	
}
