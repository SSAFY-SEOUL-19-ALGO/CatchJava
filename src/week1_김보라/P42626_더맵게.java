package week1_김보라;

import java.util.PriorityQueue; 

public class P42626_더맵게 {
	static int[] scoville= {1,2,3,9,10,12};
	static int K = 7;
//https://docs.oracle.com/javase/8/docs/api/
	//우선순위큐
	public static void main(String[] args) {
		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i:scoville) {
			q.add(i);
		}
		while(q.peek()<K) {
			if(q.size()==1)
				answer= -1;
			q.add(q.poll()+q.poll()*2);
			answer++;
		}
		System.out.println(answer);
	}

}
