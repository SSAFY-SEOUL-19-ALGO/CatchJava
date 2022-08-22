package week3_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class 가장_먼_노드 {

	public static int solution(int n, int[][] edge) { // bfs로 풀기 -> 가장 먼 노드가 몇개인지 알아야하기 때문에 같은 레벨의 개수를 알아야하기 때문 
        int answer = 0;
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        
        ArrayList<Integer>[] adjList = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) adjList[i] = new ArrayList<>();
        for (int i = 0; i < edge.length; i++) { // 양방향 추가 
        	adjList[edge[i][0]].add(edge[i][1]);
        	adjList[edge[i][1]].add(edge[i][0]);
        }
        
        // bfs
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true; // 1번 노드에서 가장 먼 노드이기 때문 
        
        while(!q.isEmpty()) {
        	int cur = q.poll(); // 현재 노드 
        	
        	for (int adj: adjList[cur]) {
        		if (!visited[adj]) {
        			q.add(adj); // 다음에 탐색할 노드 저장 
        			visited[adj] = true; // queue에 넣었으니까 도착했음을 표시 
        			distance[adj] = distance[cur] + 1; // 다음에 탐색할 곳은 현재 값보다 +1
        		}
        	}
        }
        
        Arrays.sort(distance); // 정렬 - 개수만 세기 때문에 정렬해도 상관 없음. max가 바뀌고 그 다음을 계속 탐색하기 때문에 정렬 필요 
        int max = 0;
    	for (int d = 1; d <= n; d++) {
    		if (max < distance[d]) { // 가장 멀리 떨어진 노드 업데이트 
    			max = distance[d];
    			answer = 1;
    		} else {
    			answer++;
    		}
    	}
        
        return answer;
    }
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();
		
		while (true) {
			String s = br.readLine();
			if ("exit".equals(s)) break;
			
			String[] newVertex = s.split(" ");
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(Integer.parseInt(newVertex[0]));
			temp.add(Integer.parseInt(newVertex[1]));
			vertex.add(temp);
		}

		int[][] arr = new int[vertex.size()][2];
		for (int i = 0; i < vertex.size(); i++) {
			arr[i][0] = vertex.get(i).get(0);
			arr[i][1] = vertex.get(i).get(1);
		}
		System.out.println(solution(n, arr));
	}

}
