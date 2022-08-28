package week4_채예진;

import java.util.Scanner;

public class 차이를_최대로 {

	static int N;
	static int[] A;
	static int[] numbers;
	static int max;
	
	static void perm(int cnt, int flag) { // 순열 생성 
		if (cnt == N) { // N이 되었을 경우 
			int temp = 0; // 계산 값 
			for (int i = 0; i < N - 1; i++) { // 배열 돌면서 현재값과 다음 값 더해서 계산하기 
				temp += Math.abs(numbers[i] - numbers[i + 1]);
			}
			if (temp > max) max = temp; // 최댓값 업데이트 
			return;
		}
		
		for (int i = 0; i < N; i++) { // 순열 생성 
			if ((flag & 1 << i) != 0) continue; // 이미 사용했으면 
			numbers[cnt] = A[i]; // 값 저장 
			perm(cnt + 1, flag | (1 << i)); // 다음 순열 생성 
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 값이 적기 때문에 Scanner 
		
		N = sc.nextInt(); // 입력 받을 갯수 
		
		A = new int[N]; // N개의 정수로 이루어진 배열 A 
		numbers = new int[N];
		
		for (int i = 0; i < N; i++) { // 배열 값 입력받기 
			A[i] = sc.nextInt();
		}
		
		perm(0, 0); // 순열생성 
		System.out.println(max); // 최댓값 
	}

}
