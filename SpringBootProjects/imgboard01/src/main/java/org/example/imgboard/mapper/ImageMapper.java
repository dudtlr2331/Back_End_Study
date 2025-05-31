package org.example.imgboard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.imgboard.dto.ImageTO;

import java.util.List;

@Mapper
public interface ImageMapper {
    List<ImageTO> list();
    int write_ok(ImageTO to);
    void view_hit(ImageTO to);
    ImageTO view(ImageTO to);
    ImageTO delete(ImageTO to);
    int delete_ok(ImageTO to);
    ImageTO modify(ImageTO to);
    int modify_ok(ImageTO to);
}
