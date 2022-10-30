package week12.week12_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BJ1941_소문난칠공주 {
    static final int[] dr = {0, 1, 0, -1};  // 우, 하, 좌, 상
    static final int[] dc = {1, 0, -1, 0};  // 우, 하, 좌, 상

    static char[][] seats;
    static int[] picked;
    static boolean[] visited;
    static int totalCnt;
    static Queue<Integer> queue;

    // 조합 수행 메소드
    static void comb(int cnt, int start) {
        if(cnt == 7) {  // 7명을 뽑았다면
            int count = 0;  // 이다솜파 인원수 카운트하는 변수
            for (int p :
                    picked) {   // 뽑힌 사람 반복
                if(seats[p / 5][p % 5] == 'S') count++; // 이다솜파이면 count 증가
            }
            Arrays.fill(visited, false);    // 방문배열 초기화
            queue.offer(picked[0]); // 첫번쨰 뽑힌사람 큐에 추가하고
            visited[0] = true;  // 방문처리
            int adj = 0;    // 인접한 사람 수
            while(!queue.isEmpty()) {   // 큐가 빌때까지 반복
                int cur = queue.poll(); // 현재 사람
                int r = cur / 5;    // 현재 사람의 행위치
                int c = cur % 5;    // 현재 사람의 열위치
                adj++;  // 인접한 사람 수 증가
                for(int i=0; i<4; i++) {    // 사방탐색
                    int nextR = r + dr[i];  // 다음 행 위치
                    int nextC = c + dc[i];  // 다음 열 위치
                    if(nextR >= 0 && nextR < 5 && nextC >= 0 && nextC < 5) {    // 다음 위치가 범위내이면
                        int next = nextR * 5 + nextC;   // 알칼제이 -> 2차원을 1차원 인덱스로
                        for(int j=0; j<7; j++) {    // 뽑힌 사람 반복
                            if(picked[j] == next && !visited[j]) {  // 다음 위치의 사람이 뽑은 사람이면서 방문하지 않았다면
                                visited[j] = true;  // 방문처리
                                queue.offer(picked[j]); // 큐에 저장
                            }
                        }
                    }
                }
            }
            if(adj == 7 && count >= 4) {    // 7명이 이어져있고 이다솜파가 4명이상아면
                totalCnt++; // 경우의 수 증가
            }
            return;
        }

        for(int i=start; i<25; i++) {   // 25개의 인덱스
            picked[cnt] = i;    // 하나를 고르고
            comb(cnt + 1, i + 1);   // 다음 숫자 고르러 감
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        seats = new char[5][5];
        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<5; j++) {
                seats[i][j] = s.charAt(j);
            }
        }

        picked = new int[7];    // 뽑힌 7명을 저장할 배열
        visited = new boolean[7];   // 뽑힌 7명끼리 연결됐는지 bfs를 할때 사용할 방문배열
        queue = new ArrayDeque<>(); // bfs에 사용할 큐
        comb(0, 0); // 조합 수행

        System.out.println(totalCnt);
    }
}
