package week4_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1439_뒤집기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int answer=0;
		
		char tmp=s.charAt(0);
		for(int i = 0; i<s.length(); i++) {
			if(s.charAt(i)!=tmp) {
				answer++;
				tmp=(tmp=='1')? '0':'1';
				
			}
		}
		if(answer>=2)
			answer=(int) Math.ceil((double)answer/2);
		System.out.println(answer);

	}

}
