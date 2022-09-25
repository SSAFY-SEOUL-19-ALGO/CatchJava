package week3.week3_박건우;

public class P43162_네트워크 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class Solution_P43162 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	if(check[i] == false) {
        		dfs(computers, i, check);
        		answer++;
        	}
        }
        return answer;
    }
    
    boolean[] dfs(int[][] computers, int i, boolean[] check) {
    	check[i] = true;
    	
    	for(int j = 0; j < computers.length; j++) {
    		if(i != j && computers[i][j] == 1 && check[j] == false) {
    			check = dfs(computers, j, check);
    		}
    	}
    	return check;
    }
}
