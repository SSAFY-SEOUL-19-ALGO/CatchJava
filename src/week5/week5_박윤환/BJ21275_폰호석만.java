package week5.week5_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class BJ21275_폰호석만 {

    static Map<Character, Integer> map;

    // 십진법 수로 변환하는 메소드
    static double determine(String s, int n) {
        int len = s.length();   // 주어진 수의 자리수
        double value = 0.0; // 2^64보다 큰수가 나올수도 있으므로 double 타입 반환
        for(int i=0; i<len; i++) {
            value += map.get(s.charAt(i)) * Math.pow(n, (len - 1) - i); // 각 자리수를 십진법으로 변환해서 더함
        }

        return value;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new TreeMap<>();  // Map에 각 자리수(char)가 의미하는 숫자 저장
        long X = 0;
        int A = 0;
        int B = 0;
        for(int i=0; i<36; i++) {
            if(i < 10) {
                map.put((char) ('0' + i), i);   // 10보다 작으면 그 숫자를 저장
            } else {
                map.put((char) ('a' + (i-10)), i);  // 10이상이면 알파벳 저장
            }
        }

        String[] st = br.readLine().split(" "); // 두 수 입력

        int maxA = 0;
        for(int i=0; i<st[0].length(); i++) {
            char c = st[0].charAt(i);
            maxA = Math.max(maxA, map.get(c));  // 각 자리수의 가장 큰 값 기록
        }
        int maxB = 0;
        for(int i=0; i<st[1].length(); i++) {
            char c = st[1].charAt(i);
            maxB = Math.max(maxB, map.get(c));  // 각 자리수의 가장 큰 값 기록
        }

        int cnt = 0;    // 가능한 조합의 수
        for(int i=maxA+1; i<=36; i++) { // 각 자리수의 가장 큰 값+1이 가능한 최소 진법수
            double detA = determine(st[0], i);  // A가 될 수 저장
            if(detA > Long.MAX_VALUE) continue; // 만약 2^64이상이라면 다음으로
            for(int j=maxB+1; j<=36; j++) { // 최대 진법수인 36까지 A와 B 이중 for문 반복
                if(i == j) continue;    // 같은 진법이 안되도록
                if(detA == determine(st[1], j)) {   // B가 될 수와 같다면
                    X = (long) detA;    // 그 수가 X가 된다
                    A = i;  // A는 i진법
                    B = j;  // B는 j진법
                    cnt++;  // 가능한 조합 수 증가
                }
            }
        }

        if(cnt == 0) {  // 가능한 조합이 없으면
            System.out.println("Impossible"); // "Impossible" 출력
        } else if(cnt == 1) {   // 가능한 조합이 1개라면
            System.out.println(X + " " + A + " " + B);  // X, A, B 출력
        } else {    // 가능한 조합이 2개 이상이면
            System.out.println("Multiple"); // "Multiple"출력
        }
    }
}
