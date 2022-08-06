package week1_강수지;

public class P42586_기능개발 {
	class Solution {
	    public int[] solution(int[] progresses, int[] speeds) {
	        int[] tmp = new int[100]; // 작업의 개수 100개 
	        int day = 0; // 작업일수
	        
	        for(int i=0;i<progresses.length;i++){ // 주어진 작업량만큼 돌며
	            while(progresses[i]+(speeds[i]*day) < 100){
	                // 배포되지 못하는 경우에는 일수를 증가
	                day++;
	            }
	            tmp[day]++; // 만약 배포할 수 있는 상태라면 그 일수에 작업량을 더해줌
	        }    
	        
	        int cnt = 0; // 배포된 작업수
	        for(int e: tmp){
	            if(e!=0){ // 만약에 배포된 작업이 있다면 세어준다 > answer 배열 크기 설정을 위해
	                cnt++;
	            }
	        }
	            
	        int[] answer = new int[cnt]; // 배포된 개수만큼 답 .. 넣어줘 ..
	        cnt = 0; // 다시 초기화 ..
	        for(int e:tmp){ // tmp 를 돌며 배포된 작업이 있는 경우
	            if(e!=0){
	                answer[cnt++] = e; // 인덱스는 하나 작기때문에 cnt++ 를 해서 넣어준다
	            }
	        }
	        
	        return answer;
	    }
	}
}
