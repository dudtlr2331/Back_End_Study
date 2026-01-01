package org.example.zipcode.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias("to")
@Getter
@Setter
@ToString
public class ZipcodeTO {
    private String zipcode;
    private String sido;
    private String gugun;
    private String dong;
    private String ri;
    private String bunji;
    private String seq;
}
