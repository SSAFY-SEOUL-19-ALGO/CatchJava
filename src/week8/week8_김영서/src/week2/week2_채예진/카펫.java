package week2.week2_채예진;

import java.util.Arrays;
import java.util.Scanner;

public class 카펫 {

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalCarpet = brown + yellow;
        
        for (int col = 3; col <= Math.sqrt(totalCarpet); col++) { // 3부터인 이유는 갈색은 8부터 노란색은 1부터이기 때문에 무조건 3*3 -> 9가 시작이기 때문이다. 세로가 더 작아야하기 때문에 세로는 무조건 루트 전체 합보다 작다. 
        	int row = totalCarpet / col; // 가로는 전체 / 세로 
        	
        	if ((row - 2) * (col - 2) == yellow) { // 갈색은 무조건 테두리 1줄, 중앙은 노란색이기 때문에 
        		answer[0] = row;
        		answer[1] = col;
        		return answer;
        	}
        }
        return answer;
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int brown = sc.nextInt();
		int yellow = sc.nextInt();
		
		System.out.println(Arrays.toString(solution(brown, yellow)));
	}

}