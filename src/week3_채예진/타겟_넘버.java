package week3_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 타겟_넘버 {

	static int answer;
    public static int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int index, int sum) {
    	if (index == numbers.length) { // 배열을 전부 탐색했을 때 
    		if (sum == target) answer++; // 트리 리프에 도착했을 때 계산된 값과 타겟 값 비교 
    		return;
    	}
    	
    	dfs(numbers, target, index + 1, sum + numbers[index]); // 왼쪽 노드 탐색 
    	dfs(numbers, target, index + 1, sum - numbers[index]); // 오른쪽 노드 탐색 
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int[] numbers = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			numbers[i] = Integer.parseInt(s[i]);
		}
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(solution(numbers, target));
	}

}
