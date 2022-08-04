package week1_정원철;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Lv2_더맵게 {
	  public static int solution(int[] scoville, int K) {
	        // 정보를 담을 우선순위큐 선언 (기본적으로 오름차순)
	        PriorityQueue<Integer> test=new PriorityQueue<>();
	        int cnt=0;
	        int answer = 0;
	        // 주어진 데이터 배열의 값을 뽑아 test 큐에 삽입
	        for (int sc: scoville)
	            test.add(sc);
	        
	        // 큐의 맨 선두 값이 정해진 수 K보다 커질때까지 수행 
	        while (test.peek()<=K){
	            // 큐의 크기가 1이하로 떨어지게되면 원하는 진행을 할수없기에, 설명대로 -1을 반환
	            if(test.size()<=1){
	                return -1;
	            }
	            //맨앞 가장 작은 값을 minNum, 다음 작은 값을 midMinNum에 삭제 반환
	            int minNum=test.poll();
	            int midMinNum=test.poll();
	            // 재 조합
	            int mixed=minNum+(midMinNum*2);
	            cnt+=1;
	            test.add(mixed);
	        }
	        
	        answer = cnt;
	        return answer;
	    }
	public static void main(String[] args) {
		
		int[] scoville= {1,2,3,9,10,12};
		int K=7;
		
		System.out.println(solution(scoville, K));
	
	}
	

	

}

//      

//      answer = cnt;

//      return answer;
/*		PriorityQueue<Integer> heap= new PriorityQueue<>();
		
		heap.add(1); // add() 추가
		heap.add(2); // 예외를 던짐
		heap.add(3);
		heap.add(4);
		heap.add(5);
		
		heap.offer(1); // offer() 추가
		heap.offer(2); // 값을 리턴 (true of return)
		heap.offer(3);
		heap.offer(4);
		heap.offer(5);
		
		
		System.out.println(heap.element()); // element() 가장 앞에있는 것 반환	, 예외 던짐
		System.out.println(heap.peek()); // peek() 가장 앞에있는 것 반환, 값을 리턴 
		
		heap.remove(); // 예외 발생
		heap.poll(); // 값 리턴
*/		

