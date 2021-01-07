package com.exam.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.exam.mapper.MysqlMapper;

public class MySqlDao {
	// ΩÃ±€≈Ê
	private static MySqlDao instance = new MySqlDao();

	public static MySqlDao getInstance() {
		return instance;
	}
	
	///////////////////////////////////////////////////
	
	private SqlSessionFactory sqlSessionFactory;
	
	private MySqlDao() {
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
