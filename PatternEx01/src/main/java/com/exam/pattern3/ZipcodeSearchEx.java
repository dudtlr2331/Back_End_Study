package com.exam.pattern3;

import java.sql.*;
import java.util.ArrayList;

public class ZipcodeSearchEx {
    public static void main(String[] args) {
        // 입력값 검사
        if (args.length != 1 ) {
            System.out.println( "Usage: java ZipcodeSearchEx03 동이름" );
            System.exit(0);
        }

        if (args[0].length() < 2 ) {
            System.out.println( "동이름을 2자 이상 입력하세요" );
            System.exit(0);
        }

        ZipcodeDAO dao = new ZipcodeDAO();
        ArrayList<ZipcodeTO> list = dao.selectZipcode( args[0] );

        ZipcodeService service = new ZipcodeService();
        service.selectZipcode(args[0]);

        for ( ZipcodeTO to : list ) {
            String data = String.format("[%s] %s %s %s %s %s"
                    , to.getZipcode(), to.getSido(), to.getGugun()
                    , to.getDong(), to.getRi(), to.getBunji());
            System.out.println(data);
        }
    }
}
