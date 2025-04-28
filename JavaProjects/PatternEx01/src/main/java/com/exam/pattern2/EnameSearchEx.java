package com.exam.pattern2;

import java.util.ArrayList;
import java.util.Scanner;

public class EnameSearchEx {
    public static void main(String[] args) {
        // 실행클래스

        Scanner sc = new Scanner( System.in );
        System.out.print( "사원이름 : " );
        String strEname = sc.nextLine();

        System.out.println( "입력 : " + strEname );

        sc.close();

        // 처리 파트
        EmpDAO dao = new EmpDAO();
//        dao.selectEmp("s");
        ArrayList<EmpTO> lists = dao.selectEmp(strEname);

        // 출력
        for(EmpTO to : lists) {
//            System.out.println(to);
            String data = String.format("[%s] %s %s %s %s %s"
                    , to.getEmpno(), to.getEname(), to.getJob()
                    , to.getAnnsal(), to.getHiredate(), to.getDeptno());
            System.out.println(data);
        }
    }
}
