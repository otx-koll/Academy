package com.exam.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	// static �ʱ�ȭ ��� : Ŭ������ �ε��� �� �ѹ� �����
	static {
		// �ڹ� 7�������� try-with-resource ���� ����
		// try ()�� finally���� �ڿ� �ݾƾ��� �������� ����ϸ�
		// �ڵ����� �ڿ��� �ݾ��ش�.
		try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
	} // static

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
