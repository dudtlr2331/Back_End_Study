package org.example.restweb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeptTO {
    private String deptno;
    private String dname;
    private String loc;
}
