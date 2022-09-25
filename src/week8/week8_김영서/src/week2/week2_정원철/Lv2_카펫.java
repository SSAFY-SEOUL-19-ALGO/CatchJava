package week2.week2_정원철;

import java.util.Arrays;

public class Lv2_카펫 {
	static int b, garo, sero, chk;
    public static int[] solution(int brown, int yellow) {
        
    	// 반환할 결과값 저장할 배열
    	int[] answer =new int[2];
    	
    	// 갈색, 노랑 카펫 개수 합 
    	int total=brown+yellow;
    	
    	// 구조상 한변이 3미만이 될수없음, 3부터 시작
    	for (int a=3; a<total; a++) {
   		
    			b=total/a;	
			
    		if (b>=3 && total%a==0) {
    			garo=Math.max(a, b);
    			sero=Math.min(a, b);
    			
    			if (((garo-2)* (sero-2))==yellow) {
    				answer[0]=garo;
    				answer[1]=sero; 				
    			}
    		}

    	}
        
        return answer;
    }
    
	public static void main(String[] args) {
	
		System.out.println(Arrays.toString(solution(24, 24)));

	}

}
