package lombok3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString(exclude = {"loc"})
public class DeptTO2 {
    private String deptno;
    private String dname;
    private String loc;
}
