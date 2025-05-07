package org.example.boot.service;

import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    
    public DatabaseService() {
        System.out.println("DatabaseService() 호출");
    }
}
