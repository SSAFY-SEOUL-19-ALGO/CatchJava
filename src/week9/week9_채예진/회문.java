package week9.week9_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 회문 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String s = br.readLine(); // 한 문장 받기 
			String rev = new StringBuffer(s).reverse().toString(); // reverse 
			
			if(s.equals(rev)) sb.append(0 + "\n"); // 회문일 경우 
			else {
				int end = s.length() - 1;
				boolean check = false;
				for(int i = 0; i < end / 2; i++) {
					if(s.charAt(i) != s.charAt(end - i)) { // 유사회문인지 체크
						String s1 = new StringBuilder(s).deleteCharAt(i).toString();
						String s2 = new StringBuilder(s).deleteCharAt(end - i).toString();
						
						if(s1.equals(new StringBuffer(s1).reverse().toString())) { // 하나만 제거 
							sb.append(1 + "\n");
							check = true;
						}else if(s2.equals(new StringBuffer(s2).reverse().toString())) { // 하나만 제거 
							sb.append(1+"\n");
							check = true;
						}
						break;
					}
				}
				
				if(!check) sb.append(2 + "\n");
			}
		}
		System.out.println(sb.toString());
	}
}
