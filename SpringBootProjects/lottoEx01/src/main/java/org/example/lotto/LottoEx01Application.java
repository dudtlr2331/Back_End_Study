package org.example.lotto;

import org.example.lotto.model.LottoDAO;
import org.example.lotto.model.LottoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class LottoEx01Application implements CommandLineRunner {

    @Autowired
    LottoDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(LottoEx01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        dao.insertLotto();
//        ArrayList<LottoTO> lists = dao.getEvenDrawLottoList();
        ArrayList<LottoTO> lists = dao.getOddDrawLottoList();

        for(LottoTO to : lists){
            System.out.printf("[%s회차] [%s] %s %s %s %s %s %s [보너스 %s]\n",
                    to.getDraw_no(), to.getDraw_date(),
                    to.getNum1(), to.getNum2(), to.getNum3(),
                    to.getNum4(), to.getNum5(), to.getNum6(), to.getBonus());
        }
    }
}
