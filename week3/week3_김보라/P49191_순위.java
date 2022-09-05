package week3_김보라;

public class P49191_순위 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}}));

	}
	//플루이드-와샬
	static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] data = new int[n+1][n+1];
        
        for(int i = 0; i<results.length; i++) {
        	data[results[i][0]][results[i][1]]=1;//이김
        	data[results[i][1]][results[i][0]]=-1;//짐
        }
      
        
        for(int i = 1; i<=n; i++) {
        	for(int j = 1; j<=n; j++) {
        		for(int N=1; N<=n; N++) {
        			if(data[i][N]==-1&&data[N][j]==-1) {
        				data[i][j]=-1;
        				data[j][i]=1;
        			}
        			if(data[i][N]==1&&data[N][j]==1) {
        				data[i][j]=1;
        				data[j][i]=-1;
        			}
        		}
        	}
        }
//        for(int i = 1; i<=n; i++) {
//        	for(int j = 1; j<=n; j++) {
//        		System.out.print(data[i][j]+" ");
//        	}System.out.println();
//        }
        
        
        for(int i = 1; i<=n; i++) {
        	int cnt=0;
        	for(int j = 1; j<=n; j++) {
        		if(data[i][j]==0) {	//결과를 알 수 없는 개수
        			cnt++;
        		}
        	}
        	if(cnt==1)	//그게 자신과의 싸움밖에 없다면
        		answer++;	//순위를 매길 수 있음
        }
        return answer;
    }
}
