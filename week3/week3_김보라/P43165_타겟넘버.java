package week3_김보라;

import java.util.LinkedList;
import java.util.Queue;

public class P43165_타겟넘버 {

	static int numbers[] = {1,1,1,1,1};
	static int target = 3;
	
	public static void main(String[] args) {
		//dfs
//		boolean[] visited = new boolean[1001];	//타겟넘버는 1 이상 1000이하인 자연수입니다.
		Queue<Integer> q = new LinkedList<>();
		q.add(numbers[0]);
		q.add(numbers[0]*-1);
//		visited[numbers[0]]=true;
		
		int answer = 0;
		int j = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i<size; i++) {
				if(j==numbers.length) {
					while(!q.isEmpty()) {
						int cur = q.poll();
						if(cur==target)
							answer++;
					}
					System.out.println(answer);
					return;
				}
				int cur = q.poll();
//				if(cur-numbers[j]>0) {
					q.offer(cur-numbers[j]);
//					visited[cur-numbers[j]]=true;
//				}
//				if(cur+numbers[j]<=1000) {
					q.offer(cur+numbers[j]);
//					visited[cur+numbers[j]]=true;
				}
				j++;
//				System.out.println(q);
//			}
			
		}
	}
	static int Solution(String[] args) {
		//dfs
		Queue<Integer> q = new LinkedList<>();
		q.add(numbers[0]);
		q.add(numbers[0]*-1);
		
		int answer = 0;
		int j = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i<size; i++) {
				if(j==numbers.length) {
					while(!q.isEmpty()) {
						int cur = q.poll();
						if(cur==target)
							answer++;
					}
//					System.out.println(answer);
					return answer;
				}
				int cur = q.poll();
					q.offer(cur-numbers[j]);
					q.offer(cur+numbers[j]);
				}
				j++;
			
		}
		return 0;
	}

}
