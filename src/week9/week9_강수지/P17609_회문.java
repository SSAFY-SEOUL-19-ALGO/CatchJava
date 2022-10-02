package week9.week9_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17609_회문 {
	static char[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for (int tc = 0; tc < T; tc++) {
			
			String s= bf.readLine(); // 문자열 입력
			arr = s.toCharArray();
			int left = 0; // 투 포인터 !
			int right = s.length()-1;
			
			if(palindrome(left, right)) { // 회문인경우
				System.out.println(0); 
				continue;
			}
			
			// 유사회문인 경우 
			if(similar(left, right)) {
				System.out.println(1);
			}
			// 일반 문자열인 경우
			else {
				System.out.println(2);
			}
			
		} // test case end
		
	} // main end

	private static boolean similar(int left, int right) { // 유사회문 판별
		
		while(left<=right) {
			if(arr[left]!=arr[right]) { // 회문이 될 수 없는 경우

				boolean x = palindrome(left+1, right);
				boolean y = palindrome(left, right-1);
				
				if(x==false && y==false) return false;
				else return true;
			}
			// 회문의 조건이 되니까 넘어간다 
			left+=1;
			right-=1;
		}
		
		return true;
	}

	private static boolean palindrome(int left, int right) { // 회문인지 아닌지 판별
		
		while(left<=right) {
			if(arr[left]!=arr[right]) { // 회문이 될 수 없는 경우
				return false;
			}
			// 회문의 조건이 되니까 넘어간다 
			left+=1;
			right-=1;
		}
		
		return true;
		
	}
	
}
