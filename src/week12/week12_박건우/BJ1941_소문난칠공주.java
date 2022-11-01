package week12.week12_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ1941_소문난칠공주 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] combX = new int[25];
    static int[] combY = new int[25];

    static char[][] map;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        StringBuilder sb = new StringBuilder();
        String str;

        ans = 0;
        map = new char[5][5];

        for(int i = 0; i < 5; i++){
            str = br.readLine();
            map[i] = str.toCharArray();
        }

        for(int i = 0; i < 25; i++){
            combX[i] = i % 5;
            combY[i] = i / 5;
        }

        comb(new int[7], 0, 0, 7);
        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }

    public static void comb(int[] com, int idx, int dep, int left){
        if(left == 0){
            bfs(com);
            return;
        }

        if(dep == 25) return;
        
        com[idx] = dep;
        comb(com, idx+1, dep+1, left-1);    // 추가로 다음 인덱스를 선택한 경우, 깊이와 idx 증가에 남은 선택 가지수 감소
        comb(com, idx, dep+1, left);    // 추가로 다음 인덱스 선택 안 한 경우, 깊이만 늘어나고 idx와 가지수 변화 없음

    }

    public static void bfs(int[] com){
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[7];   // 7개를 탐색하므로 새로운 visited 생성;

        visited[0] = true;
        queue.add(com[0]);
        int cnt = 1, iCnt = 0;  // 학생의 수와 이다솜파 학생의 수

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(map[combY[cur]][combX[cur]] == 'S'){
                iCnt++;
            }

            for (int i = 0; i < 4; i++) {
                for (int nv = 1; nv < 7; nv++){
                    if(!visited[nv] && combX[cur] + dx[i] == combX[com[nv]] && combY[cur] + dy[i] == combY[com[nv]]){
                        visited[nv] = true;
                        queue.add(com[nv]);
                        cnt++;
                    }
                }
            }
        }

        if(cnt == 7){   // 7명의 학생 세었고
            if(iCnt >= 4) ans++;    // 그중 이다솜파가 4명 이상이면 ans 수 증가
        }
    }
}
