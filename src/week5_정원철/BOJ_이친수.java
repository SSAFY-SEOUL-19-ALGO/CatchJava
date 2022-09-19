package week5_정원철;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_이친수 {
	static long D[][] = new long[91][2]; //int하면 범위를 벗어나더라 -> long, 근데 사실 배열안써도 될듯
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// Point) 
		// 1. 0으로 시작하지 않아 
		// 2. 1을 연속으로 갖고있지 않아
		// N-1자리수가 1이면 0만 오는, 0이면 0만오는
		// 0으로 시작하지 않는 다는 조건을 기준으으로 
		//D[1][0] => 0
		// D[1][1] => 1

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());

		D[1][0] = 0;
		D[1][1] = 1;

		
		// 그 과정을 기반으로 2부터  N까지 
		for (int i = 2; i <= N; i++)
		{
			//0으로 끝나는 경우는 앞의 경우의 수가 0 또는 1로 끝나도 무방-> 두가지를 더함 
			D[i][0] = D[i-1][0] + D[i-1][1];	//0으로 START~!
			
			//1로 끝나는 경우는 앞의 경우의 수가 1로 끝나는 경우는 배제해야 하므로 0으로 끝나는 경우만 해당
			D[i][1] = D[i-1][0];				// 1로 START~~!
		}
		
		long result=D[N][0] + D[N][1];
		System.out.println(result);

	}

}
