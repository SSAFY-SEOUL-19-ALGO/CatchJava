package week9.week9_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ17609_회문 {

    // 문자열의 특정부분이 회문인지 판별하는 메소드
    static boolean isPalindrome(String s, int start, int end) {
        while(start < end) {    // 시작 인덱스가 끝 인덱스보다 작을동안 반복
            if(s.charAt(start) == s.charAt(end)) {  // 앞 문자와 뒷문자가 같으면
                start++;    // 시작 인덱스 증가
                end--;  // 끝 인덱스 감소
            } else {    // 다르면
                return false;   // 회문이 아니므로 false 반환
            }
        }
        return true;    // 회문이면 true 반환
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 테스트 케이스 반복
            String s = br.readLine();   // 문자열 입력
            int flag = 0;   // 판단 결과를 나타내는 변수
            int start = 0;  // 맨 앞의 인덱스
            int end = s.length()-1; // 맨 뒤의 인덱스
            while(start < end) {    // start가 end보다 작을 동안 반복
                if(s.charAt(start) == s.charAt(end)) {  // 앞의 문자와 뒤의 문자가 같으면
                    start++;    // 앞 인덱스 증가
                    end--;  // 뒤 인덱스 감소
                } else {    // 앞과 뒤 문자가 다르면
                    if(isPalindrome(s, start+1, end)    // 앞 인덱스의 다음부터 끝인덱스까지가 회문이거나
                        || isPalindrome(s, start, end-1)) { // 앞인덱스부터 끝인덱스 이전까지가 회문이면
                        flag = 1;   // 유사회문이므로 flag에 1 저장
                    } else {    // 둘다 아니라면
                        flag = 2;   // 회문이 아니므로 flag에 2 저장
                    }
                    break;
                }
            }
            sb.append(flag).append("\n");
        }
        System.out.println(sb);
    }
}
