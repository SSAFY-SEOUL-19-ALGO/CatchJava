package week3_강수지;

class P49191_순위  {
    public int solution(int n, int[][] results) { // 플로이드 워셜 .. 알고리즘 공부하면 좋은 문제
        int answer = 0; // 순위를 매길 수 있는 노드가 몇 개인지
        int[][] graph = new int[n+1][n+1];
        
        for(int i=0;i<results.length;i++){
            graph[results[i][0]][results[i][1]] = 1; // 이김
        }
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=n;k++){
                    if(graph[j][i] ==1 && graph[i][k]==1)  // j > i 이고 i > z 이니까
                        graph[j][k] = 1; // j 는 당연히 k 를 이긴다 !

                }
            }
        }
        
        for(int i=1;i<=n;i++){ // 선수는 1번부터 있으니까
            int cnt = 0;
            for(int j=1;j<=n;j++){
                if(graph[i][j] ==1 || graph[j][i] ==1)
                    cnt++;
            }
            if(cnt == n-1){ // n 번 선수의 순위를 매기기 위해 n-1 개 정보를 알아야한다
                answer++;
            }
        }
        
        return answer;
    }
}
