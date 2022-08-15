package week1_정원철;
import java.util.ArrayList;
import java.util.Arrays;

public class Lv2_기능개발 {

    public static int[] solution(int[] progresses, int[] speeds) {
        //배포될 기능개수를 받을 arrayList 선언
    	ArrayList<Integer> test= new ArrayList<>();
    	
    	//소요되는 날짜를 기록할 배열의 사이즈
    	int N=progresses.length;
    	//소요되는 날짜를 저장할 배열 선언
    	int []days=new int[N];
    	
    	//소요되는 일자를 계산하는 part
    	for(int i=0; i<N; i++) {
    		// 100%를 기준으로 이미 진행된 pro를 빼고, speed로 나눠 반올림하여 소요일을 계산 => 배열 삽입 
    		int sub=100-progresses[i];
    		int day=(int) Math.ceil(sub/(double)speeds[i]);
    		days[i]=day;
    	}
    	
    	
    	
    	// 소요 날짜 첫 배열 temp에 저장
    	int temp=days[0];
    	// 기능수를 카운트, 뭐가됐든 1이 시작이니까 미리 선언
    	int cnt=1;
    	
    	//temp에 미리 첫 원소를 저장했기에 인덱스 1부터 시작
    	for (int i=1; i<days.length; i++) {
    		
    		// temp가 현 원소보다 작게되면
    		if (temp<days[i]) {
    		// 바로 기능수를 test에 추가
    			test.add(cnt);
    		// 다시 카운트는 원상복귀
    			cnt=1;
    		// temp에 다음 비교를 위해 현 값 삽입
    			temp=days[i];
    		
    		// 같거나 크게되면 기능수를 추가(=가 중요하다, 같은 값 처리를해야한다)
    		}else if(temp>=days[i]) {
    			cnt++;
    		}
    		// 마지막 원소를 기준으로 이전에 누적된 카운터를 추가
    		if (i==days.length-1) {
				test.add(cnt);
			}
    		
    	}
    	
		 int[] answer = new int[test.size()];
		 for (int i=0; i<test.size(); i++) {
			 answer[i]=test.get(i);
		 }
    	
    	
    	return answer;
    }
	
	public static void main(String[] args) {
		int arr[]= {95, 90, 99, 99, 80, 99};
		int arr2[]= {1, 1, 1, 1, 1, 1};
		
		int arr3[]= {93, 30, 55};
		int arr4[]= {1, 30, 5};
		
		int arr5[]= {99, 99, 99};
		int arr6[]= {1, 1,1};
		 System.out.println(Arrays.toString(solution(arr, arr2)));
		
	
	}

}
