package org.example.imgboard.dao;

import org.example.imgboard.dto.ImageTO;
import org.example.imgboard.mapper.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageDAO {

    @Autowired
    private ImageMapper imageMapper;

    public int imageWriteOk(ImageTO to) {
        int flag = 1;
        int result = imageMapper.write_ok(to);

        if(result == 1) {
            flag = 0;
        }

        return flag;
    }

    public List<ImageTO> boardList(){
        return imageMapper.list();
    }

    public ImageTO boardView(ImageTO to) {
        imageMapper.view_hit(to);
        return imageMapper.view(to);
    }

    public ImageTO boardDelete(ImageTO to){
        return imageMapper.delete(to);
    }

    public int boardDeleteOk(ImageTO to){
        int flag = 1;
        int result = imageMapper.delete_ok(to);

        if (result == 0){
            flag = 1;
        } else if (result == 1){
            flag = 0;
        }

        return flag;
    }

    public ImageTO boardModify(ImageTO to) {
        return imageMapper.modify(to);
    }

    public int boardModifyOk(ImageTO to) {
        int flag = 2;
        int result = imageMapper.modify_ok(to);

        if (result == 0){
            flag = 1;
        } else if (result == 1){
            flag = 0;
        }
        return flag;
    }
}
