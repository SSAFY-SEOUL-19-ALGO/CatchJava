package week6.week6_박건우;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BJ16234_인구이동 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        int r, c, total, n, v, nx, ny;
        int ans = 0;
        ArrayList<Integer> track;
        boolean[] visited;

        ipt = br.readLine().split(" ");
        int N = Integer.parseInt(ipt[0]);
        int L = Integer.parseInt(ipt[1]);
        int R = Integer.parseInt(ipt[2]);

        int[][] map = new int[51][51];

        for(int i = 0; i < N; i++){
            ipt = br.readLine().split(" ");
            for(int j = 0; j < ipt.length; j++){
                map[i][j] = Integer.parseInt(ipt[j]);
            }
        }

        boolean flag = true;
        while (flag) {
            Queue<Integer> q = new ArrayDeque<>();
            visited = new boolean[10001];
            flag = false;
            ans++;
            // ?번째 인구 이동 탐색
            for (int i = 0; i < N * N; i++) {
                if (visited[i]) {
                    continue;
                }
                track = new ArrayList<Integer>();

                r = i / N;
                c = i % N;
                q.add(i);
                visited[i] = true;
                track.add(i);
                total = map[r][c];
                n = 1;

                while (!q.isEmpty()) {
                    v = q.poll();
                    r = v / N;
                    c = v % N;

                    for (int k = 0; k < 4; k++) {
                        nx = c + dx[k];
                        ny = r + dy[k];

                        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                            int next = ny * N + nx;

                            if (visited[next]) {
                                continue;
                            }

                            int count = map[ny][nx];
                            int pivot = map[r][c];
                            if (L <= Math.abs(count - pivot) && Math.abs(count - pivot) <= R) {
                                // 연합국 조건 성립
                                flag = true;
                                q.add(next);
                                visited[next] = true;
                                track.add(next);
                                total += map[ny][nx];
                                n++;
                            }
                        }

                    }
                }
                // 연합국 인구 수 업데이트
                int updateN = total / n;
                if (track.size() > 1) {
                    for (int val : track) {
                        r = val / N;
                        c = val % N;
                        map[r][c] = updateN;
                    }
                }

            }
        }
        System.out.println(ans - 1);
    }
}