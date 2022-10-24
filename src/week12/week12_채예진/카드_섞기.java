package week12.week12_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드_섞기 {

	static int N;
	static int[] P;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] card = new int[N];
		int[] copy = new int[N];
		
		// 초기상태 0, 1, 2 순서대로 저장 
		for (int i = 0; i < N; i++) {
			card[i] = i % 3;
		}
		
		int count = 0;
		while (true) {
			System.out.println(Arrays.toString(card));
			boolean check = check(card);
			if (check) { // P와 같아졌을 경우 
				System.out.println(count);
				return;
			} 
			
			if (count != 0 && first(card)) { // 처음과 같을 경우 
				System.out.println(-1);
				return;
			}
			
			for (int i = 0; i < N; i++) {
				copy[i] = card[S[i]]; // 이걸 반대로 써서 꽤 걸림ㅠㅠ
			}
			
			count++;
			card = copy.clone();
		}
	}
	
	static boolean check(int[] card) {
		for (int i = 0; i < N; i++) {
			if (card[i] != P[i]) return false;
		}
		return true; // P와 같을 경우 s
	}

	static boolean first(int[] card) {
		for (int i = 0; i < N; i++) { // 처음과 같을 경우  
			if (card[i] != i % 3) return false;
		}
		return true;
	}
}
