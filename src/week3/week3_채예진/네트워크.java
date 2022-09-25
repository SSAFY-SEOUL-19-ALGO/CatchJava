package week3.week3_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 네트워크 {

	static boolean[] visited;
	static void dfs(int i, int[][] computers) {
		visited[i] = true; // 도착 
		
		for (int j = 0; j < computers[i].length; j++) {
			if (i != j && !visited[j] && computers[i][j] == 1) { // 자기 자신이 아니고, 아직 탐색이 안 되었으며, 1로 탐색 가능한 곳일 경우 
				dfs(j, computers);
			}
		}
	}
	
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
        	if (!visited[i]) {
        		dfs(i, computers);
        		answer++;
        	}
        }
        
        return answer;
    }
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] computers = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				computers[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		System.out.println(solution(n, computers));
	}

}
