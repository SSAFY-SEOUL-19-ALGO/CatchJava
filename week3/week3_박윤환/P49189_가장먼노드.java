package week3_박윤환;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class P49189_가장먼노드 {

    static int[] dist;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start); // 시작지점 1번노드

        visited[start] = true;  // 1번노드 방문처리

        while(!q.isEmpty()) {   // 큐가 빌떄까지
            int x = q.poll();   // 큐에서 방문 정보를 꺼내고
            for(int i=0; i<graph.get(x).size(); i++) {  // 해당 노드의 간선 개수만큼 반복
                int y = graph.get(x).get(i);    // 해당 노드와 연결된 노드
                if(!visited[y]) {   // 방문한 적이 없다면
                    dist[y] = dist[x] + 1;  // 거리를 계산하고
                    q.offer(y);     // 큐에 노드를 추가
                    visited[y] = true;  // 노드 방문 처리
                }
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;

        graph = new ArrayList<>();  // 그래프 정보를 넣을 ArrayList
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];     // 방문 기록
        dist = new int[n+1];        // 1번 노드와의 거리 저장

        for (int[] ints : edge) {       // 간선 정보로 그래프 정보 작성
            graph.get(ints[0]).add(ints[1]);
            graph.get(ints[1]).add(ints[0]);
        }

        bfs(1); // bfs 탐색

        int max = 0;
        for(int i=1; i<=n; i++) {
            if(max < dist[i]) {
                max = dist[i];
                answer = 1;
            } else if(max == dist[i]) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        P49189_가장먼노드 sol = new P49189_가장먼노드();
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(sol.solution(6, vertex));
    }
}
