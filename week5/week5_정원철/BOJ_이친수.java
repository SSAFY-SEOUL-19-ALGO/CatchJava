package week5_정원철;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_이친수 {
	static long D[][] = new long[91][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int N= Integer.parseInt(br.readLine());

		D[1][0] = 0;
		D[1][1] = 1;
		
		//if n=3
		
		for (int i = 2; i <= N; i++)
		{
			D[i][0] = D[i-1][0] + D[i-1][1];	
			D[i][1] = D[i-1][0];			
		}
		
		long result=D[N][0] + D[N][1];
		
		System.out.println(result);
//		bw.write((int) ();
//		bw.flush();
//		bw.close();

		char c='c';
		char b='b';
		System.out.println(c+b);
	}

}
