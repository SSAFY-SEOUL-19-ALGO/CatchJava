package week3_박건우;

public class P43165_타겟넘버 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution_43165 {
	int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int sum) {
    	if(depth == numbers.length) {
    		if(target == sum) answer++;
    	} else {
    		dfs(numbers, depth + 1, target, sum + numbers[depth]);
    		dfs(numbers, depth + 1, target, sum - numbers[depth]);
    	}
    }
}