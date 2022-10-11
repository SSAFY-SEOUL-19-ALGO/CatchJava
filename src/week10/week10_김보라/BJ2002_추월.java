package week10.week10_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BJ2002_추월 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		List<String> dq = new ArrayList<>();
		Queue<String> yq = new ArrayDeque<>();
		int answer =0 ;
		
		for(int n = 0; n<N; n++) {
			dq.add(br.readLine());
		}
		for(int n = 0; n<N; n++) {
			yq.add(br.readLine());
		}
		for(int n = 0; n<N; n++) {
			String in = dq.get(n);
			String out = yq.poll();
			if(in.equals(out)) {
				
			}else {
				answer++;
				for(int i = n; i<dq.size(); i++) {
					if(dq.get(i).equals(out)) {
						dq.remove(i);
						n--;
						N--;
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
}
