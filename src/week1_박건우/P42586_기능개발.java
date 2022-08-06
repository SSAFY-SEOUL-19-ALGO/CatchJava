package week1_박건우;

import java.util.ArrayList;
import java.util.Arrays;

public class P42586_기능개발 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_42586 sol = new Solution_42586();
		int[] prog1 = {93, 30, 55};
		int[] speed1 = {1, 30, 5};
		System.out.println(Arrays.toString(sol.solution(prog1, speed1)));
	}
}

class Solution_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
    	ArrayList<Integer> answer = new ArrayList<>();
    	int idx = 0, fin = 0;
    	
    	while(idx < progresses.length) {
    		while(idx < progresses.length && progresses[idx] >= 100) {
	    		idx++;
	    		fin++;
	    	}
   
    		if(fin > 0) {
    			answer.add(fin);
    			fin = 0;
    		}
    		 		
    		for(int i = speeds.length-1;i >= 0; i--) {
    			progresses[i] += speeds[i];
    		}    		    		    	
    	}
        return answer.stream().mapToInt(Integer::intValue).toArray();	// ArrayList를 정수 배열로 변환하여 리턴하기
    }
}