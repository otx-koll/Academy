package com.exam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.exam.vo.MemberVo;

// MyBatis���� Mapper �������̽��� ������ ������ ��!
public interface MemberMapper {
	
	// ������ �޼ҵ尡 �Ű������� 2�� �̻� ���� ����
	// @Param �ֳ����̼� ������ �̸��� �����ؾ� ��
	// ex) 
//	#{}�ȿ� �̸� �ƹ��ų� ���൵ �� 
//	@Select("SELECT * FROM member WHERE id = #{iii} and num = #{num}")
//	MemberVo getMemberById(@Param("iii") String id, @Param("num") int num);

//	@Select("SELECT * FROM member WHERE id = #{id}")
	MemberVo getMemberById(String id);
	
//	@Select("SELECT * FROM member ORDER BY id")
	List<MemberVo> getAllMembers();
	
	void addMember(MemberVo memberVo);
	
//	@Select("SELECT passwd FROM member WHERE id = #{id}")
	String userCheck(String id);
	
//	@Select("SELECT COUNT(*) FROM member WHERE id = #{id}")
	int getCountById(String id);
	
	void update(MemberVo memberVo);
	
//	@Delete("DELETE FROM member WHERE id = #{id}")
	void deleteById(String id);
	
//	@Delete("DELETE FROM member")
	void deleteAll();
	
//	@Select("SELECT gender, count(*) AS cnt"
//			+ "FROM member"
//			+ "GROUP BY gender")
	List<Map<String, Object>> getGenderPerCount();
	
	List<Map<String, Object>> getAgeRangePerCount();
}