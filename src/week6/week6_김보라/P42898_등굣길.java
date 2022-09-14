package week6_김보라;

import java.util.LinkedList;
import java.util.Queue;

public class P42898_등굣길 {
	// 집에서 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 return 하도록 solution 함수를 작성해주세요.
	//이게 뭔소리람......

	public static void main(String[] args) {
		System.out.println(solution(4,3,new int[][] {{2,2}}));
	}
	static int solution(int m, int n, int[][] puddles) {
		//자... 다시 dp로 해보자.......
		//오른쪽아래로만 움직이기..
		
		boolean[][] p = new boolean[m][n];
		for(int i = 0; i<puddles.length;i++) {
			p[puddles[i][0]-1][puddles[i][1]-1]=true;
		}
		int[][] dp = new int[m][n];
		dp[0][0]=1;
		for(int i = 0; i<m; i++) {
			for(int j = 0; j<n; j++) {
				if(p[i][j]) {
					dp[i][j]=0;
				}else {	//여기 조건 생각나는대로 적어서 정리하고싶은데 일단 좀 귀찮아
					//그냥 1부터 시작하게 놔뒀으면 검사 안해도 됐는데...........
					if(i==0&&j==0)
						continue;
					if(i==0) {
						dp[i][j]=dp[i][j-1];
					}
					if(j==0) {
						dp[i][j]=dp[i-1][j];
					}
					if(i!=0&&j!=0) {
						dp[i][j]=dp[i-1][j]+dp[i][j-1];
						dp[i][j]%=1000000007;	//아무튼 문제에서 그러라고 했으니까..
					}
				}
			}
		}
		
		return dp[m-1][n-1];
	}
	/*문제 dp로 구분된거 볼때부터 안될줄 알았지만 정말 안되네... 정확성 8 시간초과, 효율성 전부 시간초과
	static int solution(int m, int n, int[][] puddles) {
		boolean visited[][] = new boolean[m][n];
		
		for(int i = 0; i<puddles.length; i++) {
			visited[puddles[i][0]-1][puddles[i][1]-1]=true;
		}
		
		Queue<int[]> q =new LinkedList<int[]>();
		visited[0][0]=true;
		q.add(new int[] {0,0});
		
		int answer = 0;
		int cnt=0;
		int min = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int s = 0; s<size; s++) {
				
				int x = q.peek()[0];
				int y = q.poll()[1];
//				System.out.print(x+" "+y+" / ");
				
				if((x+1==m-1&&y==n-1)||(x==m-1&&y+1==n-1)) {
					min=Math.min(cnt, min);
					if(cnt==min)
						answer++;
				}
				
				if(x+1<m&&!visited[x+1][y]) {
//					visited[x+1][y]=true;
					q.add(new int[] {x+1,y});
				}
				if(y+1<n&&!visited[x][y+1]) {
//					visited[x][y+1]=true;
					q.add(new int[] {x,y+1});
				}
			}
			cnt++;
//			System.out.println();
		}
//		System.out.println(cnt);
		
        return answer%1000000007;
    }
*/
}
