package org.example.jdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeptTO {
    private String deptno;
    private String dname;
    private String loc;
}
