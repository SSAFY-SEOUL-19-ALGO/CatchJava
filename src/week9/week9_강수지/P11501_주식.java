package week9.week9_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11501_주식{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(bf.readLine()); // 날의 수
			
			int[] stocks = new int[N]; // 날별 주가
			String s[] = bf.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				stocks[i] = Integer.parseInt(s[i]);
			} // input end
			
			int max = stocks[N-1]; // 가장 마지막날부터 역순으로 확인
			long income = 0; // 최대 이익
			
			for (int i = N-2; i >= 0; i--) {
				if(stocks[i] > max) max= stocks[i]; // 주식이 떨어진 경우 이득이 없다
				income += max - stocks[i]; // 주식은 낮을때 구매해서 높을때 판매해야 이득 !
			}
			System.out.println(income);
		} // test case end

	}

}

