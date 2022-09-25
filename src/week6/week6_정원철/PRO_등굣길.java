package week6.week6_정원철;

import java.util.Collections;

public class PRO_등굣길 {

	// 물 -1로 초기화 -> 시작위치는 당연히 1 -> 해당 해별에서 웅덩이 위치면 0을 줘버려 -> 최위, 최왼 제외 이전값 + -> 반복하여 
	// 라스트값을 결과로 출력

	static int solution(int m, int n, int[][] puddles){
		int D[][]= new int[m][n];
		for(int i=0; i<puddles.length; i++) {
			D[puddles[i][0]-1][puddles[i][1]-1]=-1; // 물골짜기 설정
		}

		//시작위치 1
		D[0][0]=1;

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {

				if(D[i][j]==-1) {
					D[i][j]=0;
					continue;
				}


				if(i!=0) {
					D[i][j]+=D[i-1][j]% 1000000007;
				}

				if(j!=0) {
					D[i][j]+=D[i][j-1]% 1000000007;
				}

			}
		}

		return D[m-1][n-1]% 1000000007;
    }

	public static void main(String[] args) {
		System.out.println(solution(4, 3,new int [][]{{2,2}}));

	}

}