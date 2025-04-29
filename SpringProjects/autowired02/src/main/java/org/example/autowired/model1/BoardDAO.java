package org.example.autowired.model1;

import org.springframework.stereotype.Repository;

@Repository(value = "dao")
public class BoardDAO {

    public BoardDAO() {
        System.out.println("BoardDAO() 호출");
    }
}
