package week5_채예진;

import java.util.Scanner;
import java.util.Stack;

public class 동전0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Stack<Integer> stack = new Stack<>();
		for (int n = 0; n < N; n++) {
			stack.add(sc.nextInt());
		}
		
		int answer = 0;
		while (!stack.isEmpty()) {
			Integer i = stack.pop();
			
			if (K < i) continue; // 빼낸 값이 더 클 경우 
			
			answer += K / i; // 몫은 동전 개수 
			K %= i; // 남은 금액 
		}
		
		System.out.println(answer);
	}

}
