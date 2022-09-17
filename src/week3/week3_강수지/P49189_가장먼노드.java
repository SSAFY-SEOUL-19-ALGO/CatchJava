package week3.week3_강수지;

import java.util.*;

class P49189_가장먼노드 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // 인접 행렬 구현
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n+1]; // 방문 ..
        int answer;
        
        for(int i=0;i<=n;i++){
            graph.add(i, new ArrayList<>());
        }
        
        for(int i=0;i<edge.length;i++){ // 양방향 추가
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        // for(int i=0;i<=n;i++){
        // System.out.println(graph.get(i));
        // } 확인 ..
        
        answer = bfs();
        return answer;
    }
    
    public static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1); // 첫 노드부터 시작
        visited[1]=true; // 방문처리
        
        int cnt = 0;
        while(true){ // 인접한 노드들을 추가
            Queue<Integer> tmp = new LinkedList<>();
            
            while(!q.isEmpty()){ // tmp 에 먼저 추가한 후
                int cur = q.poll();
                for(int adj :  graph.get(cur)){
                    if(!visited[adj]){
                        tmp.add(adj);
                        visited[adj] = true;
                    }
                }
            }
            // 
            if(tmp.isEmpty()) break;
            q.addAll(tmp); // q 로 한 번에 추가하고
            cnt = tmp.size(); // tmp size 로 같은 거리에 있는 개수를 세어준다 !
        }
        return cnt;
    }
}