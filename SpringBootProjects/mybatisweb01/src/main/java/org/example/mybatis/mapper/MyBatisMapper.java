package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dto.DeptTO;

import java.util.List;

@Mapper
public interface MyBatisMapper {

	String select();
	List<DeptTO> selectList();
}
