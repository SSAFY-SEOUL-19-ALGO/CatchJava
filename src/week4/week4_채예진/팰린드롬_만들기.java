package week4.week4_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팰린드롬이란, 앞뒤를 뒤집어도 똑같은 문자열 
public class 팰린드롬_만들기 {

	static int[] alphabet = new int[26];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		// 펠린드롬인지 확인하기 
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'A']++; // 알파벳 배열 인덱스에 값 추가 
		}
		
		// 알파벳 배열 돌면서 홀수인 거 확인
		int odd = 0;
		int mid = -1; // 중간 index 확인 - 홀수일 경우 이걸 중간에 둘 예정 
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i] % 2 == 1) {
				odd++;
				mid = i;
			}
		}
		
		// 짝수인데 한개짜리가 있는 경우, 홀수인데 한개짜리가 2개이상 있는 경우 
		if ((s.length() % 2 == 0 && odd > 0) || (s.length() % 2 == 1 && odd > 1)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		
		for (int i = 0; i < alphabet.length; i++) {
			if (mid == i && alphabet[i] == 1) continue; // 중간에 둬야할 경우 
			for (int j = 0; j < alphabet[i] / 2; j++) { // 반만 채우기 
				sb.append((char) (i + 'A'));
			}
		}
		
		String rev = new StringBuilder(sb).reverse().toString(); // 나머지 반 
		
		if (mid != -1) sb.append((char) (mid + 'A')); // 중간에 둘 값 
		
		sb.append(rev); // 중간에 값을 둔 후 나머지 같은 값 reverse 해서 넣기 
		
		
		System.out.println(sb);
	}

}
