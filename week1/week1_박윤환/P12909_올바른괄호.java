package week1_박윤환;

import java.util.*;

class P12909_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;  // 기본 반환값을 true로
        Deque<Character> dq = new ArrayDeque<>();   // ArrayDeque를 Stack으로 사용
        for(int i=0; i<s.length(); i++) {   // 주어진 괄호 문자열을 탐색
            if(s.charAt(i) == '(') {    // 여는 괄호라면
                dq.offer(s.charAt(i));  // stack에 저장
            } else if(s.charAt(i) == ')') { // 닫는 괄호라면
                if(dq.isEmpty()) {  // stack이 비어 있다면 잘못된 괄호 문자열이므로
                    answer = false; // 반환값에 false를 저장하고
                    break;          // break
                } else {            // 비어있지 않다면
                    dq.pollLast();  // stack의 top을 꺼낸다
                }
            }
        }
        if(!dq.isEmpty()) { // 모든 괄호를 탐색하고도 스택에 괄호가 남아있다면 잘못된 괄호 문자열이므로
            answer = false; // 반환값에 false를 저장
        }

        return answer;
    }
}