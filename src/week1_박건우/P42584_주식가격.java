package week1_박건우;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P42584_주식가격 {
	public static void main(String[] args) {
		Solution_42584 sol = new Solution_42584();
		int[] arr1 = {1, 2, 3, 2, 3};
		System.out.println(Arrays.toString(sol.solution(arr1)));
	}
}

class Solution_42584 {
    public int[] solution(int[] prices) {
    	int[] answer = new int[prices.length];
    	int sec = 0, cnt = 0, price = 0;
    	answer[answer.length-1] = 0;
    	for(int i = 0; i < prices.length - 1; i++) {
    		price = prices[i];    		
    		for(int j = i+1; j < prices.length;j++) {
    			if(price <= prices[j])
    				cnt++;
    			else {
    				cnt++;
    				break;
    			}
    		}
    		sec += cnt;
    		answer[i] = sec;
    		cnt = 0;
			sec = 0;
    	}
    	return answer;
    }
}
