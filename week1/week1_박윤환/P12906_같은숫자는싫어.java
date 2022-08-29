package week1_박윤환;

import java.util.*;

public class P12906_같은숫자는싫어 {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();  // ArrayDeque를 Stack으로 사용
        for(int i=0; i<arr.length; i++) {   // 주어진 배열 탐색
            // Stack의 Top이 null(비어있음)이거나 현재 숫자가 아니라면 Stack에 숫자 저장
            if (deque.peekLast() == null || deque.peekLast() != arr[i]) {
                deque.offer(arr[i]);
            }
        }
        // 람다식으로 ArrayDeque를 배열로 변환
        int[] answer = deque.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}