package stack;

import java.util.*;

public class Lv1 {
    public Stack<Integer> solution1(int[] arr){
        Stack<Integer> stack = new Stack<>();

        for(int num : arr) {
            if(stack.size() == 0 || stack.peek() != num) {
                stack.add(num);
            }
        }

        return stack;
    }
}
