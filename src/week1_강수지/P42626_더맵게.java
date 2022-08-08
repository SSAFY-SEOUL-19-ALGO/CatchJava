package week1_강수지;

import java.util.*;

public class P42626_더맵게 {
	public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<scoville.length;i++){
            q.add(scoville[i]);
        } // 그냥 배열 정렬하면 시간초과 .. 우선순위 큐 방식으로 구현 !
        
        while (q.size()>1){
            int tmp = q.poll() + q.poll()*2;
            q.add(tmp);
            answer++;
            if (q.peek()>=K){
                break;
            }
        }
        if(K>q.peek()){
            return -1;
        }
        
        return answer;
    }
}
