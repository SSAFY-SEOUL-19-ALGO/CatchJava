package week9.week9_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ17609_회문 {
/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			int[] al = new int['z'-'a'];
			String s = br.readLine();
			
			for(int i = 0; i<s.length(); i++) {
				al[s.charAt(i)-'a']++;
			}
			
			int odd=0;
			for(int j = 0; j<al.length; j++) {
				if(al[j]%2!=0) {
					odd++;
				}
			}
			
			if(s.length()%2==0) {
				if(odd==1)
					System.out.println(1);
				else if(odd==0)
					System.out.println(0);
				else
					System.out.println(2);
			}else {
				if(odd==1)
					System.out.println(0);
			}
			
			
		}
	}
*/
	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			System.out.println(check(br));
		}
	}
	static int check(BufferedReader br) throws Exception {
		boolean pass = false;
		
		String s = br.readLine();
		
		int start = 0;
		int end = s.length()-1;
		for(int i = 0; i<s.length()/2; i++) {
			if(s.charAt(start)!=s.charAt(end)) {
				if(pass) {
					return 2;
				}
				if(s.charAt(start+1)==s.charAt(end)) {
					pass=true;
					start++;
				}else if(s.charAt(start)==s.charAt(end-1)){
					pass=true;
					end--;
				}else {
					return 2;
				}
			}else {
				start++; end--;
			}

		}
		if(pass)
			return 1;
		else
			return 0;
	}*/
/*반례참고
21
abbab
aab
aaab
aaaab
aaaaab
aaaaaab
axaaxaa
abcddadca
aabcbcaa
ababbabaa
abca
babba
sumumuus
XYXYAAYXY
abc
cccfccfcc
abcddcdba
ppbpppb
aabcdeddcba
aabab
aapqbcbqpqaa

1
1
1
1
1
1
1
2
1
1
1
1
1
1
2
1
1
2
2
2
1
*/
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<=T; t++) {
			String s = br.readLine();
			System.out.println(check(s,0,s.length()-1,false));
			
		}
	}
	static int check(String s,int start, int end, boolean pass){
		
		while(start<=end) {
			if(s.charAt(start)!=s.charAt(end)) {
				if(pass) {
					return 2;
				}
				int result1 = 2, result2 = 2;
				if(s.charAt(start+1)==s.charAt(end)) {
//					System.out.println("1if "+s.substring(start+1,end));
					result1= check(s,start+1,end,true);
				}
				if(s.charAt(start)==s.charAt(end-1)){
//					System.out.println("2if "+s.substring(start,end-1));
					result2= check(s,start,end-1,true);
				}
				return Math.min(result1, result2);
			}
			start++; end--;


		}
		if(pass)
			return 1;
		else
			return 0;
	}
	
}
