package week8.week8_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1063_킹 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		
		String king = st.nextToken(); // 킹 좌표
		String stone = st.nextToken(); // 돌 좌표
		int N = Integer.parseInt(st.nextToken()); // 움직이는 횟수
		
		String[] move = new String[N]; // 움직이는 좌표
		for (int i = 0; i < N; i++) {
			move[i] = bf.readLine();
		} // 입력 완료
		
		int kingX = king.charAt(1)-'0';
		int kingY = king.charAt(0)-'A';
		int stoneX = stone.charAt(1)-'0';
		int stoneY = stone.charAt(0)-'A';
		
		for (int i = 0; i < N; i++) { // 주어진 움직임 횟수만큼
			String str = move[i];
			switch (str) { // 주어진 방향으로 이동
			case "R": // 오른쪽
				if(kingY<7) {
					kingY++;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneY<7) {
							stoneY++;
						}else {
							kingY--;
						}
					}
				}
				break;
			case "L": // 왼쪽
				if(kingY>0) {
					kingY--;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneY>0) {
							stoneY--;
						}else {
							kingY++;
						}
					}
				}
				break;
			case "B": // 아래로
				if(kingX>1) {
					kingX--;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneX>1) {
							stoneX--;
						}else {
							kingX++;
						}
					}
				}
				break;
			case "T": // 위로
				if(kingX<8) {
					kingX++;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneX<8) {
							stoneX++;
						}else {
							kingX--;
						}
					}
				}
				break;
			case "RT": // 오른쪽 위 대각선
				if(kingX<8 && kingY<7) {
					kingX++;
					kingY++;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneX<8 && stoneY<7) {
							stoneX++;
							stoneY++;
						}else {
							kingX--;
							kingY--;
						}
					}
				}
				break;
			case "LT": // 왼쪽 위 대각선
				if(kingX<8 && kingY>0) {
					kingX++;
					kingY--;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneX<8 && stoneY>0) {
							stoneX++;
							stoneY--;
						}else {
							kingX--;
							kingY++;
						}
					}
				}
				break;
			case "RB": // 오른쪽 아래 대각선
				if(kingX>1 && kingY<7) {
					kingX--;
					kingY++;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneX>1 && stoneY<7) {
							stoneX--;
							stoneY++;
						}else {
							kingX++;
							kingY--;
						}
					}
				}
				break;
			case "LB": // 왼쪽 아래 대각선
				if(kingX>1 && kingY>0) {
					kingX--;
					kingY--;
					if(kingY==stoneY && kingX==stoneX) {
						if(stoneX>1 && stoneY>0) {
							stoneX--;
							stoneY--;
						}else {
							kingX++;
							kingY++;
						}
					}
				}
				break;
			}
		} // for end
		
		// 출력
		String kingAns = "";
		kingAns += (char)(kingY+65);
		System.out.println(kingAns+kingX);
		
		String stoneAns = "";
		stoneAns += (char)(stoneY+65);
		System.out.println(stoneAns+stoneX);
		
	}

}
