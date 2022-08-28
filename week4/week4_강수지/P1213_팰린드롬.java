package week4_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class P1213_팰린드롬 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder left = new StringBuilder(); // 팰린드롬을 만들어서 출력하기 위해
		StringBuilder mid = new StringBuilder(); 
		StringBuilder right = new StringBuilder(); 
		String s = bf.readLine(); // 문자열 입력
		
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {// 문자열을 입력 받으며 알파벳 세기
			int idx = s.charAt(i) - 'A'; // 아스키 코드를 사용
			alpha[idx]++; // 해당 알파벳 위치 ++
		}
		
		// 팰린드롬은 짝수 .. 홀수가 있으면 가운데 위치하는 것만 가능
		// 홀수의 개수 세기
		int odd = 0; 
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i]%2 != 0) {
				odd++;
			}
		}
		
		int num = 0;
		if (odd>1) { // 홀수가 1개 이상이면 절대 못만든다
			System.out.println("I'm Sorry Hansoo");
		} else { // 홀수 한 개 있는 경우 가운데 위치시키고 양쪽을 완성
			for (int i = 0; i < alpha.length; i++) {
				if(alpha[i]%2 == 1) {
					num = i;
					mid.append((char)(num+65)); // 가운데 홀수 위치 시킴
					alpha[i]--;
					
					while(alpha[i]!=0) { // 남은 개수가 다 없어질때까지 반복
						left.append((char)(i+65)); // 왼쪽
						alpha[i]--;
						right.append((char)(i+65)); // 오른쪽
						alpha[i]--;
					}
				}
				else if(alpha[i]!=0) { // 짝수개인 경우에 그냥 양쪽 완성
					while(alpha[i]!=0) { // 남은 개수가 다 없어질때까지 반복
						left.append((char)(i+65)); // 왼쪽
						alpha[i]--;
						right.append((char)(i+65)); // 오른쪽
						alpha[i]--;
					}
				}
				
			}
		}
		System.out.print(left);
		System.out.print(mid);
		System.out.println(right.reverse()); // 왼쪽과 마주보도록
		
	} // main end

}
