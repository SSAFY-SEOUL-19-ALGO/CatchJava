package week3_강수지;

import java.util.*;

public class P1844_게임맵최단거리 {
    // 동서남북 방향벡터
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,-1,1};
    static int n, m;
    
    public int solution(int[][] maps) { // 최단경로 == BFS 외워 ..
        int answer = 0;
        n = maps.length; // 가로
        m = maps[0].length; // 세로
        
        int[][] visited = new int[n][m]; // 방문 체크
        visited[0][0] = 1; // 시작 위치 방문체크
        
        bfs(maps, visited); // bfs 탐색
        answer = visited[n-1][m-1];
        
        if(answer==0) return -1; // 갈 수 없으면 -1
        
        return answer;
        
    } //main end
    
    public void bfs(int[][] maps, int[][]visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int i = now[0];
            int j = now[1];
            
            for(int d=0;d<4;d++){ // 4방 탐색
                int nx = i + dx[d];
                int ny = j + dy[d];
                        
                if(0<=nx && nx <n && 0<=ny && ny< m){
                    // 방문하지 않았고 이동 가능하다면
                    if(maps[nx][ny]==1&& visited[nx][ny] == 0){
                        visited[nx][ny] = visited[i][j]+1;
                        q.add(new int[]{nx, ny});
                    }
                }
            
            }
        }
    }
}