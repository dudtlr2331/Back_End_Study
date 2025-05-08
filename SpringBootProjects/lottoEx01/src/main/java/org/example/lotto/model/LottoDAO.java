package org.example.lotto.model;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LottoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLotto(){
        CSVReader reader = null;

        String sql = "INSERT INTO lotto_results (draw_no, draw_date, num1, num2, num3, num4, num5, num6, bonus) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            reader = new CSVReaderBuilder(new FileReader("./src/main/resources/excel.csv")).build();

            String[] arr;

            while ((arr = reader.readNext()) != null) {
                LottoTO to = new LottoTO();

                to.setDraw_no(arr[0].trim());
                to.setDraw_date(arr[1].trim());
                to.setNum1(arr[2].trim());
                to.setNum2(arr[3].trim());
                to.setNum3(arr[4].trim());
                to.setNum4(arr[5].trim());
                to.setNum5(arr[6].trim());
                to.setNum6(arr[7].trim());
                to.setBonus(arr[8].trim());

                jdbcTemplate.update(sql,
                        to.getDraw_no(),
                        to.getDraw_date(),
                        to.getNum1(),
                        to.getNum2(),
                        to.getNum3(),
                        to.getNum4(),
                        to.getNum5(),
                        to.getNum6(),
                        to.getBonus()
                        );
            }

            System.out.println("LottoDAO inserted successfully");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<LottoTO> getEvenDrawLottoList() {
        String sql = "SELECT draw_no, draw_date, num1, num2, num3, num4, num5, num6, bonus FROM lotto_results WHERE MOD(draw_no, 2) = 0";
        ArrayList<LottoTO> lists = (ArrayList<LottoTO>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LottoTO.class));

        return lists;
    }

    public ArrayList<LottoTO> getOddDrawLottoList() {
        String sql = "SELECT draw_no, draw_date, num1, num2, num3, num4, num5, num6, bonus FROM lotto_results WHERE MOD(draw_no, 2) = 1";
        ArrayList<LottoTO> lists = (ArrayList<LottoTO>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(LottoTO.class));

        return lists;
    }
}
