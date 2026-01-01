package org.example.mybatis07.service;

import org.example.mybatis07.dto.DeptTO;
import org.example.mybatis07.mapper.MyBatisMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBatisSerivce {

    private MyBatisMapper myBatisMapper;

    public MyBatisSerivce(MyBatisMapper myBatisMapper) {
        this.myBatisMapper = myBatisMapper;
    }

    public void select(){
        String result = myBatisMapper.select();
        System.out.println("result : " + result);
    }

    public void selectList(){
        List<DeptTO> lists = myBatisMapper.selectList();
        System.out.println("lists : " + lists);
    }

    public void insert(){
        DeptTO to = new DeptTO();
        to.setDeptno("60");
        to.setDname("기획부");
        to.setLoc("서울");

        int result = myBatisMapper.insert(to);
        System.out.println("result : " + result);
    }

    public void update(){
        DeptTO to = new DeptTO();
        to.setDeptno("60");
        to.setDname("환경부");
        to.setLoc("부산");

        int result = myBatisMapper.updateByDeptno(to);
        System.out.println("result : " + result);
    }

    public void delete(){
        DeptTO to = new DeptTO();
        to.setDeptno("60");

        int result = myBatisMapper.deleteByDeptno(to);
        System.out.println("result : " + result);
    }
}
