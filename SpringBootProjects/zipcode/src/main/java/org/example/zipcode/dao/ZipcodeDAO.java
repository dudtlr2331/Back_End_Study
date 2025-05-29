package org.example.zipcode.dao;

import org.example.zipcode.dto.ZipcodeTO;
import org.example.zipcode.mapper.ZipcodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZipcodeDAO {

    @Autowired
    private ZipcodeMapper zipcodeMapper;

    public List<ZipcodeTO> listZipcode(String dong){
        return zipcodeMapper.listZipcode(dong);
    }
}
