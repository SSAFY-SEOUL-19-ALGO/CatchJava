package week4_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1439_뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        S = S.replaceAll("0+", "0");    // 연속된 0은 0으로 변경
        S = S.replaceAll("1+", "1");    // 연속된 1은 1로 변경

        int cnt0 = 0;   // 0의 개수
        int cnt1 = 0;   // 1의 개수

        for(int i=0; i<S.length(); i++) {   // 문자열 길이만큼 반복
            if(S.charAt(i) == '0') {    // 0이면
                cnt0++; // 0개수 증가
            } else {    // 그 외에
                cnt1++; // 1개수 증가
            }
        }

        System.out.println(Math.min(cnt0, cnt1));    // 최소값 출력
    }
}
