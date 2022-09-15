package week6.week6_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P20115_에너지드링크 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 에너지 드링크의 수
		double[] drink = new double[N];
		
		String[] s = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			drink[i] = Double.parseDouble(s[i]);
		} // 입력 완료
		
		Arrays.sort(drink); // 오름차순 정렬
		
		double ans = drink[N-1];
		// 큰수 에다가 작은 수를 나누어 더한게 최대 ..
		for (int i = 0; i < N-1; i++) {
			ans += drink[i]/2;
			drink[i] = 0; // 버리기
		}
		
		System.out.println(ans);
		
		
	}
}
