package week1.week1_정원철;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Lv2_주식가격 {
    public static int[] solution(int[] prices) {
        
    	// 가격이 떨어지지 않은 시간을 담는 배열
    	int answer[]=new int[prices.length];
    	// 이전 가격을 담는 배열
    	int temp=0;
    	// 오른 시간을 담는 카운터
    	int cnt;
    	
    	// 배열의 길이만큼일단 반복
    	for (int i=0; i<prices.length; i++) {
    		// cnt는 일단 0으로 설정
    		cnt=0;
    		// 다음과 비교할 앞 원소값을 tmp에 저장
    		temp=prices[i];
    		// 앞전 원소부터 마지막까지 반복적으로 계산하기위해 이중 반복자에 i+1 대입
    		for (int j=i+1; j<prices.length;j++) {
    			// 뒤 원소가 크거나 같으면 cnt 상승
    			if(temp<=prices[j]) {
    				cnt++;
    			// 작으면 카운터를 추가하고 반복문 탈출하여 결과값 삽입 (뒤 바로 원소가 작더라도, 한칸 차이라도 1은 부여)
    			}else {
    				cnt++;
    				break;
    			}
    		}
    
    		answer[i]=cnt;
    	}
    	

    	return answer;
    }
    
	public static void main(String[] args) {
		
		int price[]= {1,2,3,2,3};
		System.out.println(Arrays.toString(solution(price)));
		
	}

}
