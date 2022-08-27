package week4_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BJ1439_뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        Pattern p = Pattern.compile("(0+)|(1+)");   // 정규식 패턴 생성
        Matcher m = p.matcher(S);   // 패턴 매칭

        int cnt0 = 0;   // 0의 개수
        int cnt1 = 0;   // 1의 개수

        while(m.find()) {   // 다음 일치하는 문자열이 있을 동안 반복
            if(m.group(0).equals(m.group(1))) { // 매칭된 문자열이 0+이라면
                cnt0++; // 0 카운트 증가
            } else {    // 그 외엔
                cnt1++; // 1 카운트 증가
            }
        }

        System.out.println(Math.min(cnt0, cnt1));    // 최소값 출력
    }
}
