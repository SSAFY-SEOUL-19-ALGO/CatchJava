package week3_정원철;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_게임맵최단거리 {
		
	static int[][] maps;
	static public int solution(int[][] maps){
        int rows = maps.length;
        int columns = maps[0].length;
        int answer=0;
        
        int[][] visited = new int[rows][columns];

        Queue<int[]> que = new ArrayDeque<int[]>();
        que.add(new int[]{0,0,1});

        while(0 < que.size()){
            int[] quePop = que.poll();

            int row = quePop[0];
            int column = quePop[1];
            int result = quePop[2];
            
            // 먼저 조건에 맞게 반환되는 값이 정답 -> 최단거리이기때문 
            if(row == rows - 1 && column == columns - 1){
                
            	answer=result;
            	return answer;
            }

            if(row + 1 < rows){
                if(maps[row+1][column] == 1 && visited[row+1][column] == 0){
                    visited[row+1][column] = 1;
                    que.add(new int[]{row+1, column, result + 1});
                }
            }

            if(column + 1 < columns){
                if(maps[row][column+1] == 1 && visited[row][column+1] == 0){
                    visited[row][column+1] = 1;
                    que.add(new int[]{row, column+1, result + 1});
                }
            }

            if(0 <= row - 1){
                if(maps[row-1][column] == 1 && visited[row-1][column] == 0){
                    visited[row-1][column] = 1;
                    que.add(new int[]{row-1, column, result + 1});
                }
            }

            if(0 <= column - 1){
                if(maps[row][column-1] == 1 && visited[row][column-1] == 0){
                    visited[row][column-1] = 1;
                    que.add(new int[]{row, column-1, result + 1});
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
