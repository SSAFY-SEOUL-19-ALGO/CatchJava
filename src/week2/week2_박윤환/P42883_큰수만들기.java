package week2.week2_박윤환;

import java.util.ArrayDeque;

public class P42883_큰수만들기 {
    public String solution(String number, int k) {
        int N = number.length();    // 주어진 숫자의 자리수
        int R = N - k;      // 남겨야 하는 자리수
        StringBuilder answer = new StringBuilder(); // 선택된 숫자를 저장할 StringBuilder
        ArrayDeque<Integer> dq = new ArrayDeque<>();    // 선택 숫자를 저장할 스택

        for(int i=0; i<N; i++) {    // 숫자 탐색
            int num = number.charAt(i) - '0';
            while(!dq.isEmpty() && k>0) {   // 스택이 비어있지 않고 k가 0보다 크면 반복
                int top = dq.peek();
                if(top < num) {     // stack의 top이 이번 숫자보다 작으면
                    dq.pop();   // stack을 pop하고
                    k--;    // k는 1 감소
                } else {    // top이 더이상 작지 않으면 break;
                    break;
                }
            }
            dq.push(num);   // 현재 숫자를 stack에 push
        }
        while(k-- > 0) dq.pop();  // 숫자를 전부 탐색하고도 k가 남았다면 그 수만큼 pop

        while(!dq.isEmpty()) {
            answer.append(dq.pollLast());   // 남은 stack의 숫자를 stack의 반대순서로 정렬
        }

        return answer.toString();
    }

}
