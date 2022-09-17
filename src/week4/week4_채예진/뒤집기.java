package week4.week4_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기 위함 
		String s = br.readLine(); // 한 줄 입력받기 
		
		int zero = 0; // 0일경우 
		int one = 0; // 1일경우 
		int answer = 0; // 답 
		int prev = -1; // 그 전 값 
		
		for (int i = 0; i < s.length(); i++) { // 문자열 길이만큼 탐색 
			if (prev != s.charAt(i)) { // 이전 값과 같지 않다면 
				prev = s.charAt(i); // 이전 값 업데이트 
				if(s.charAt(i) == '0') zero++; // 0일경우 
				else one++; // 1일경우 
			}
		}
		
		answer = zero < one ? zero : one; // 더 작은 값이 답 
		System.out.println(answer); // 출력 
	}

}
