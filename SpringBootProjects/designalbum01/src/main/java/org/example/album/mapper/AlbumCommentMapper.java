package org.example.album.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.album.dto.AlbumCommentTO;

import java.util.List;

@Mapper
public interface AlbumCommentMapper {
    int write_ok(AlbumCommentTO to);
    List<AlbumCommentTO> list(AlbumCommentTO to);
}
