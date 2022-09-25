package week6.week6_조민수;

import java.util.ArrayDeque;
import java.util.Queue;

class 등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        Queue <int[]> path=new ArrayDeque<int[]>();//경로저장 큐
        path.add(new int[]{1,1});//출발점 저장
        int[][] map= new int[n+1][m+1];
        boolean[][] puddle=new boolean[n+1][m+1];
        for(int i=0;i<puddles.length;i++) {
        	puddle[puddles[i][1]][puddles[i][0]]=true;
        }
        for(int i=1;i<=n;i++) {
        	if(puddle[i][1]) {//내가 물웅덩이면 !!테두리가 물이면 그 다음은 다 물로 취급해야됨,,,
                break;
    		}
        	map[i][1]=1;
        }
        for(int j=1;j<=m;j++) {
           	if(puddle[1][j]) {//내가 물웅덩이면 
                 break;
            }
        	map[1][j]=1;
        }
        //테두리는 1
        for(int i=2;i<=n;i++) {
        	 for(int j=2;j<=m;j++) {
        		if(puddle[i][j]) {//내가 물웅덩이면 
        			map[i][j]=0;
        		}
        		else {
        			map[i][j]=map[i-1][j]+map[i][j-1];
                    if (map[i][j] > 1000000007) {
                        map[i][j] %= 1000000007;
                    }
        		}	
             }
        }
        answer=map[n][m];
        return answer;
    }
}