package org.example.zipcode;

import org.example.zipcode.model.ZipcodeDAO;
import org.example.zipcode.model.ZipcodeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class ZipcodeEx01Application implements CommandLineRunner {

    @Autowired ZipcodeDAO dao;

    public static void main(String[] args) {
        SpringApplication.run(ZipcodeEx01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ArrayList<ZipcodeTO> lists = dao.listZipcode("개포동");

        for(ZipcodeTO to : lists){
            System.out.printf("[%s] %s %s %s %s %s\n",
                    to.getZipcode(), to.getSido(), to.getGugun(), to.getDong(), to.getRi(), to.getBunji());
        }
    }
}
