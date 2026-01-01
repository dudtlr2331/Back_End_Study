package org.example.mybatis.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Alias( value = "to")
@Getter
@Setter
@ToString
public class DeptTO {
	private String deptno;
	private String dname;
	private String loc;
}

