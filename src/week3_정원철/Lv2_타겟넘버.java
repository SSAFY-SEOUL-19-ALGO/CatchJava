package week3_정원철;

public class Lv2_타겟넘버 {
	
	static int numbers[];
	static int target, answer=0;
	
	// +,-연산의 조합을 통해서 타겟값을 찾아감!
	// 아래와 같이 반복해가면서 연산결과를 비교하며 답을 찾아간다.
	
	
	//전개 (예를 들어 인덱스 범위가 3일때==길이가 3일때)
	//+++ 체크
	//++- 체크
	//+-+ 체크
	//+-- 체크
	//-++ 체크
	//-+- 체크
	//--+ 체크
	//--- 체크
	
	
	static void test(int index, int sum) { // (시작인덱스, 누적합)
		if(index==numbers.length) {		// 인덱스 만큼 돈다음
			if(sum==target) answer++;	//	sum이 타겟과 같다면 cnt 추가
			return;
		}
		
		
		//해당과정을 찾아가면서 target과 같은 연산을 찾아나간다. easy
		// 더하는 경우 
		test(index+1,sum+numbers[index]);
		// 빼는 경우
		test(index+1,sum-numbers[index]);
		

	}
	
	
	static int solution(int[] numbers, int target) {

	
		test(0,0);
	
	 return answer;

	 }
	public static void main(String[] args) {

		numbers=new int[]{1, 1, 1, 1, 1};
		target=3;
		System.out.println(solution(numbers, target));

	}

}
