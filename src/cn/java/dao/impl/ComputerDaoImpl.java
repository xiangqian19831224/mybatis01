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
	 * 查询所有的记录
	 */
	@Test
	public void selectAll() throws IOException {
		// 1、需要执行sql语句(SqlSession--->SqlSessionFactory---->SqlSessionFactoryBuilder)
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();

		// 将mybasti.xml主配置文件编程字节输入流
		InputStream ins = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory ssf = sfb.build(ins);
		SqlSession session = ssf.openSession();

		// 2、调用SqlSession类中的方法来执行sql
		// 调用方式是： namespace + "." + id
		List<Computer> lists = session.selectList("cn.java.dao.impl.ComputerDaoImpl.selectAll");

		// 3、打印结果
		for (Computer computer : lists) {
			System.out.println(computer);
		}
	}
}
