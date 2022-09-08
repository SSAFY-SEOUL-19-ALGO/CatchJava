package week3.week3_김보라;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class P49189_가장먼노드 {
	
	static int n = 6;
	static int[][] edge = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
	
	public static void main(String[] args) {
		
		int answer = 0;
		LinkedList<Integer> graph[] = new LinkedList[n+1];
		for(int N = 0; N<=n; N++) {
			graph[N]=new LinkedList();	//연결리스트 초기화
		}
		
		for(int e = 0; e<edge.length; e++) {
			graph[edge[e][0]].add(edge[e][1]);
			graph[edge[e][1]].add(edge[e][0]);
		}//그래프 만들기
		//연결리스트로 구현했으니 정렬을 해줘야 합니다~
		for(int i = 0; i<=n; i++) {
			Collections.sort(graph[i]);
		}
		boolean visited[]= new boolean[n+1];
		//bfs
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1]=true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i<size; i++) {
				int ne = q.poll();
				
				Iterator<Integer> it = graph[ne].listIterator();
				while(it.hasNext()) {
					int nxt = it.next();
					if(!visited[nxt]) {
						visited[nxt]=true;
						q.add(nxt);
					}
				}
			}
			answer=size;
		}
		
		System.out.println(answer);
		
	}//main 종료
	
}
