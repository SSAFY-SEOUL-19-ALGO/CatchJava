package week8.week8_채예진;

import java.util.Scanner;

// 2번 
// 4 3 1 2 가 들어왔다고 했을 때. 
// 1XXX -> 3!, 2XXXX -> 3!, 3XXXX -> 3!
// 41XX -> 2!, 42XX -> 2!
// 431X -> 1!
// 1은 반대로 구하기 
// N = 4, 8번째라고 했을 경우 
// 1XXX -> 3! = 6
// 2XXX에서 답을 찾게 됨. 21XX -> 4!
// 213X -> 1! 작으니까 214X에서 멈추고, 2143이라는 결과 나옴 
public class 순열의_순서 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = sc.nextInt();
		
		boolean[] isSelected = new boolean[N + 1];
		
		long[] f = new long[21]; // 20!까지 저장 
		f[0] = 1;
		
		// 팩토리얼 구하기  
		for (int i = 1; i <= 20; i++) {
			f[i] = f[i - 1] * i;
 		}

		if (num == 1) {
			long k = sc.nextLong(); // k는 N!이므로 long으로 받아야한다. 
			int[] answer = new int[N];
			// 순열 
			for (int i = 0; i < N; i++) { // 배열 크기 만큼 
				for (int j = 1; j <= N; j++) { // 1부터 확인 
					if (isSelected[j]) continue;
					if (f[N - i - 1] < k) {
						k -= f[N - i - 1]; // 지나친 순서라는 의미 
					} else { // 크거나 같을 경우에는 해당 값 안에 정답이 있다는 의미 
						isSelected[j] = true;
						answer[i] = j;
						break; // 다음 배열 확인 
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				System.out.print(answer[i] + " ");
			}
		} else if (num == 2) { // 몇 번째인지 
			int[] arr = new int[N];
			long answer = 0;
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int i = 0; i < N; i++) { // 입력받은 배열 
				for (int j = 1; j < arr[i]; j++) { // 1부터 해당하는 원소까지 팩토리얼 값을 늘려주면서 더해주기 
					if (isSelected[j]) continue; // 이미 선택했을 경우 
					// 아직 선택하지 않았을 경우에는 순서 증가 
					answer += f[N - i - 1];
				}
				isSelected[arr[i]] = true; // 선택함 
			}
			
			System.out.println(answer + 1);
		}
	}
}

/*
// 일반 순열로 풀면 시간 초과 
public class 순열의_순서 {

	static int numCnt;
	static int[] numbers;
	static boolean[] isSelected;
	static boolean check;
	
	// 순열 
	static void perm(int cnt, int num, int N, int k) {
		if (cnt == N) {
			numCnt++;

			if (numCnt == k) { // k 번째 순열일 경우 
				for (int i = 0; i < numbers.length; i++) {
					System.out.print(numbers[i] + " ");
				}
				System.out.println();
				check = true;
			}
			
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (check) break; // k번째 순열을 이미 출력한 경우 for문 나가기 
			
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1, num, N, k);
			isSelected[i] = false;
		}
	}
	
	// 순열 
	static void perm(int cnt, int num, int N, int[] arr) {
		if (cnt == N) {
			numCnt++;
					
			// 입력받은 배열과 동일한지 확인, 동일하면 출력, 그렇지 않으면 다음 순열 찾기 해야함 
			for (int i = 0; i < numbers.length; i++) {
				if (arr[i] != numbers[i]) {
					check = false;
					break;
				} else {
					check = true;
				}
			}
				
			if (check) {
				System.out.println(numCnt);
			}
				
			return;
		}
			
		for (int i = 1; i <= N; i++) {
			if (check) break; // k번째 순열을 이미 출력한 경우 for문 나가기 
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			perm(cnt + 1, num, N, arr);
			isSelected[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int num = sc.nextInt();
		
		// 변수 초기화 
		numCnt = 0;
		numbers = new int[N];
		isSelected = new boolean[N + 1];
		check = false;
		
		if (num == 1) {
			int k = sc.nextInt();
			// 순열 
			perm(0, 1, N, k);
		} else if (num == 2) {
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			perm(0, 2, N, arr);
		}
	}
}
*/