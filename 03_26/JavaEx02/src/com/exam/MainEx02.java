package com.exam;

public class MainEx02 {
    public static void main(String[] args) {
        System.out.println("입력 데이터 갯수 : " + args.length);

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        for(String str : args){
            System.out.println(str);
        }
    }
}
