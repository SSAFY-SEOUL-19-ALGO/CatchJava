package week1_정원철;

import java.util.Stack;

public class Lv2_올바른괄호 {
    public static boolean solution(String s) {

    	Stack<Character> test= new Stack<>();
    	boolean answer=true;
    	for(int i=0; i<s.length(); i++) { 

    		// 여는 괄호는 스택에 저장
    		if (s.charAt(i)=='(') {
    			test.push(s.charAt(i));
    		// 스택이 비어있지않고, 닫는 괄호라면 스택에 쌓여있는 여는 괄호를 삭제
    		}else if (test.isEmpty()==false && s.charAt(i)==')' ) {
    			test.pop();
    		// 닫는 괄호가 나오고 스택에 저장된 값이 하나도 없이 비어있다면 괄호가 유효하지 않음
    		}else {
    			return false;
    		}
    	}
    	
    	
    	// 스택에 마지막으로 쌓여있는 값을 확인하여 남아있으면 x, 비어있으면  o
    	if(test.isEmpty()) {
    		answer=true;
    	}else {
    		answer=false;
    	}
    	return answer;

    }
	public static void main(String[] args) {
		String s="(()(";
		String s1=")()(";
		
		System.out.println(solution(s1));

	}

}
