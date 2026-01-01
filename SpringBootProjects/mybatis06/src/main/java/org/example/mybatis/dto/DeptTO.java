package org.example.mybatis.dto;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias(value = "to")
@Data
public class DeptTO {
    private String deptno;
    private String dname;
    private String loc;
}
