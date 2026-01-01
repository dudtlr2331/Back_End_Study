package org.example.mybatis.service;

import org.example.mybatis.dao.MyBatisRepository;
import org.example.mybatis.dto.DeptTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBatisService {

    private MyBatisRepository myBatisRepository;

    public MyBatisService(MyBatisRepository myBatisRepository) {
        this.myBatisRepository = myBatisRepository;
    }

    public void select(){
        String result = myBatisRepository.select();
        System.out.println("result : " + result);
    }

    public void selectList(){
        List<DeptTO> lists = myBatisRepository.selectList();

        for (DeptTO to : lists) {
            System.out.println("to : " + to);
        }
    }
}
