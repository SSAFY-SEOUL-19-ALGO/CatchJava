package week1.week1_박건우;

import java.util.Stack;

public class P12909 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_12909 sol = new Solution_12909();
		System.out.println(sol.solution("()()"));
	}
}

class Solution_12909 {
    boolean solution(String s) {
        Stack<Character> cs = new Stack<>();
        for(int i = 0; i < s.length();i++) {
        	switch(s.charAt(i)) {
        	case '(':
        		cs.add(s.charAt(i));
        		break;
        	case ')':
        		if(cs.isEmpty())
        			return false;
        		else if(cs.pop() != '(')
        			return false;
        	}
        }
        if(!cs.isEmpty())
        	return false;
        else
        	return true;    
    }
}