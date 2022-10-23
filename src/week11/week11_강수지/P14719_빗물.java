package week11.week11_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14719_빗물 {
	static int[] block;
	static int H,W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s[] = bf.readLine().split(" ");
		H = Integer.parseInt(s[0]); // 세로
		W = Integer.parseInt(s[1]); // 가로
		
		block = new int[W]; // 블록
		String s2[] = bf.readLine().split(" ");
		for (int i = 0; i < W; i++) { // 블록의 높이
			block[i] = Integer.parseInt(s2[i]);
		} // 입력 완료
		
		// 초기화 
		int rain  = 0;
		
		for (int i = 1; i < W-1; i++) { // 첫번째 블록과 마지막 블록 양쪽 끝은 물을 채울 수 없다 !
			int left = 0;
			int right = 0;
			// 왼쪽 가장 높은 기둥
			for (int j = 0; j < i; j++) {
				left = Math.max(left, block[j]);
			}
			// 오른쪽 가장 높은 기둥
			for (int j = i+1; j < W; j++) {
				right = Math.max(right, block[j]);
			}
			// 높은 건물들 중 더 작으 최대갑 ! 건물과 건물 사이에 빗물이 고인다 !
			if(block[i]<left && block[i]<right) {
				rain += Math.min(left, right) - block[i];
			}
		}
		System.out.println(rain);
	}

}
