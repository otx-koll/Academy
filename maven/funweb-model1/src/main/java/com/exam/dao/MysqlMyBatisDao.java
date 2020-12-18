package com.exam.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.MysqlMapper;
import com.exam.vo.NoticeVo;

public class MysqlMyBatisDao {
	// ΩÃ±€≈Ê
	private static MysqlMyBatisDao instance = new MysqlMyBatisDao();

	public static MysqlMyBatisDao getInstance() {
		return instance;
	}
	
	///////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;
	
	private MysqlMyBatisDao() {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}
	
	public int getNextNum(String tableName) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
			MysqlMapper mapper = sqlSession.getMapper(MysqlMapper.class);
			int num = mapper.getNextNum(tableName);
			return num;
		}
	}
}
