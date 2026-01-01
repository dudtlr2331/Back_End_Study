package org.example.mybatis.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;

@Repository
public class EmpDAO {

    @Autowired
    private SqlSession sqlSession;

    public Map<String, Object> select1(){
        return sqlSession.selectOne("org.example.mybatis2.selectone1");
    }

    public EmpTO select2(){
        return sqlSession.selectOne("org.example.mybatis2.selectone2");
    }
}
