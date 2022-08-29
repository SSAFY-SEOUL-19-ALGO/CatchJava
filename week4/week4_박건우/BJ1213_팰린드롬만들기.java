package week4_박건우;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new  StringBuilder();
		
		String ans = "", end = "";
		
		int[] alpha = new int[26];
		String ipt = br.readLine();
		
		for(int i = 0; i < ipt.length(); i++) {
			alpha[ipt.charAt(i) - 'A']++;
		}
		 int cnt = 0, idx;
		// 문자열이 짝수개인 경우에 알파벳이 홀수이면 출력 불가
		for(int i = 0; i < alpha.length; i++) {	// 홀수개인 문자 갯수 새기
			if(alpha[i] % 2 != 0) {
				cnt++;
				idx = i;
			}
		}
		// 홀수가 1개 넘어가면
		if(cnt > 1) {
			ans += "I'm Sorry Hansoo";
		} else {
			for(int i = 0; i < alpha.length; i++) {
				for(int j = 0; j < alpha[i] / 2; j++) {
					sb.append((char)(i+65));
				}
			}
			
			ans += sb.toString();
			end = sb.reverse().toString();
			sb = new  StringBuilder();
			
			for(int i = 0; i < alpha.length; i++) {
				if(alpha[i] % 2 == 1) {
					sb.append((char)(i+65));
				}
			}
			
			ans += sb.toString() + end;
			
		}
		bw.write(ans+"\n");
		bw.flush();
	}
}
