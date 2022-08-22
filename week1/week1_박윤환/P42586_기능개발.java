package week1_박윤환;

import java.util.*;

class P42586_기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> dq = new ArrayDeque<>();     // ArrayDeque를 Queue로 사용
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++) {
            // 작업일수 = (100 - 작업진도) / 작업속도  -> 큐에 저장
            dq.offer((int)Math.ceil((100 - progresses[i]) / (double)speeds[i]));
        }
        int first = dq.poll(); // 첫번째 작업의 작업일수
        int cnt = 1;    // 배포되는 기능 개수
        while(!dq.isEmpty()) {  // 큐가 비어있지 않는 동안 반복
            if(first >= dq.peek()) {    // 큐의 front가 첫 작업일수보다 같거나 작으면
                dq.poll();              // 같이 배포하기 위해 꺼냄
                cnt++;                  // 배포하는 기능 개수 증가
            } else {                    // 그렇지 않은 경우
                list.add(cnt);          // 여태까지 배포가능한 기능의 개수를 리스트에 저장
                first = dq.poll();      // 다음 작업일수를 새로운 첫 작업일수로
                cnt = 1;                // 배포하는 기능 개수를 1개로 초기화
            }
        }
        list.add(cnt);  // 마지막으로 배포하는 기능 개수를 리스트에 저장
        // 람다식으로 리스트를 배열로 변환
        answer = list.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}