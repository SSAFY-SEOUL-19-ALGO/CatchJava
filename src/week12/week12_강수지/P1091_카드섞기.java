package week12.week12_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1091_카드섞기 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		int[] P = new int[N]; // 카드 섞기전의 처음 카드 순서
		int[] card = new int[N]; // 섞어나갈 카드 보관 .. 
		
		String s1[] = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(s1[i]);
			card[i] = P[i];
		}
		
		int[] S = new int[N]; // 카드 섞는 방법
		String s2[] = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(s2[i]);
		}
		// 입력완료

		int cnt = 0; // 몇 번 섞어야 하는지
		
		while(true) {
			if(possible(card)) break;  // 섞어도 섞어도 카드를 줄수없는 경우 ..
			
			change(card, S); // 섞기
			cnt++;
			
			if(same(P, card)) { // 같은 경우
				cnt= -1;
				break;
			}
		}

		System.out.println(cnt);
		
	}
	
	private static void change(int[] P, int[] S) { // i 번째 위치 카드를 s[i] 위치로 이동
		int[] tmp = new int[N];
		
		for (int i = 0; i < N; i++) {
			tmp[S[i]] = P[i];
		}
		
		for (int i = 0; i < N; i++) {
			P[i] = tmp[i];
		}
		tmp = null;
	}

	private static boolean possible(int[] card) { // 섞어도 섞어도 카드를 줄수없는 경우 ..
		for (int i = 0; i < N; i++) {
			if(card[i] != i%3) return false;
		}
		return true;
	}
	
	private static boolean same(int[] P, int[] card) { // 같은지 다른지 확인
		for (int i = 0; i < N; i++) {
			if(P[i]!=card[i]) return false;
		}
		return true;
	}

}
