package org.solution20;

import org.junit.Test;

import java.util.Stack;

public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char a = 'a';
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (!stack.empty()){
                a = switch (c) {
                    case ')' -> '(';
                    case ']' -> '[';
                    case '}' -> '{';
                    default -> 'a';
                };
                if (a != stack.pop()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.empty();
    }
    @Test
    public void Test(){
        System.out.println(isValid("()"));
    }
}
