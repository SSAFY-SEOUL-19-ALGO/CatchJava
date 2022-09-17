package week4.week4_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1213_팰린드롬만들기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();     // 문자열 수정이 많으므로 StringBuilder 사용

        String S = br.readLine();   // 문자열 입력
        Map<Character, Integer> map = new TreeMap<>();  // 문자가 나온 횟수 기록으로 TreeMap 사용
        for(int i=0; i<S.length(); i++) {
            map.merge(S.charAt(i), 1, Integer::sum);    // TreeMap에 문자가 나온 횟수 증가(key값이 자동으로 사전순서 정렬)
        }

        StringBuilder front = new StringBuilder();  // 회문의 앞부분을 저장할 StringBuilder
        Queue<Character> queue = new ArrayDeque<>();    // 가운데 부분을 저장할 큐
        for (char c :
                map.keySet()) { // TreeMap의 모든 key값 반복
            int count = map.get(c);    // 현재 문자가 나온 횟수
            if(count % 2 != 0) {   // 나온 횟수가 홀수라면
                queue.offer(c); // 큐에 해당 문자 저장
            }
            for(int i=0; i<count/2; i++) { // 나온 횟수의 절반만큼 반복
                front.append(c);    // 회문의 앞부분에 나온 횟수 더해줌
            }
        }
        if(queue.size() > 1) {  // 홀수인 문자의 개수가 1개보다 많으면 회문 생성 불가능
            sb.append("I'm Sorry Hansoo"); // 불가능일때의 문자열 저장
        } else {    // 그 외엔
            sb.append(front);   // 최종 출력물에 앞부분 저장
            if (!queue.isEmpty()) {  // 홀수인 문자가 하나 있다면
                sb.append(queue.poll());    // 최종 출력물에 가운데 문자 저장
            }
            sb.append(front.reverse()); // 최종 출력물에 회문의 앞부분을 뒤집어서 저장
        }

        System.out.println(sb); // 최종 출력
    }
}
