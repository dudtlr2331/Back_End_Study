package org.example.mybatis07.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis07.dto.DeptTO;

import java.util.List;

@Mapper
public interface MyBatisMapper {
    String select();
    List<DeptTO> selectList();
    int insert(DeptTO deptTO);
    int updateByDeptno(DeptTO deptTO);
    int deleteByDeptno(DeptTO deptTO);
}
