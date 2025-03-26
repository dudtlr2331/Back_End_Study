package com.exam;

import com.data.Child1;
import com.data.Child2;
import com.data.Parent;

public class MainEx01 {
    public static void main(String[] args) {
        Child1 child1 = new Child1();
        Child2 child2 = new Child2();

        child1.viewParent();
        child2.viewParent();
    }
}
