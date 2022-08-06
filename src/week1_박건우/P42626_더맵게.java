package week1_박건우;

import java.util.PriorityQueue;

public class P42626_더맵게 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] arr = {1, 2, 3};	// 예시
		System.out.println(sol.solution(arr, 14));	// 예시
	}

}

class Solution_42626 {
	public boolean check(PriorityQueue<Integer> pq, int K) {
		while(pq.size() > 0) {
			if(pq.peek() < K) {
				return false;
			} else
				return true;
		}
		return true;
	}
	
    public int solution(int[] scoville, int K) {
    	int sco = 0, answer = 0;
    	PriorityQueue<Integer> mh = new PriorityQueue<>();
    	for(int food:scoville) {
			mh.offer(food);
		}
    	
    	while(mh.peek() < K) {
    		if(mh.size() == 1)
    			return -1;
    		
    		sco = mh.poll() + (2 * mh.poll());
    		mh.offer(sco);
    		answer++;
    	}
    	
    	
        return answer;
    }
}
