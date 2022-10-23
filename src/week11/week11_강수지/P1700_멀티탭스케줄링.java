package week11.week11_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1700_멀티탭스케줄링 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s[] = bf.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 멀티탭 구멍의 수
		int K = Integer.parseInt(s[1]); // 전기용품 총 사용 횟수
		
		int[] elect = new int[K]; // 전기 용품 총 사용 횟수
		String s2[] = bf.readLine().split(" ");
		for (int i = 0; i < K; i++) {
			elect[i] = Integer.parseInt(s2[i]);
		} // 입력완료
		
		int cnt = 0; // 플러그를 빼는 최소의 횟수
		int use = 0; // 사용중인 플러그 개수
		boolean[] used = new boolean[K+1]; // 전기용품 1번 부터 시작함 
		
		
		for (int i = 0; i < K; i++) {
			if(used[elect[i]]==true) continue; // 사용중이라면 넘어감
			
			else { // 사용중이 아니라면
				if(use<N) { // 멀티탭의 빈칸이 있는 경우
					used[elect[i]] = true;
					use++;
				} else { // 멀티탭이 꽉찬경우 : 사용중인 애들중에 뽑을 애를 찾자
					int[] tmp = new int[K+1];
					for (int j = 1; j < K+1; j++) {
						if(used[j]==true) { // 사용중이 애들 표시
							tmp[j] = Integer.MAX_VALUE;
						}
					}
					for (int j = i+1; j < K; j++) {
						if(tmp[elect[j]]==Integer.MAX_VALUE) {
							tmp[elect[j]] = j;
						}
					}
					int off = 0;// 뽑을 친구
					for (int j = 1; j < K+1; j++) {
						if(tmp[j]>tmp[off]) {
							off = j;
						}
					}
					used[off] = false;
					cnt++;
					used[elect[i]] = true;
				}
			}
		}
		System.out.println(cnt);
	}

}
