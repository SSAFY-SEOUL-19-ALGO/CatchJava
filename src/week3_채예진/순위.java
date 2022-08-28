package week3_채예진;

import java.util.Scanner;

public class 순위 {

    public static int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 0; i < results.length; i++) {
            graph[results[i][0]][results[i][1]] = true;
        }

        // A가 B를 이기고, B가 C를 이기면 A가 C를 이김
        for (int b = 0; b <= n; b++) { // B
            for (int a = 0; a <= n; a++) { // A
                for (int c = 0; c <= n ; c++) { // C
                    if (graph[a][b] && graph[b][c]) {
                        graph[a][c] = true;
                    }
                }
            }
        }

        // 정확히 순위 아는 거 카운트 
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] || graph[j][i]) cnt++;
            }
            if (cnt == n - 1) answer++; // 본인 제외 본인과의 경쟁 나머지의 승패 여부 값을 알 경우 
        }
        
        return answer;
    }
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] results = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			results[i][0] = sc.nextInt();
			results[i][1] = sc.nextInt();
		}
		
		System.out.println(solution(n, results));
	}

}
