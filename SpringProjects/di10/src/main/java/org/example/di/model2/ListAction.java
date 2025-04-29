package org.example.di.model2;

import org.example.di.model1.DeptDAO;
import org.example.di.model1.DeptTO;

import java.util.ArrayList;

public class ListAction implements Action {
    private DeptDAO dao;

    public ListAction(DeptDAO dao) {
        System.out.println("ListAction() 호출");
        this.dao = dao;
    }

    @Override
    public void execute() {
        ArrayList<DeptTO> lists = dao.deptList();

        for(DeptTO to : lists){
            System.out.println(to.getDeptno() + "\t" + to.getDname() + "\t" + to.getLoc());
        }
    }

    @Override
    public ArrayList<DeptTO> listDept() {
        return dao.deptList();
    }
}
