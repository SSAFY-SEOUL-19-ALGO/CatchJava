package week3_김영서;

public class p43165_타겟넘버 {
	static int cnt;
	//static int[] numbers;

	public static void main(String[] args) {
		int[]num={1,1,1,1,1};
		System.out.println(solution(num,3));
	}
	
	static void dfs(int[] numbers, int target, int idx, int sum) {
		// 인덱스가 numbers의 전체 길이와 같으면 순회가 끝남. 빠져나오기!!! 
		if (idx == numbers.length) {
			//target과 sum이 같으면 cnt증가
			if (sum == target) {
				System.out.println(sum+" "+idx);
				cnt++;
			}
		} else {
			// 더하는 경우와 빼는 경우 다 생각해보기
			//numbers[idx] *= 1;
			dfs(numbers, target, idx+1,sum + numbers[idx]);
			//numbers[idx] *= -1;
			dfs(numbers, target, idx+1,sum - numbers[idx]);

		}
	}

	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0,0);
		//총 cnt보여주기
		return cnt;
	}
}