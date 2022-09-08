package week4.week4_박건우;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ1439_뒤집기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s = br.readLine();
		
		StringTokenizer st0 = new StringTokenizer(s, "0");	// 문자열에 0으로 연속된 문자열의 개수를 셈
		StringTokenizer st1 = new StringTokenizer(s, "1");	// 문자열에 1으로 연속된 문자열의 개수를 셈
		
		bw.write(Math.min(st0.countTokens(), st1.countTokens()) + "\n");
		bw.flush();
	}

}
