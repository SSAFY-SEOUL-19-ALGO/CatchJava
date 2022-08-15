package week2_정원철;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Lv2_큰수만들기 {

	static String solution(String number, int k) {
		// 숫자 문자열을 받을 스트링빌더 선언 for easy delete
		StringBuilder answer = new StringBuilder(number);
		
		// 앞뒤문자와의 크기비교를 통해 나타낼 카운터와 인덱스 변수 선언
		int cnt = 0;
		int idx = 1;
		
		while(cnt != k) {
			// 삭제 할 자리수 k만큼 카운터가 증가할때까지 반복 (=그만큼 삭제)

			
			// 앞과 뒷 숫자를 비교해서 뒤에 위치한 숫자가 더크게되면 바로앞에 위치한 숫자는 제거한다. (카운트 ++)
			// 제거하게 되면 다시 인덱스를 하나 물러서게 만들고(인덱스 --) 다른 수와 비교다시 
			if(idx  >= 1 && answer.charAt(idx -1) < answer.charAt(idx )) {
				answer.deleteCharAt(idx -1);
				idx  --;
				cnt ++;
			}
			else {
				// 인덱스가 마지막을 가리킬경우
				if(idx  == answer.length() - 1 && answer.charAt(idx ) <= answer.charAt(idx -1)) {
					answer.deleteCharAt(idx );
					cnt ++;
					idx  --;
				}
				else {
					idx  ++;
				}
			}
		}
		
		return answer.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
		
		
		
	}
	
}
