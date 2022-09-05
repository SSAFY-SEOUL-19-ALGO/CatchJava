package week3_김영서;

public class p43162_네트워크 {
	boolean visited[];

	void dfs(int index,int[][]computers) {
		visited[index]=true;
		for(int i =0;i<computers.length;i++) {
			if(visited[i] == false && computers[index][i]==1) {
				dfs(i,computers);
			}
		}
	}

	
	public int solution(int n, int[][] computers) {
		visited = new boolean[n];
		//네트워크 갯수
		int answer =0;
		for(int i=0;i<n;i++) {
			if(visited[i]==false) {
				answer++;
				dfs(i,computers);
			}
		}
		
		
		return answer;
	}
}