package week2_강수지;

public class P42883_큰수만들기 {
	public String solution(String number, int k) { // 시간초과 난다 .. 그리디인 이유를 생각해 ..
	        // 앞자리를 가장 큰 수로 만들면 된다 ..
	        StringBuilder answer = new StringBuilder(); // 숫자 더하기 편하게 
	        int len = number.length()-k; // 만들어야하는 길이
	       
	        int max = 0; // 가장 큰 값
	        int idx = 0; // 가장 큰 수의 인덱스
	        for(int i=0;i<len;i++){ // 구해야하는 길이 만큼돌며
	            max = 0;
	            for(int j=idx;j<=i+k;j++){ // 가장 큰 수를 찾는다
	                if(max<number.charAt(j)-'0'){
	                    max = number.charAt(j)-'0';
	                    idx = j+1; // 가장 큰 수를 찾으면 그 이후부터 또 찾기
	                }
	            }
	            answer.append(max);
	        }
	        return answer.toString();
	    }
	}
