package com.exam;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkEx02 {
    public static void main(String[] args) {
        // URL (Uniform Resource Locator)
        // http:        - protocol( 전송규약 : Hyper Text Transfer Protocol (Client <- html -> web Server)
        // https:       - http + secure //보안화된 http
        // // - 구분자
        // search.naver.com:445 - ip, port
        // /  - 구분자
        // dir/dirv1/directory/search.naver - 경로, 처리 파일명
        // ? - 구분자
        // where=nexearch&query=starwars&sm=top_hty&fbm=1&ie=utf8 - 쿼리문자열 (옵션값)

        String url = "https://search.naver.com:445/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=HTML+%EC%95%BD%EC%9E%90";
        // protocol / 도메인 / 나머지

//        String[] arrUrls = url.split("/");
//        for (String url1 : arrUrls) {
//            System.out.println(url1);
//        }

        try {
            URL objUrl = new URL(url);
            System.out.println(objUrl.getProtocol());
            System.out.println(objUrl.getHost());
            System.out.println(objUrl.getPort());

            System.out.println(objUrl.getPath());
            System.out.println(objUrl.getQuery());
        } catch (MalformedURLException e) {
            System.out.println("[에러] " + e.getMessage());
        }


    }
}
