package week3.week3_박윤환;

import java.util.ArrayDeque;
import java.util.Queue;

public class P1844_게임맵최단거리 {
    static final int[] dx = {1, 0, -1, 0};  // 이동방향 하, 우, 상, 좌
    static final int[] dy = {0, 1, 0, -1};  // 이동방향 하, 우, 상, 좌

    public int solution(int[][] maps) {
        int answer = -1;    // 처음 값을 도달 못하는 경우의 -1로 초기화
        int N = maps.length;    // 지도의 행 크기
        int M = maps[0].length; // 지도의 열 크기
        Queue<int[]> locQ = new ArrayDeque<>();   // 위치를 저장할 큐

        locQ.offer(new int[] {0,0});  // 초기 위치 저장

        while(!locQ.isEmpty()) {   // 더이상 이동하지 못할떄까지
            int[] loc = locQ.poll();    // 현재 위치를 꺼냄
            int x = loc[0]; // 행 위치
            int y = loc[1]; // 열 위치

            if(x == N-1 && y == M-1) {  // 끝지점일 경우
                answer = maps[x][y];  // 현재 위치의 값이 이동거리이고 최소
                break;  // 무한루프 탈출
            }

            for(int i=0; i<4; i++) {    // 하, 우, 상, 좌 순서로 이동
                int nextX = x + dx[i];  // 다음 이동 행 위치
                int nextY = y + dy[i];  // 다음 이동 열 위치
                if(nextX>=0 && nextX<N && nextY>=0 && nextY<M
                        && maps[nextX][nextY] == 1) {   // 다음 위치가 범위 내이면서 갈수 있는 위치일 경우만
                    locQ.offer(new int[] {nextX, nextY});  // 다음 위치 저장
                    maps[nextX][nextY] += maps[x][y];    // 지금 위치 값을 다음 위치 값에 더함 (이동거리)
                }
            }
        }

        return answer;  // 정답 반환
    }

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        P1844_게임맵최단거리 sol = new P1844_게임맵최단거리();

        System.out.println(sol.solution(maps));
    }
}
