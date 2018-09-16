package cn.ncu.Test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.ncu.dao.UserDao;


public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "sqlMapConfig.xml";
		InputStream inputStream;
		inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		UserDao userDao = session.getMapper(UserDao.class);			
		System.out.println(userDao.selectById(8001));
		session.close();
			
	}

}
