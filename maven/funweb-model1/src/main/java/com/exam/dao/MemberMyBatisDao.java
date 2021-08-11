package com.exam.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mindrot.jbcrypt.BCrypt;

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

//		SqlSession sqlSession = sqlSessionFactory.openSession(true); // autocommit�� true, false
//		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
//		mapper.getMemberById(id);
//		sqlSession.close(); // �����ϰ������� try-with-resource

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

	// ȸ������ 1�� insert�ϱ�
	public void addMember(MemberVo memberVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.addMember(memberVo);
			
			// openSession false�� �ϸ� ������ commit���ְ��ؾ���. ���߿� ��۾��� �� �� ���ϵ�
//			sqlSession.commit();
//			sqlSession.rollback();
		} 
	}
	
	// �α��� Ȯ��
	// check -1�̸� ���� ���̵�
	// check 0�̸� �н����� Ʋ��
	// check 1�̸� ���̵�, �н����� ��� ��ġ
	public int userCheck(String id, String passwd) {
		int check = -1; // ���� ���̵� ���°����� �ʱ�ȭ
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			String dbPasswd = mapper.userCheck(id); // dbPasswd�� ��ȣȭ�� ���ڿ���
			
			if (dbPasswd != null) {
				if (BCrypt.checkpw(passwd, dbPasswd)) { // passwd.equals(dbPasswd) 
					check = 1;
				} else {
					check = 0;
				}
			} else { // dbPasswd == null
				check = -1;
			}
		}
		return check;
	}
	
	public int getCountById(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			int count = mapper.getCountById(id);
			return count;
		}
	}

	public void update(MemberVo memberVo) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.update(memberVo);
		}
	}
	
	public void deleteById(String id) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.deleteById(id);
		}
	}
	
	public void deleteAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.deleteAll();
		}
	}
	
	public List<Map<String, Object>> getGenderPerCount() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			List<Map<String, Object>> list = mapper.getGenderPerCount();
			return list;
		}
	}
	
	public List<Map<String, Object>> getAgeRangePerCount() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			List<Map<String, Object>> list = mapper.getAgeRangePerCount();
			return list;
		}
	}
	
	public static void main(String[] args) {
		MemberMyBatisDao dao = MemberMyBatisDao.getInstance();

		MemberVo memberVo = dao.getMemberById("user1");
//		System.out.println(memberVo);

		System.out.println("============================");

		List<MemberVo> list = dao.getAllMembers();
		for (MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}