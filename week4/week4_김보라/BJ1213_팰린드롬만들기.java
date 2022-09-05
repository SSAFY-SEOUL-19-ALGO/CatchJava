package week4_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1213_팰린드롬만들기 {
//AABBCCCDD
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int[] al = new int['Z'-'A'+1];
		
		for(int i = 0; i<s.length(); i++) {
			al[s.charAt(i)-'A']++;
		}
		boolean odd = false;
		String answer = "";
		char mid = 0;
		for(int i = 0; i<al.length; i++) {
			char tmp = (char) ('A'+i);
			if(al[i]!=0) {
			if(al[i]%2!=0) {
				if(odd) {
					System.out.println("I'm Sorry Hansoo");
					return;
				}
				odd=true;
				if(al[i]!=1)
				for(int j = 0; j<al[i]/2; j++) {
					answer+=tmp;
				}
					
				mid=tmp;
			}else {
				for(int j = 0; j<al[i]/2; j++) {
				answer+=tmp;
				}
			}
			}
		}
		int i = answer.length()-1;
		if(mid!=0) {
			answer+=mid;
		}
		for(;i>=0; i--) {
			answer+=answer.charAt(i);
		}
		
		System.out.println(answer);
	}

}
