package week7.week7_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2578_빙고 {
	static int [][] arr = new int[5][5]; // 빙고판
	static int num; // 숫자 부른 횟수
	static int count; // 빙고 갯수
	
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	// 빙고판 입력
    	for(int i = 0; i < 5; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			arr[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// 숫자 하나씩 부름
    	for(int i = 0; i < 5; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 5; j++) {
    			num++;
    			bingo(Integer.parseInt(st.nextToken()));
    			bingoCheck();
    			if(count >= 3) {
    				System.out.println(num);
    				return;
    			}
    		}
    	} 	
    }
    
    // 부른 숫자 지움 처리 (-1)
    public static void bingo(int n){
    	for(int i = 0; i < 5; i++) {
    		for(int j = 0; j < 5; j++) {
    			if(arr[i][j] == n) {
    				arr[i][j] = -1;
    			}
    		}
    	}
    }
    
    // 빙고 갯수 검사
    public static void bingoCheck() {
    	count = 0;
    	int row = 0; // 가로 빙고 
    	int col = 0; // 세로 빙고
    	int xy = 0; // 오른쪽 아래로 가는 대각선
    	int yx = 0; // 왼쪽 아래로 가는 대각선
    	int index = 0;
    	for(int i = 0; i < 5; i++) {
    		row = 0;
    		col = 0;
    		for(int j = 0; j < 5; j++) {			
    			row += arr[i][j];
    			col += arr[j][i];
    			
    			if(i == j) {
    				xy += arr[i][j];
    			}
    			if(i == index && j == 4 - index) {
    				yx += arr[i][j];
    				index++;
    			}
    		}
    		if(row == -5) {
    			count++;
    		}
    		if(col == -5) {
    			count++;
    		}
    		if(xy == -5) {
    			count++;
    		}
    		if(yx == -5) {
    			count++;
    		}
    	}
    }
}