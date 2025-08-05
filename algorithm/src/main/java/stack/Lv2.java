package stack;

import java.util.Stack;

public class Lv2 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if(s.charAt(0) == ')') {
            return false;
        }

        try {
            for (char ch : s.toCharArray()) {
                if (ch == '(') { // 여는 괄호는 스택에 추가
                    stack.push(ch);
                }else {
                    stack.pop();
                }
            }
        } catch (Exception e) {
            return false;
        }


        return stack.size() == 0 ? true : false;
    }
}
