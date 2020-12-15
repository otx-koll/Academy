package com.exam.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.MemberMapper;
import com.exam.vo.MemberVo;

public class MemberMyBatisDao {

	private static MemberMyBatisDao instance = new MemberMyBatisDao();
	
	public static MemberMyBatisDao getInstance() {
		return instance;
	}
	///////////////////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;

	private MemberMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	public MemberVo getMemberById(String id) {
		MemberVo memberVo = null;
		
//		SqlSession sqlSession = sqlSessionFactory.openSession(true); // autocommit의 true, false
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		mapper.getMemberById(id);
//		sqlSession.close(); // 생략하고싶으면 try-with-resource

		// try-with-resource
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			memberVo = mapper.getMemberById(id);
		}
		return memberVo;
	}
	
	public List<MemberVo> getAllMembers() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			List<MemberVo> list = mapper.getAllMembers();
			return list;
		}
	}
	
	public static void main(String[] args) {
		MemberMyBatisDao dao = MemberMyBatisDao.getInstance();
		
		MemberVo memberVo = dao.getMemberById("aaa");
		//System.out.println(memberVo);
		
		System.out.println("============================");
		
		List<MemberVo> list = dao.getAllMembers();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}
