package week1.week1_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 올바른_괄호 {
    // 프로그래머스용
    boolean solution(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add("(");
            } else {
                if (!stack.isEmpty()) {
                    String ch = stack.pop();
                    if (!ch.equals("(")) {
                        stack.add("(");
                        stack.add(ch);
                    }
                } else {
                    stack.add(")");
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String s = in.readLine(); // 괄호 입력 받기 
		Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') { // 괄호 열기 
        		stack.add("("); // 스택에 넣기 
        	} else {
        		if (!stack.isEmpty()) { // 스택이 비어있지 않다면 
        			String ch = stack.pop(); // 스택 상단 꺼내보기 
        			if (!ch.equals("(")) { // 괄호 열기가 아니라면 
        				stack.add("(");
        				stack.add(ch);
        			}
        		} else { // 스택이 안 비어있으면 넣기 
        			stack.add(")");
        		}
        	}
        }
        if (stack.isEmpty()) {
        	System.out.print(true);
        } else {
        	System.out.print(false);
        }
	}
}

