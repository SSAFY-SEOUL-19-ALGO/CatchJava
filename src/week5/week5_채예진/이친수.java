package week5.week5_채예진;

import java.util.Scanner;

// 피보나치수로 풀기 : d[n] = d[n - 2] + d[n - 1]
// 3일 경우 : 100, 101
// 4일 경우 : 1/000, 1/001, 1/010
// 5일 경우 : 10/100, 10/101, 10/000, 10/001, 10/010 -> 3의 뒷자리와 4의 뒷자리를 합친 값의 개수 
public class 이친수 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long[] numbers = new long[N + 1]; // 90자리 수까지 가능해야하기 때문에 long으로 풀기 
		numbers[0] = 0;
		numbers[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			numbers[i] = numbers[i - 2] + numbers[i - 1];
		}
		
		System.out.println(numbers[N]);
	}

}

/* 순열 - 메모리 초과 
	static int answer;
	static int N;
	static int[] numbers;
	static Set<String> set;
	static void perm(int before, int index, int cnt) {
		if (cnt == N) {
			String sb = Arrays.toString(numbers);
			set.add(sb);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (numbers[before] == 1)
				perm(before + 1, index + 1, cnt + 1);
			else {
				numbers[index] = 1;
				perm(before + 1, index + 1, cnt + 1);
				numbers[index] = 0;
				perm(before + 1, index + 1, cnt + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		numbers = new int[N];
		numbers[0] = 1;
		
		set = new HashSet<>();
		perm(0, 1, 1);
		System.out.println(set.size());
	}

*/