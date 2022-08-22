package week3_강수지;

class P43162_네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // n개수만큼 visited 초기화 !
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            // 방문하지 않은 노드가 있다면 dfs를 호출하고 answer++ !
            if (visited[i]==false){
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    } // solution end
    
    static void dfs(int i, int[][] computer, boolean[] visited){
        visited[i] = true; // 해당 노드를 방문처리해주고
        
        for(int j=0;j<computer.length;j++){
            // 자기 자신이 아니고 값이 1이면 아직 방문하지 않은 경우
            if(computer[i][j]==1 && visited[j]==false){
                dfs(j, computer, visited);
            }
        }
    }//dfs end
}

