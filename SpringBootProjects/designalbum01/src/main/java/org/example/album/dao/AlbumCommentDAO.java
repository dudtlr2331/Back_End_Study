package org.example.album.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.album.dto.AlbumCommentTO;
import org.example.album.mapper.AlbumCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumCommentDAO {

    @Autowired
    private AlbumCommentMapper albumCommentMapper;

    public int albumCommentWriteOK(AlbumCommentTO to){
        int flag = 0;

        int result = albumCommentMapper.write_ok(to);

        if(result == 1){
            flag = 0;
        }

        return flag;
    }

    public List<AlbumCommentTO> list(AlbumCommentTO to){
        return albumCommentMapper.list(to);
    }
}
