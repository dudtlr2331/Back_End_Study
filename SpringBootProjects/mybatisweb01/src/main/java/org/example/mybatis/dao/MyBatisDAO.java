package org.example.mybatis.dao;

import org.example.mybatis.dto.DeptTO;
import org.example.mybatis.mapper.MyBatisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisDAO {

	@Autowired
	private MyBatisMapper myBatisMapper;

	public String select() {
		return myBatisMapper.select();
	}

	public List<DeptTO> selectList() {
		return myBatisMapper.selectList();
	}
}
