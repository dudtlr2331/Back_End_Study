package org.example.restweb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @GetMapping("/request")
    public String get() {
        //emp table 조회
        
        return "get";
    }

    @PostMapping("/request")
    public String post() {
        //emp table 입력

        return "post";
    }

    @PutMapping("/request/{empno}")
    public String put(@PathVariable int empno) {
        //emp table 수정
         return "put";
    }

    @DeleteMapping("/request/{empno}")
    public String delete(@PathVariable int empno) {
        //emp table 삭제
        return "delete";
    }
}
