package com.github.weiranyi;

/**
 * @author: https://github.com/weiranyi
 * @description
 * @date: 2021/4/10 9:25 下午
 * @Version 1.0
 */
public class Solution {

    public boolean isValid(String s) {

//        import java.util.Stack;
//        Stack<Character> stack = new Stack<>();
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;

                char topChar = stack.pop();
                if (c == ')' && topChar != '(')
                    return false;
                if (c == ']' && topChar != '[')
                    return false;
                if (c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
