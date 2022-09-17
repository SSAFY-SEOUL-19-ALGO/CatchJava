package week3_정원철;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_게임맵최단거리 {
// 	처음 큐
//	탐색방향은 4가지 상하좌우 구현 -> 목적지를 만날때까지 반복
	
//	벽을 부딪히거나, 범위를 넘어가는경우 -> 제외
	
//	BFS를통해 가장 먼저 찾은 목적지가 최적의 거리
//  0은 벽 
	static int[][] maps;
	static public int solution(int[][] maps){
        // map 행,열 사이즈 들어감
		int x = maps.length; 
        int y = maps[0].length;
        
        int answer=0;
        
        // 방문 체크배열 선언
        int[][] visited = new int[x][y];

        
        // 탐색을 위한 큐 선언 (좌표와 카운트 담긴 인트배열 받을)
        Queue<int[]> que = new ArrayDeque<int[]>();
        
        // 0,0에서 시작 -> 끝끝 도착
        
        // 행 좌표, 열 좌표, 카운트 1시작
        que.add(new int[]{0,0,1});

        while(0 < que.size()){
            int[] quePop = que.poll();

            // 출발시작
            int x_new = quePop[0];
            int y_new = quePop[1];
            int result = quePop[2]; //cnt개념(이동횟수)
            
            // 도착지에 도착하게 되면 끝, 먼저 조건에 맞게 반환되는 값이 정답 -> 최단거리이기때문 
            if(x_new == x - 1 && y_new == y - 1){
            	answer=result;
            	return answer;
            }
            
            // 대각선은 움직이지 못하기때문에 상하좌우만 고려하면된다.
            
            // 각 if로 설정해 나는 자리에 바로바로 갈수있도록  
            // 하의 경우 윗 방향이 인덱스 범위를 넘어가지 않으면 
            if(x_new + 1 < x){
            	// 이동한 맵이 벽이 아니고, 방문한 기록이 없다면
                if(maps[x_new+1][y_new] == 1 && visited[x_new+1][y_new] == 0){
                    visited[x_new+1][y_new] = 1; // 해당위치 방문처리
                    que.add(new int[]{x_new+1, y_new, result + 1}); // 큐에 해당 인덱스와 이동 카운터+1
                }
            }

            // 우 의 경우
            if(y_new + 1 < y){
            	// 이동한 맵이 벽이 아니고, 방문한 기록이 없다면
                if(maps[x_new][y_new+1] == 1 && visited[x_new][y_new+1] == 0){
                    visited[x_new][y_new+1] = 1;
                    que.add(new int[]{x_new, y_new+1, result + 1});
                }
            }

            //상의 경우
            if(0 <= x_new - 1){
                if(maps[x_new-1][y_new] == 1 && visited[x_new-1][y_new] == 0){
                    visited[x_new-1][y_new] = 1;
                    que.add(new int[]{x_new-1, y_new, result + 1});
                }
            }

            //좌의 경우
            if(0 <= y_new - 1){
            	// 이동한 맵이 벽이 아니고, 방문한 기록이 없다면
                if(maps[x_new][y_new-1] == 1 && visited[x_new][y_new-1] == 0){
                    visited[x_new][y_new-1] = 1;
                    que.add(new int[]{x_new, y_new-1, result + 1});
                }
            }
        }

        answer=-1;
        return answer;
    }
	public static void main(String[] args) {
		
		maps=new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}

}
