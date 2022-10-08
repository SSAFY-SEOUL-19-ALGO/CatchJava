package week9.week9_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1303_전쟁_전투 {
   static int WW,BB;
   static int N,M;
   static String[][] map;
   static boolean visited[][];
   
   static int[] dx = {-1,1,0,0};
   static int[] dy = {0,0,1,-1};
   
   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      
      String s[] = bf.readLine().split(" ");
      N = Integer.parseInt(s[0]); // 가로 N
      M = Integer.parseInt(s[1]); // 세로 M
      
      map = new String[M][N];
      for (int i = 0; i < M; i++) {
         String s1[] = bf.readLine().split("");
         for (int j = 0; j < N; j++) {
            map[i][j] = s1[j];
         }
      } // input end
      
      WW = 0; // 아군 시너지 
      BB = 0; // 적군 시너지
      
      visited = new boolean[M][N]; // 방문처리      
      
      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            if(visited[i][j]==false) { // 방문하지 않았고 
               
               if(map[i][j].equals("W")) { // W 와 같은 경우
                  int tmp = bfs("W", i, j);
                  WW += Math.pow(tmp, 2);
               }
               
               else if(map[i][j].equals("B")){
                  int tmp = bfs("B", i, j);
                  BB += Math.pow(tmp, 2);
               }
            }
         }
      }
      
      System.out.println(WW+" "+BB);
      
   } // main end

   private static int bfs(String c, int i, int j) {
      Queue<int[]> q = new LinkedList<>();
      visited[i][j] = true;
      q.offer(new int[] {i, j});
      int cnt = 1; // 아군인지 적군인지 세어줄 cnt
      
      while(!q.isEmpty()) {
         int[] cur = q.poll();
         int x = cur[0];
         int y = cur[1];
         
         for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx<0 || nx>=M || ny<0 || ny>=N) continue; // 범위를 벗어나는 경우
            if(!visited[nx][ny] && map[nx][ny].equals(map[x][y])) { // 방문한 곳이 아니고 현재 색과 색이 동일한 경우 !
               visited[nx][ny] = true;
               cnt++;
               q.offer(new int[] {nx, ny});
            }
         }
      }
      return cnt;
   }
}