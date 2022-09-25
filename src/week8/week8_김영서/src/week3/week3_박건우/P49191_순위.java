package week3.week3_박건우;

public class P49191_순위 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Solution_49191 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int map[][] = new int[n+1][n+1];
        
        for(int i = 0; i < results.length; i++) {
        	int A = results[i][0];
        	int B = results[i][1];
        	
        	map[A][B] = 1;
        	map[B][A] = -1;
        }
        
        for(int i = 1; i <= n; i++) {
        	for(int j = 1; j <= n; j++) {
        		for(int k = 1; k <=n; k++) {
                	if(map[i][k] == 1 && map[k][j] == 1) {
                		map[i][j] = 1;
                		map[j][i] = -1;
                	}
                	if(map[i][k] == -1 && map[k][j] == -1) {
                		map[i][j] = -1;
                		map[j][i] = 1;
                	}
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
    		int cnt = 0;
    		for(int j = 1; j <= n; j++) {
    			if(map[i][j] != 0) 
    				cnt++;
    		}
    		if(cnt == n-1)
    			answer++;
    	}
        
        return answer;
    }
}
