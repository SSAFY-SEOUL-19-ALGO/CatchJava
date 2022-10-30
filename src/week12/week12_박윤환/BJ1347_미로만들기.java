package week12.week12_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1347_미로만들기 {
    static final int[] dx = {1, 0, -1, 0};  // 하, 좌, 상, 우
    static final int[] dy = {0, -1, 0, 1};  // 하, 좌, 상, 우

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] record = new char[N];    // 움직임 기록
        String s = br.readLine();
        for(int i=0; i<N; i++) {
            record[i] = s.charAt(i);
        }
        List<int[]> list = new ArrayList<>();   // 이동한 위치를 기록할 리스트
        int x = 50; // 위쪽으로만 이동해도 인덱스가 0이 안되도록 50에서부터
        int y = 50; // 왼쪽으로만 이동해도 인덱스가 0이 안되도록 50부터
        int dir = 0;    // 초기 방향은 남쪽
        list.add(new int[] {x, y}); // 현재 위치 리스트에 추가
        for (char r :
                record) {   // 기록내용 반복
            switch (r) {
                case 'R':   // R 이라면
                    dir = (dir + 1) % 4;    // 방향에 1을 더한 나머지가 오른쪽 방향
                    break;
                case 'L':   // L 이라면
                    dir--;  // 방향에 1을 뺀게 왼쪽 방향
                    if(dir < 0) dir = 3;    // 0보다 작아지면 다시 3부터
                    break;
                case 'F':   // F라면
                    x += dx[dir];   // 지금 방향으로 간다
                    y += dy[dir];
                    list.add(new int[] {x, y}); // 움직인 위치 리스트에 기록
                    break;
            }
        }

        // 리스트에 기록한 위치에서 행과 열별로 최소, 최대 인덱스를 구함
        int minR = 100;
        int minC = 100;
        int maxR = 0;
        int maxC = 0;
        for (int[] p :
                list) {
            maxR = Math.max(maxR, p[0]);
            maxC = Math.max(maxC, p[1]);
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }

        int sizeR = maxR - minR + 1; // 행의 최대 최소의 차이 + 1이 미로의 행 크기
        int sizeC = maxC - minC + 1; // 열의 최대 최소의 차이 + 1이 미로의 열 크기
        char[][] map = new char[sizeR][sizeC];    // 미로 생성
        for(int i=0; i<sizeR; i++) {
            for(int j=0; j<sizeC; j++) {
                map[i][j] = '#';    // 모든 칸을 벽으로 초기화
            }
        }

        for (int[] p :
                list) { // 리스트 반복
            map[p[0] - minR][p[1] - minC] = '.';    // 현재위치에서 최소 행과 열 크기만큼 뺀 위치가 미로에서 위치
        }

        for (char[] m :
                map) {
            for (char c :
                    m) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
