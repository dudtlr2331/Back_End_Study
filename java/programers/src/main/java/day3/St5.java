package day3;

import com.sun.jdi.Value;

import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class St5 {
    public String solution(String letter) {
        String answer = "";
        String[] word = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for(int i=0; i<word.length; i++){
            for(int j=0; j<morse.length; j++){
                if(word[i].equals(morse[j])) answer+=(char)(j + 97);
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

    }
}
