package week3_김영서;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class p49189_가장먼노드 {
	public static void main(String[] args) {
		int[][]arr = {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
		System.out.println(solution(6,arr));
	}
	
	public static int solution(int n, int[][] edge) {
		int answer = 0;
		boolean [] check = new boolean[n];
		boolean [][] connect = new boolean[n][n];
		Queue<Integer> q = new LinkedList<>();
		
		//연결된 애들은 true로 설정
		for(int[]i:edge) {
			connect[i[0]-1][i[1]-1]=true;
			connect[i[1]-1][i[0]-1]=true;
		}
		//System.out.println(Arrays.deepToString(connect));
		check[0] = true;
		q.add(0);
		
		while(!q.isEmpty()) {
			//q사이즈 저장하기. 더 들어갈 수 있으면 들어가기.
			int qsize = q.size();
			
			//큐에 들어가 있는 원소만큼 뽑아서 연결되었는지, 사용되지 않았는지 확인 후 큐에 넣기
			for(int i=0;i<qsize;i++) {
				int now = q.poll();
				for(int j=0;j<n;j++) {
					if(connect[j][now]&& !check[j]) {
						check[j] = true;
						q.add(j);
//						System.out.println(q.size());
					}
				}
			}
			answer = qsize;
		}
		return answer;
	}
}