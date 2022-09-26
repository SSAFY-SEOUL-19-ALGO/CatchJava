package week8.week8_채예진;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 국회의원선거 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int dasom = sc.nextInt();
		
		if (N == 1) { // 다솜 단일 후보 
			System.out.println(0);
			return;
		}
		
		PriorityQueue<Integer> candidate = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N - 1; i++) {
			candidate.offer(sc.nextInt());
		}
		
		int cnt = 0;
		// 다솜이가 매수해야하는 사람 
		while(!candidate.isEmpty()) {
			int cur = candidate.poll();

			if (dasom > cur) { // 당선. 
				System.out.println(cnt);
				break;
			} else if (dasom == cur) { // 값이 같을 경우에는 한 사람을 매수해야 당선됨 
				System.out.println(++cnt);
				break;
			} else {	
				cur--;
				dasom++;
				cnt++;
				if (cur != 0) candidate.offer(cur);
			}
		}
	}
}
