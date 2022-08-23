package week4_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BJ25328_문자열집합조합하기 {
    static int k;
    static char[] picked;
    static HashMap<String, Integer> map;

    // 문자열에서 k개의 문자를 선택하여 나온 횟수와 함께 HashMap에 저장할 메소드
    static void comb(int cnt, int start, String S) {
        if(cnt == k) {  // k개 문자를 골랐다면
            String pick = String.valueOf(picked);   // 고른 문자들로 문자열 생성
            map.merge(pick, 1, Integer::sum);   // HashMap에 문자열과 기존 나온횟수+1로 저장
            return;
        }
        for(int i=start; i<S.length(); i++) {   // 문자열 크기만큼 반복
            picked[cnt] = S.charAt(i);  // 문자 선택
            comb(cnt+1, i+1, S);    // 다음 문자 선택
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<String> pq = new PriorityQueue<>();   // 결과물을 오름차순으로 저장할 우선순위큐

        String X = br.readLine();   // 문자열 X
        String Y = br.readLine();   // 문자열 Y
        String Z = br.readLine();   // 문자열 Z
        k = Integer.parseInt(br.readLine());    // 선택할 문자 개수
        picked = new char[k];   // 선택한 문자를 담을 char 배열
        map = new HashMap<>();  // 선택된 문자열을 만들어진 횟수와 함께 저장할 HashMap

        comb(0, 0, X);  // 문자열 X 수행
        comb(0, 0, Y);  // 문자열 Y 수행
        comb(0, 0, Z);  // 문자열 Z 수행

        for (String key :
                map.keySet()) {     // HashMap에 저장된 모든 문자열 반복
            int value = map.get(key);   // 해당 문자열이 나온 횟수가
            if(value >= 2) {    // 2번 이상이라면
                pq.offer(key);  // 그 문자열을 우선순위큐에 저장
            }
        }

        if(pq.isEmpty()) {  // 우선순위큐가 비었다면
            System.out.println(-1); // 2번이상 만들어진 문자열이 없으므로 -1 출력
        } else {    // 아니라면
            while (!pq.isEmpty()) { // 우선순위큐가 빌때까지
                System.out.println(pq.poll());  // 우선순위큐 앞에서부터 출력
            }
        }

    }
}
