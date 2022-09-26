package week8.week8_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1722_순열의순서 { // 다 구해서 하면 시간초과 ..
	static int N;
	static boolean[] isSelected;
	static long[] f;
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		numbers = new int[N]; // 1부터 N ..
		isSelected = new boolean[21];
		f = new long[21]; // 팩토리얼을 사용하여 경우의 수를 따지기 위해 ..
		f[0] = 1;
		for (int i = 1; i < 21; i++) {
			f[i] = f[i-1] * i; // 팩토리얼 총 가짓수
		}

		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int check = Integer.parseInt(st.nextToken()); // 소번호 조건 확인
		if(check==1) {
			// 1인 경우
			long th = Long.parseLong(st.nextToken());
			findList(th);
		}else{
			// 2인 경우
			int[] list = new int[N];
			for (int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
  			findTh(list);
		}
		
	}
	
	private static void findList(long th) {
		// 1. 입력받은 숫자번째의 순열을 출력
		for (int i = 0; i < N; i++) { // 팩토리얼 가짓수 가지치기
			for (int j = 1; j <= N; j++) { // 1부터 N 확인
				if(isSelected[j]) continue; // 이미 존재하는 숫자라면
				
				if(f[N-i-1] < th) { // 팩토리얼 값이 주어진 숫자번째보다 작으면
					th -= f[N-i-1];
				}
				else {// 팩토리얼 값이 주어진 숫자보다 크면 해당 원소의 숫자를 찾은 것
					// 해당 자리수에 저장하고 순열에 존재하는 숫자를 체크 !
					numbers[i] = j;
					isSelected[j] = true;
					break;
				}
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(numbers[i]+" ");
		} // 출력
	}
	
	private static void findTh(int[] list) {
		// 2. 해당 순열은 몇번째 순열인지 출력
		long ans = 1L;
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j <list[i]; j++) { // 1부터 해당 원소까지 팩토리얼 값을 늘려가며 더하기 ..
				if(!isSelected[j]) {
					ans += f[N-i-1]; // 기존의 존재하는 순열의 개수를 더해주는 방식으로 ..
				}
			}
			// 순열에 존재하는 숫자라면
			isSelected[list[i]] = true;
		}
		System.out.println(ans); // 출력
	}
}

// 참고 https://dundung.tistory.com/60
