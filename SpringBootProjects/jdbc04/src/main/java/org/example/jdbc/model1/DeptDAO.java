package org.example.jdbc.model1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class DeptDAO {

    @Autowired
    private DataSource dataSource;

    public DeptDAO() {
        System.out.println("DeptDAO() 호출");
    }

    public void viewDataSource(){
        System.out.println("viewDataSource : " + dataSource);
    }
}
