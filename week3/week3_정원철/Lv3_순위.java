package week3_정원철;

public class Lv3_순위 {
	
	static int n;
	static int[][] results;
	
	public static int solution(int n, int[][] results) {
        // 플로이드 알고리즘 이용
        int answer = 0;

        int[][] test = new int[n + 1][n + 1];

        // -1 로 초기화
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                test[i][j] = -1;
            }
        }

        // 이김 1 , 짐 0
        for (int i = 0; i < results.length; i++) {
            test[results[i][0]][results[i][1]] = 1;
            test[results[i][1]][results[i][0]] = 0;
        }

        
        for (int k = 1; k < n + 1; k++) {
              for (int i = 1; i < n + 1; i++) {
                if(k == i) continue;
                for (int j = 1; j < n + 1; j++) {
                    if (i == j || k == j) continue;
                    if(test[i][k] == 0 && test[k][j] == 0) test[i][j] = 0;
                    else if(test[i][k] == 1  && test[k][j] == 1) test[i][j] = 1;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            boolean chk = true;
            for (int j = 1; j < n + 1; j++) {
                if (i == j)
                    continue;
                if (test[i][j] == -1) {
                    chk = false;
                    break;
                }
            }
            if (chk)
                answer++;
        }

        return answer;
    }
	public static void main(String[] args) {
		results = new int[][]{ { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
		n=5;
		System.out.println(solution(n, results));
	}

}
