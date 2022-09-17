package week7.week7_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_행복유치원 {
	// 각 차이를 배열로 정리
	// 2 2 1 4 
	// => 1 2 2 4
	// => 필요한것 1, 2
	// => 제외 된것 2, 4
	// => (3, 5) (6, 10) 이 경우
	
	
	// 1 3 5 6 10
	// (1, 3) (5, 6) (10)
	// (3, 5) (6, 10)

	// 차를 정리하고, 정렬하고 , 전체에서 k만큼 제외한 만큼 차의 합을 출력
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st[]= br.readLine().split(" ");
		
		int N=Integer.parseInt(st[0]);
		int K=Integer.parseInt(st[1]);
		
		int list[]= new int[N];
		int keyList[]=new int[N-1];
		
		st= br.readLine().split(" ");
		for(int i=0; i<N; i++) list[i]=Integer.parseInt(st[i]);
		
		for(int i=0; i<N-1; i++) keyList[i]=list[i+1]-list[i];
		Arrays.sort(keyList);
		
		int result=0;
		for(int i=0; i<N-K; i++) result+=keyList[i];
		
		System.out.println(result);

	}
}
