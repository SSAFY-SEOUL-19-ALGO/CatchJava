package week3_정원철;

import java.util.ArrayDeque;
import java.util.Queue;


public class Lv3_가장먼노드 {
	 	static boolean[] visited;
	    static boolean[][] near;
	    static int n;
	    static int [][]edge;
	    static public int solution(int n, int[][] edge) {
	        int answer = 0;
	        visited = new boolean[n+1];
	        near = new boolean[n+1][n+1];
	        answer = test(edge);
	       
	        return answer;
	    }
	    
	   static public int test(int[][] edge) {
		   // 정점 1을 기준으로 가장 깊은 뎁스를 가지는 정점 숫자 구하기
		   // 간선을 통한 인접행렬
		   // 가장 뎁스가 깊은정점 == 먼정점 == 마지막으로 들어가는 정점
		   // 뎁스별로 큐에서 poll하도록 순회
	        Queue<Integer> que = new ArrayDeque<>();
	        que.offer(1);
	        visited[1] = true;
	        int N=edge.length;
	        for (int i = 0; i < N; i++) {
	            int x = edge[i][0];
	            int y = edge[i][1];
	            near[x][y] = true;
	            near[y][x] = true;
	        }
	        
	        int result = 0;
	        
	        while (!que.isEmpty()) {
	            result = que.size();
	            
	            for (int i = 0; i < result; i++) {
	                int cur = que.poll();
	                
	                for (int j = 1; j < visited.length; j++) {
	                    if (!visited[j] && near[cur][j]) {
	                        visited[j] = true;
	                        que.add(j);
	                    }
	                }
	            }
	        }
	        
	        return result;
	    }
	public static void main(String[] args) {
		edge=new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		n=6;
		System.out.println(solution(n, edge));
	}

}
