package week5_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ21275_폰호석만 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int cnt =0;
		int ans = 0;
		
		int A = 0;
		int B = 0;
		
		for(int i = 2; i<=36; i++) {
			for(int j = 2; j<=36; j++) {
				try {
					//A!=B...............
					if(i==j)
						continue;
					if(Integer.parseInt(s[0], i)==Integer.parseInt(s[1],j)) {
						A=i;
						B=j;
						ans = Integer.parseInt(s[0],i);
						cnt++;
					}
				} catch (NumberFormatException e) {

				}
			}
			
		}
		switch(cnt) {
		case 0:
			System.out.println("Impossible");
			break;
		case 1:
			System.out.println(ans+" "+A+" "+B);
			break;
		default:
			System.out.println("Multiple");
		
		}
	}

}
