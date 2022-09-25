package week3.week3_김영서;

import java.util.Arrays;


public class p49191_순위 {
	public static void main(String[] args) {
		int[][]arr = {{4,3},{4,2},{3,2},{1,2},{2,5}};
		System.out.println(solution(5,arr));
	}
	
	public static int solution(int n, int[][] results) {
        int answer = 0;
        int check=0;
        int[][]arr = new int[n][n];

        //그래프 행렬로 만들기 이기면 1, 지면 -1로 표시
        for(int[]a:results){
            	arr[a[0]-1][a[1]-1]=1;
            	arr[a[1]-1][a[0]-1]=-1;
        }
        
        for(int a=0;a<n;a++) {
        	for(int b=0;b<n;b++) {
        		for(int c=0;c<n;c++) {
        			//b>a && a>c -> b>a>c
        			if(arr[b][a] == 1 && arr[a][c]==1) {
        				arr[b][c] =1;
        			}
        			//b<a && a<c -> b<a<c
        			if(arr[b][a]==-1 && arr[a][c]==-1) {
        				arr[b][c]=-1;
        			}
        		}
        	}
        }

   
        for(int i=0;i<n;i++) {
        	check=0;
        	for(int j=0;j<n;j++) {
        		if(arr[i][j] == 0) {
        			check++;
        		}
        	}
        	//arr의 행이 자기자신빼고 -1 또는 1로 다 채워져 있으면 순위를 알 수 있따!
        	if(check==1) {
            	answer++;
            }
        }
        return answer;
    }
}