package week8.week8_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1063_킹 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s[] = br.readLine().split(" ");

		int kingX = (int) (s[0].charAt(0) - 'A');
		int kingY = s[0].charAt(1) - '1';

		int rockX = (int) (s[1].charAt(0) - 'A');
		int rockY = s[1].charAt(1) - '1';

		for (int n = 0; n < Integer.parseInt(s[2]); n++) {
			int kx = kingX, ky = kingY, rx = rockX, ry = rockY;
			switch (br.readLine()) {
			case "R":
				kx += 1;
				if (kx == rockX && ky == rockY) {
					rx+=1;
				}
				break;
			case "L":
				kx -= 1;
				if (kx == rockX && ky == rockY) {
					rx-=1;
				}
				break;
			case "B":
				ky -= 1;
				if (kx == rockX && ky == rockY) {
					ry-=1;
				}
				break;
			case "T":
				ky += 1;
				if (kx == rockX && ky == rockY) {
					ry+=1;
				}
				break;
			case "RT":
				kx += 1;
				ky += 1;
				if (kx == rockX && ky == rockY) {
					rx+=1; ry+=1;
				}
				break;
			case "LT":
				kx -= 1;
				ky += 1;
				if (kx == rockX && ky == rockY) {
					rx-=1; ry+=1;
				}
				break;
			case "RB":
				kx += 1;
				ky -= 1;
				if (kx == rockX && ky == rockY) {
					rx+=1; ry-=1;
				}
				break;
			case "LB":
				kx -= 1;
				ky -= 1;
				if (kx == rockX && ky == rockY) {
					rx-=1; ry -=1;
				}
				break;
			}
			if(kx>=0&&ky>=0&&kx<8&&ky<8&&rx>=0&&ry>=0&&rx<8&&ry<8) {
				kingX=kx; kingY=ky;
				rockX=rx; rockY=ry;
			}

		}
		
		System.out.print((char)('A'+kingX));
		System.out.println((kingY+1));
		System.out.print((char)('A'+rockX));
		System.out.println((rockY+1));
		
	}

}
