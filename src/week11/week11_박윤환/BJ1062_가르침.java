package week11.week11_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1062_가르침 {

    static int N, K, max;
    static String[] words;
    static boolean[] known;

    // cnt : 현재 배운 글자 수, start : 현재 글자 번호
    static void comb(int cnt, int start) {
        if(cnt == K - 5) {  // a, n, t, i, c 빼고 배울수 있는 만큼 배웠으면
            int count = 0;  // 읽을 수 있는 단어 개수
            for (String w :
                    words) {    // 모든 단어 탐색
                for(int i=0; i<w.length(); i++) {   // 단어 내에 글자 탐색
                    if(!known[w.charAt(i) - 'a']) { // 배운적 없는 글자가 있으면
                        count--;    // 밑에 카운트 증가와 상쇄되도록 카운트--
                        break;  // 글자탐색 종료
                    }
                }
                count++;    // 읽을 수 있는 단어 카운트 증가
            }
            max = Math.max(max, count); // 최대 개수 갱신
            return;
        }

        for(int i=start; i<26; i++) {   // 현재 이후 모든 알파벳 탐색
            if(!known[i]) { // 배우지 않은 알파벳이라면
                known[i] = true;    // 배웠다고 체크
                comb(cnt + 1, i);   // 다음 배울 글자로
                known[i] = false;   // 백트래킹
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);    // 주어지는 단어 개수
        K = Integer.parseInt(st[1]);    // 배운 글자 수
        words = new String[N];  // 단어를 저장할 배열
        for(int i=0; i<N; i++) {
            String w = br.readLine();
            w = w.replaceAll("anta", "");   // "anta"는 항상 있으므로 없앰
            w = w.replaceAll("tica", "");   // "tica"도 항상 있으므로 없앰
            words[i] = w;   // 나머지 문자를 저장
        }

        if(K < 5) { // a, n, t, i, c 5개 문자도 못배우면
            System.out.println(0);  // 단어 하나도 못읽으므로 0 출력
            System.exit(0); // 프로그램 종료
        } else if(K == 26) {    // 모든 글자를 다 배웠으면
            System.out.println(N);  // 모든 단어를 다 읽을수 있으므로 N 출력
            System.exit(0); // 프로그램 종료
        }

        known = new boolean[26];    // 배운 글자를 기록할 boolean 배열
        known['a' - 'a'] = true;    // a 배움 기록
        known['n' - 'a'] = true;    // n 배움 기록
        known['t' - 'a'] = true;    // t 배움 기록
        known['i' - 'a'] = true;    // i 배움 기록
        known['c' - 'a'] = true;    // c 배움 기록

        comb(0, 0); // 백트래킹 조합 수행
        System.out.println(max);    // 최대 단어 개수 출력
    }
}
