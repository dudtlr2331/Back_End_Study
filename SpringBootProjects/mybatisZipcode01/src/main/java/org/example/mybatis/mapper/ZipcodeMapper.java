package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis.dto.ZipcodeTO;

import java.util.List;

@Mapper
public interface ZipcodeMapper {
    public List<ZipcodeTO> listZipcode(String dong);
}
