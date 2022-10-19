package week10.week10_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_추월 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<String> inputCarlist= new ArrayList<>();
		List<String> outputCarlist= new ArrayList<>();
		
		for(int i=0; i<N; i++) inputCarlist.add(br.readLine());
		for(int i=0; i<N; i++) outputCarlist.add(br.readLine());
		
		int cnt=0;
		
		
		//모든 차량에 대해 나올 때 뒤에 있던 차가 들어갈 때는 앞에 있던 경우가 하나라도 확인된다면 ++
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
	            if(inputCarlist.indexOf(outputCarlist.get(i))>inputCarlist.indexOf(outputCarlist.get(j))) {
	            	cnt++;
	            	break;
	            }
			}
		}
		System.out.println(cnt);

	}
	

	// 전 후
	// 0 a d
	// 1 b a
	// 2 c c
	// 3 d b
}
