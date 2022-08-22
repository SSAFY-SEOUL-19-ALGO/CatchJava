package week3_정원철;

public class Lv2_타겟넘버 {
	
	static int numbers[];
	static int target, answer=0;
	
	
	
	static void dfs(int idx, int sum) { // (시작인덱스, 누적합)
		//기저조건
		if(idx==numbers.length) {
			//sum이 타겟과 같다면 ++
			if(sum==target) answer++;
			return;
		}
		
		
		
		// 더하는 경우 
		dfs(idx+1,sum+numbers[idx]);
		// 빼는 경우
		dfs(idx+1,sum-numbers[idx]);
	}
	
	
	static int solution(int[] numbers, int target) {

	
		dfs(0,0);
	
	 return answer;

	 }
	public static void main(String[] args) {

		numbers=new int[]{1, 1, 1, 1, 1};
		target=3;
		System.out.println(solution(numbers, target));

	}

}
