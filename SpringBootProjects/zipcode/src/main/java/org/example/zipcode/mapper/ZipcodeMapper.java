package org.example.zipcode.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.zipcode.dto.ZipcodeTO;

import java.util.List;

@Mapper
public interface ZipcodeMapper {
     List<ZipcodeTO> listZipcode(String dong);
}
