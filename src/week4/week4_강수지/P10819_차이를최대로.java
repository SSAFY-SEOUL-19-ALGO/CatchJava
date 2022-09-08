package week4.week4_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10819_차이를최대로 {
	static boolean[] visited;
	static int[] input;
	static int[] nums;
	static int N;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine()); //입력받을 숫자
		input = new int[N]; // 입력되는 숫자를 담을 배열
		nums = new int[N]; // 만들어지는 순열을 담을 배열
		visited = new boolean[N];
		
		String[] s = bf.readLine().split(" ");
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(s[i]);
		}
		// 처음에 정렬해야되나 했지만 ... 그냥 모든 경우의 수를 구해서 최대값 구하기로 바꿈 !
		perm(0);
		System.out.println(ans);
	}

	private static void perm(int cnt) {
		if(cnt==N) {
			int sum = 0;
			for(int i=0;i<N-1;i++) {
				sum += Math.abs(nums[i]-nums[i+1]);
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) { // 사용하지 않은 숫자면
				nums[cnt] = input[i];
				visited[i] = true; // 사용처리
				
				perm(cnt+1);
				visited[i] = false;// 재사용을 위해
			}
		}
	}
	
	

}
