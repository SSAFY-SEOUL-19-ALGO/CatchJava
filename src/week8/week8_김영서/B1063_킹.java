package week8.week8_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1063_킹 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		String horse, stone, togo;
		horse = arr[0];
		stone = arr[1];
		char hr = horse.charAt(0);
		// char hc=horse.charAt(1);//Character.getNumericValue(hc)
		int hc = Character.getNumericValue(horse.charAt(1));
		char sr = stone.charAt(0);
		int sc = Character.getNumericValue(stone.charAt(1));
		for (int i = Integer.parseInt(arr[2]); i > 0; i--) {
			togo = br.readLine();
			switch (togo) {
			case "R":
				// 말이 오른쪽으로 이동 할 수 있고
				if (hr < 'H') {
					// 돌이 오른쪽 끝에 있고, 말과 같은 열에있고, 말이 오른쪽으로 이동하는 경우엔 갈 수 없다.
					if (!(hr + 1 == sr && sr == 'H' && hc == sc)) {
						// 아니면 말 이동 가능!
						hr += 1;
						// 돌이 말의 오른쪽 옆에 있으면 돌도 이동
						if (hr== sr && hc == sc) {
							sr += 1;
						}
					}
				}
				break;
			case "L":
				// 말이 왼쪽으로 이동 할 수 있고
				if (hr > 'A') {
					// 돌이 왼쪽 끝에 있고, 말과 같은 열에있고, 말이 왼쪽으로 이동하는 경우엔 갈 수 없다.
					if (!(hr - 1 == sr && sr == 'A' && hc == sc)) {
						// 아니면 말 이동 가능!
						hr--;
						// 말이 이동했는데 돌이랑 겹치면 밀어내기
						if (hr== sr && hc == sc) {
							sr--;
						}
					}
				}
				break;
			case "B":
				// 말이 아래로 이동 할 수 있고
				if (hc > 1) {
					// 돌이 바닥에 있고, 말과 같은 행에있고, 말이 아래로 이동하는 경우엔 갈 수 없다.
					if (!(hc - 1 == sc && sc == 1 && hr == sr)) {
						// 아니면 말 이동 가능!
						hc--;
						// 돌이 말의 아래에 있으면 돌도 이동
						if (hc == sc && hr == sr) {
							sc--;
						}
					}
				}
				break;
			case "T":
				// 말이 위로 이동 할 수 있고
				if (hc < 8) {
					// 돌이 바닥에 있고, 말과 같은 행에있고, 말이 아래로 이동하는 경우엔 갈 수 없다.
					if (!(hc + 1 == sc && sc == 8 && hr == sr)) {
						// 아니면 말 이동 가능!
						hc++;
						//System.out.println(hc==sc);
						//System.out.println(hr==sr);
						//System.out.println(hc+" "+hr+" "+sc+" "+sr+" ");
						// 돌이 말의 위에 있으면 돌도 이동
						if (hc == sc && hr == sr) {
							sc++;
						}
					}
				}
				break;
			case "RT":
				if (hc < 8 && hr < 'H') {
					// (1)hc가 8에 있을 경우
					// (2)hr이 H에 있을 경우 =>위에서 체크

					// (3)hc이 7행 sc이 8행, hr+1=sr 가 아니고
					// (4)hr이 g, sr이 h, hc+1=sc 가 아니면 이동 가능
					if (!(hc + 1 == sc && hr + 1 == sr && sc == 8) && !(hr + 1 == sr && sr == 'H' && hc +1== sc)) {
						hc ++;
						hr ++;
						// 돌이 말의 위에 있으면 돌도 이동
						if (hc== sc && hr == sr) {
							sc ++;
							sr ++;
						}
					}
				}
				break;
			case "LT":
				if (hc < 8 && hr > 'A') {
					// (1)hc가 8에 있을 경우
					// (2)hr이 A에 있을 경우 =>위에서 체크

					// (3)hc이 7행 sc이 8행, hr-1=sr 가 아니고
					// (4)hr이 g, sr이 h, hc+1=sc 가 아니면 이동 가능
					if (!(hc + 1 == sc && hr - 1 == sr && sc == 8) && !(hr - 1 == sr && sr == 'A' && hc+1 == sc)) {
						hc++;
						hr--;
						// 돌이 말의 위에 있으면 돌도 이동
						if (hc == sc && hr == sr) {
							sc++;
							sr--;
						}
					}
				}
				break;
			case "RB":
				if (hc > 1 && hr < 'H') {
					if (!(hr + 1 == sr && sr == 'H' && hc-1 == sc) && !(hc - 1 == sc && sc == 1 && hr+1 == sr)) {
						hc -= 1;
						hr += 1;
						if (hc== sc && hr == sr) {
							sc -= 1;
							sr += 1;
						}
					}
				}
				break;
			case "LB":
				if (hc > 1 && hr > 'A') {
					if (!(hr - 1 == sr && sr == 'A' && hc-1 == sc) && !(hc - 1 == sc && sc == 1 && hr-1 == sr)) {
						hc -= 1;
						hr -= 1;
						if (hc== sc && hr== sr) {
							sc -= 1;
							sr -= 1;
						}
					}
				}
				break;
			}
		}
		System.out.println(hr+""+hc);
		System.out.println(sr+""+sc);
	}//MAIN
	
}//CLASS
