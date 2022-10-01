package week8.week8_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BJ1417_국회의원선거 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int dasom = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for(int n = 1; n<N; n++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		while(true) {
			if(q.isEmpty()||q.peek()<dasom)
				break;
			int max = q.poll();
			
			max--;
			dasom++;
			cnt++;
			q.add(max);
			
		}
		
		System.out.println(cnt);
		
	}

}
