package lombok2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeptTO2 {
    private String deptno;
    private String dname;
    private String loc;
}
