package org.example.di.model2;

import org.example.di.model1.DeptTO;

import java.util.ArrayList;

public interface Action {
    void execute();
    ArrayList<DeptTO> listDept();
}
