package week5.week5_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11047_동전0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);    // 동전의 개수
        int K = Integer.parseInt(st[1]);    // 만들어야 하는 가치 합

        int[] A = new int[N];   // 동전을 담을 배열
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(br.readLine()); // 동전 저장
        }

        /* 해당 문제는 동전의 가치에 다음과 같은 조건이 있다.
        '''
        동전의 가치 A[i]가 오름차순으로 주어질때
        (1 ≤ A[i] ≤ 1,000,000, A[1] = 1, i ≥ 2인 경우에 A[i]는 A[i-1]의 배수)
        '''
        동전의 큰 단위가 항상 작은 단위의 배수 이므로 이 문제는 그리디로 풀 수 있는 문제이다. */

        int cnt = 0;
        for(int i=N-1; i>=0 && K > 0; i--) {    // 동전의 가치가 큰 것부터 반복 K가 0보다 작을 경우 종료
            int c = K / A[i];   // 해당 동전의 최대 개수
            if(c != 0) {    // 해당 동전의 최대 개수가 0이 아닐 경우만
                cnt += c;   // 동전 개수 합 증가
                K %= A[i];  // 남은 가치 계산
            }
        }

        System.out.println(cnt);    // 동전 개수 출력
    }
}
