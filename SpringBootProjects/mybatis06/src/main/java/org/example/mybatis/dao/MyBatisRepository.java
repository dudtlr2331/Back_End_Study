package org.example.mybatis.dao;

import org.example.mybatis.dto.DeptTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MyBatisRepository {

    private SqlSessionTemplate sqlSessionTemplate;

    public MyBatisRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public String select(){
        System.out.println("sqlSessionTemplate : "  + sqlSessionTemplate);
        return sqlSessionTemplate.selectOne("select");
    }

    public List<DeptTO> selectList(){
        return sqlSessionTemplate.selectList("selectlist");
    }
}
