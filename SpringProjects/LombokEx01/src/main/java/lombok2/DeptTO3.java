package lombok2;

import lombok.*;

@RequiredArgsConstructor
@Getter
public class DeptTO3 {
    @NonNull
    private String deptno;
    @NonNull
    private String dname;
    private String loc;
}
