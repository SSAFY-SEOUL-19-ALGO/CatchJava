package week3.week3_강수지;

import java.util.*;

public	class P43165_타켓넘버 {
    static int answer;
    
        public void dfs(int[] numbers, int target, int idx, int sum){
            if(idx==numbers.length){ // 모든 정수를 탐색 ..
                if(sum==target) answer++; // 만약 누적합이 target과 같은 경우
                return;
            }

            // 다른 경우 더하기랑 빼기를 비교 ..
            sum += numbers[idx];
            dfs(numbers, target, idx+1, sum);
            sum -= numbers[idx]; // 원상태로 돌린 후 빼는 경우 고려 !

            sum +=  (-1* numbers[idx]);
            dfs(numbers, target, idx+1, sum);
    }
    
    public int solution(int[] numbers, int target) {
        // numbers 를 더하고 빼며 target 을 만들자 !
        answer = 0;
        
        dfs(numbers, target, 0,0);
        
        return answer;
        } // solution end
}

// test case 만 맞은 ..
// // numbers 를 더하고 빼며 target 을 만들자 !
// int answer = 1;

// Queue<Integer> q = new ArrayDeque<>(); // 더하기 빼기 모두 ..
// q.add(numbers[0]); // 가장 처음 값을 넣고 시작

// boolean[] visited = new boolean[1001];
// int[] cnt = new int[1001];

// while(!q.isEmpty()){
//	     int tmp = q.poll();
//	     visited[tmp] = true;

//	     if(tmp == target){
//	         for(boolean e: visited){
//	             if(e==true)
//	              answer += 1;
//	         } // 찾고자 한 값인 경우 !
//	     }

//	      if(tmp-1>=0 && !visited[tmp-1]){ // 빼기의 경우
//	         cnt[tmp-1] = cnt[tmp]+1;
//	         visited[tmp-1] = true;
//	         q.offer(tmp-1);
//	     }
//	     if(tmp+1<1001 && !visited[tmp+1]){ // 더하기의 경우
//	         cnt[tmp+1] = cnt[tmp]+1;
//	         visited[tmp+1] = true;
//	         q.offer(tmp+1);
//	     }
	// }
	// return answer;

