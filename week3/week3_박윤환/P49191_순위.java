package week3_박윤환;

public class P49191_순위 {

    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF = 987654321;    // 두 선수가 이기거나 지는지 알수 없는 경우 사용
        int[][] adjMat = new int[n+1][n+1]; // 인접행렬

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j) {
                    adjMat[i][j] = 0;   // 자기 자신은 0으로
                } else {
                    adjMat[i][j] = INF; // 그 외엔 INF로 초기화
                }
            }
        }

        for (int[] r : results) {
            adjMat[r[0]][r[1]] = 1; // 행에서 자기가 이기는 선수의 열은 1로 설정
        }

        // 플로이드-워셜 알고리즘
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    // 다른 선수와의 승패관계를 이용해 자신의 기록 갱신
                    adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k]+adjMat[k][j]);
                }
            }
        }

        // 모든 인접행렬을 탐색
        for(int i=1; i<=n; i++) {   // i 선수가
            int cnt = 0;
            for(int j=1; j<=n; j++) {   // j 선수에게
                // 이기는 경우 확인
                if(adjMat[i][j] != 0 && adjMat[i][j] != INF) {  // 0이나 INF가 아니면 무조건 이기므로
                    cnt++;  // 카운트 증가
                }
                // 지는 경우 확인
                if(adjMat[j][i] != 0 && adjMat[j][i] != INF) {  // 0이나 INF가 아니면 무조건 지므로
                    cnt++;  // 카운트 증가
                }
            }
            if(cnt == n-1) answer++;    // 이기거나 지는 횟수의 합이 선수수-1이면 순위 확정이 가능하므로 정답증가
        }

        return answer;
    }

    public static void main(String[] args) {
        P49191_순위 sol = new P49191_순위();

        System.out.println(sol.solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
