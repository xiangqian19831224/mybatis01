package cn.java.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.java.entity.Computer;

public class ComputerDaoImpl {
	/*
	 * ��ѯ���еļ�¼
	 */
	@Test
	public void selectAll() throws IOException {
		// 1����Ҫִ��sql���(SqlSession--->SqlSessionFactory---->SqlSessionFactoryBuilder)
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();

		// ��mybasti.xml�������ļ�����ֽ�������
		InputStream ins = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory ssf = sfb.build(ins);
		SqlSession session = ssf.openSession();

		// 2������SqlSession���еķ�����ִ��sql
		// ���÷�ʽ�ǣ� namespace + "." + id
		List<Computer> lists = session.selectList("cn.java.dao.impl.ComputerDaoImpl.selectAll");

		// 3����ӡ���
		for (Computer computer : lists) {
			System.out.println(computer);
		}
	}
}
