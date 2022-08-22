package week1_박건우;

import java.util.Arrays;
import java.util.Stack;

public class P12906_같은숫자는싫어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution_12906 sol = new Solution_12906();
		int[] arr1 = {1,1,3,3,0,1,1};
		int[] arr2 = {4,4,4,3,3};
		System.out.println(Arrays.toString(sol.solution(arr2)));
	}
}

class Solution_12906 {
    public int[] solution(int[] arr) {
    	int[] answer;
    	if(arr.length == 1)
    		return arr;
    	Stack<Integer> us = new Stack<>();
    	us.add(arr[0]);
    	for(int i = 1;i < arr.length;i++) {
    		if(arr[i] != us.peek())
    			us.add(arr[i]);
    	}
    	answer = new int[us.size()];
    	for(int i = answer.length-1; i >= 0; i--)
    		answer[i] = us.pop();
    	return answer;
    }
}

