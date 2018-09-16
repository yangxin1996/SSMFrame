package cn.ncu.dao;

import org.mybatis.spring.annotation.MapperScan;

import cn.ncu.entity.User;

@MapperScan
public interface UserDao {
	User selectById(Integer id);
}
