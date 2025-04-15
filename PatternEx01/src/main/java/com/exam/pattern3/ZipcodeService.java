package com.exam.pattern3;

import java.util.ArrayList;

public class ZipcodeService {
    ZipcodeDAO dao = new ZipcodeDAO();

    public ArrayList<ZipcodeTO> selectZipcode(String strDong) {
        return dao.selectZipcode(strDong);
    }

}
