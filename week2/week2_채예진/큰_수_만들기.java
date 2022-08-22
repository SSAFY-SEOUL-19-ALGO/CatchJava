package week2_채예진;

import java.util.Scanner;

// 런타임 오류.. 시간초과.. 등 많이 나서.. 구글의 도움 받았어여ㅜㅜ
// https://born2bedeveloper.tistory.com/27
public class 큰_수_만들기 {

    public static String solution(String number, int k) {

    	StringBuilder sb = new StringBuilder();
        int len = number.length() - k; // 리턴해야하는 문자열의 길이 
        int start = 0; // 시작 
        
        while(start < number.length() && sb.length() < len) { // 검색 시작이 문자 길이보다 작아야하고, sb.length는 리턴해야하는 문자열보다 작을 때까지만 돌린다. 
            int leftNum = k + sb.length() + 1; // 건드리지 않을 값의 시작 위치 
            int max = 0; // 최댓값 
            for (int j = start; j < leftNum; j++) { // 검색 시작지점부터 고치지 않을 문자열 전까지 
                if (max < number.charAt(j) - '0') { // max 값 교체 
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            sb.append(max);
    	}
        return sb.toString();
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int K = sc.nextInt();
		System.out.println(solution(number, K));
	}

}
