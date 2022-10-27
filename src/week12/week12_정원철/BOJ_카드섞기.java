package week12.week12_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_카드섞기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
	
		int temp[]=new int[N]; // 순서 바뀔때마다 넣어줄 배열
		
		// 순서를 고정으로 받아줄 배열 0 1 2 .. 0 1 2..
		int sunseo[]=new int[N];
		for(int i=0; i<N; i++) {
			sunseo[i]=i%3;
		}
		
		
		// 카드 번호를 받아줄 배열과
		int number[]=new int[N];
		// 첫 카드번호를 저장해줄 배열 선언, 이는 한사이클이 돌게되는 경우를 파악하기 위함
		int first[]=new int[N];
		String st[]=br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			number[i]=Integer.parseInt(st[i]);
			first[i]=Integer.parseInt(st[i]);
		}
		
		// 섞는 방법을 넣을 배열
		int method[]=new int[N];
		st=br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			method[i]=Integer.parseInt(st[i]);
		}
		
		int cnt=0;
		while(true) {
			// 첫 시작부터 순서가 맞다면 바로 카운터 출력
			if(Arrays.equals(sunseo,number)) {
				System.out.println(cnt);
				break;
			}
			
			cnt++;
			
			// temp로 섞어주고 값을 넣어주고
			for(int i=0; i<N; i++) {
				temp[method[i]]=number[i];
			}
			
			// 해당 값을 다시 넘버에 넣어준다.
			for(int i=0; i<N; i++) {
				number[i]=temp[i];
			}
			
			// 혹시 계속 섞어서 한사이클이 지낫는데도 위 조건을 통과하지
			// 못했다면 이는 영원히 통과 못함 -> -1
			if(Arrays.equals(first,number)) {
				System.out.println(-1);
				break;
			}
			
		}

		
	}

}
