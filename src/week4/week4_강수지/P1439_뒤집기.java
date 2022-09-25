package week4.week4_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s = bf.readLine(); // 문자열 입력
		char[] str = s.toCharArray(); // 한 문자씩 잘라서 저장
		
		int cnt = 0; // 최소 횟수
		for(int i=0;i<s.length()-1;i++) { // 문자열 길이만큼 비교
			if(str[i] != str[i+1]) {
				cnt++;
			}
		}
		System.out.println((cnt+1)/2);
	}

}
