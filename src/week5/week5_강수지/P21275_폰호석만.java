package week5.week5_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P21275_폰호석만 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		String A = s[0];
		String B = s[1];
		
		long x = 0;
		int a = 0, b= 0; // 출력할 값
		int cnt = 0; // 조건에 맞는 값이 몇개 인지 ..

		// 2이상 36 이하 집법 중 하나 !
		for (int i = 2; i < 37; i++) {
			for (int j = 2; j < 37; j++) {
				try {
					// A 를 가지고 표현할 수 있는 진법을 찾음
					int atmp = Integer.parseInt(A,i);
					// B 를 가지고 표현할 수 있는 진법을 찾음
					int btmp = Integer.parseInt(B,j);
					
					if(i==j) continue;
					
					// 진수 변환 값이 같을때
					if(atmp==btmp) {
						cnt += 1;
						x = atmp;
						a = i;
						b = j;
					}
				} catch (Exception e) {
					continue;
				}
			}
		}
		
		if(cnt>=2) {
			System.out.println("Impossible");
		}else if(cnt==0) {
			System.out.println("Impossible");
		}else {
			System.out.println(x+" "+a+" "+b);
		}
		
	}

}
