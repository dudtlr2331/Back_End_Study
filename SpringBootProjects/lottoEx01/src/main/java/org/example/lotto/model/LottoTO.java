package org.example.lotto.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LottoTO {
    private String draw_no;
    private String draw_date;
    private String num1;
    private String num2;
    private String num3;
    private String num4;
    private String num5;
    private String num6;
    private String bonus;
}
