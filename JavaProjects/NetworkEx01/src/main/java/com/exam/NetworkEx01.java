package com.exam;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkEx01 {
    public static void main(String[] args) {
        try {
            // localhost
            InetAddress inetAddress1 = InetAddress.getLocalHost();  //로컬 IP가 나온다.
            System.out.println(inetAddress1.getHostAddress());
            System.out.println(inetAddress1.getHostName());

            //remote
            InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");
            for(InetAddress inetAddress : inetAddresses){
                System.out.println(inetAddress.getHostAddress());
                System.out.println(inetAddress.getHostName());
            }

        } catch (UnknownHostException e) {
            System.out.println("[에러] " + e.getMessage());
        }
    }
}
