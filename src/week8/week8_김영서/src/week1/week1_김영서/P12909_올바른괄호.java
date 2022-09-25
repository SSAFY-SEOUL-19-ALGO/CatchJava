package week1.week1_김영서;
import java.util.Stack;

class P12909_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
        	//answer가 false면 더 보지 말고 for문 빠져나가기
        	if(answer == false)break;
        	
        	switch(s.charAt(i)) {
        	case '(':
            	stack.add('(');
        		break;
        	case')':
        		if(stack.isEmpty()||stack.pop()!='(') {
            		answer=false;
            		break;
        		}else {
        			break;
        		}
        	}//switch
        	
        }
        //스택에 남아 있는게 있다면 false
        if(!stack.isEmpty()) {
        	answer = false;
        }
        return answer;
    }
}
