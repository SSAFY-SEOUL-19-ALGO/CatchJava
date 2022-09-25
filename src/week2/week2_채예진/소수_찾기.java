package week2.week2_채예진;

import java.util.HashSet;
import java.util.Scanner;

public class 소수_찾기 {

	static String[] numberList;
	static int N, R, totalCnt;
	static String[] permList;
	static boolean[] isSelected;
	static HashSet<Integer> set; // 중복 제거하기 위함 
	
	public static boolean isPrime(int num) { // 소수 확인 
		if (num <= 1) { // 0과 1은 소수가 아니다 
			return false;
		}
		
		for (int i = 2; i <= (int)Math.sqrt(num); i++) { // 에라테네토스의 체 
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static void permutation(int cnt) { // 순열 생성 
		
		if(cnt == R) {
			int value = Integer.parseInt(String.join("", permList));
			if(isPrime(value)) {
				set.add(value);
			}
			return;
		}
		
		// 가능한 모든 수에 대해 시도
		for (int i = 0; i < N; i++) { // 선택지
			// 시도하는 수가 선택되었는지 판단 
			if (isSelected[i]) continue;
			// 선택되지 않았다면 수를 사용
			permList[cnt] = numberList[i];
			isSelected[i] = true;
			// 다음 수 뽑으러 가기 
			permutation(cnt + 1);
			// 사용했던 수에 대한 선택 되돌리기 
			isSelected[i] = false;
		}
	}
	
	public static int solution(String numbers) {
        numberList = numbers.split("");
        N = numbers.length();
		
		isSelected = new boolean[N];
		set = new HashSet<>();
	
        for(int i = 1; i <= N; i++) {
        	R = i;
        	permList = new String[R];
    		permutation(0); // 순열 생성 
        }
        
        return set.size(); // set size 
    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String numbers = sc.next();
		
		System.out.println(solution(numbers));
	}

}
