package org.example.album.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Alias(value = "cto")
@Getter
@Setter
public class AlbumCommentTO {
    private String seq;
    private String pseq;
    private String writer;
    private String password;
    private String content;
    private String wdate;

}
