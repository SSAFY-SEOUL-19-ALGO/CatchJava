package week1_박윤환;

import java.util.PriorityQueue;

class P42626_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위큐 사용
        for (int n :
                scoville) { // scoville의 값을 순서대로 우선순위큐에 저장
            pq.offer(n);
        }
        while(pq.peek() < K) {  //  우선순위큐의 Front가 K보다 작으면 반복
            if(pq.size() == 1) {    // 우선순위큐의 원소수가 1개이면 더이상 K 이상으로 만들 수 없으므로
                answer = -1;    // 리턴값에 -1을 저장
                break;  // 반복문 탈출
            }
            int min1 = pq.poll();   // 우선순위큐에서 가장 작은 값을 꺼낸다
            int min2 = pq.poll();   // 두번째로 작은 값을 꺼낸다
            int newValue = min1 + (min2 * 2);   // 새로운 스코빌지수 계산
            pq.offer(newValue);     // 새로운 값을 우선순위큐에 새로 넣는다
            answer++;   //  횟수 증가
        }
        return answer;
    }
}