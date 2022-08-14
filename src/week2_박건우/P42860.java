package week2_박건우;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class P42860 {	// 조이스틱
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_P42860 sol = new Solution_P42860();
		System.out.println(sol.solution("JEROEN"));

	}
}

class Solution_P42860 {
	
    public int solution(String name) {    	
    	int answer = 0;
    	int min = name.length() - 1;
    	
    	int idx;
    	int move = name.length() - 1;
    	
    	for(int i = 0; i < name.length(); i++) {
    		answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
    		
    		idx = i + 1;
    		
    		while(idx < name.length() && name.charAt(idx) == 'A') {
    			idx++;
    		}
    		
    		move = Math.min(move, i * 2 + name.length() - idx);
    		move = Math.min(move, (name.length() - idx) * 2 + i);
    	}
    	
    	return answer + move;
    }
}