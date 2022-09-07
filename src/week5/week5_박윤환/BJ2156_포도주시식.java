package week5.week5_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2156_포도주시식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wine = new int[n+1];  // 와인 배열, 인덱스 1부터
        for(int i=1; i<=n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if(n == 1) {    // 와인이 1잔일 경우
            System.out.println(wine[1]);    // 그 1잔이 최대
            System.exit(0); // 프로그램 정상 종료
        }

        int[] dp = new int[n+1];    // dp 배열, 인덱스 1부터
        dp[1] = wine[1];    // 첫번째는 첫번째 잔을 선택한 것이 최대
        dp[2] = dp[1] + wine[2];    // 두번째는 첫번째+두번째 잔을 선택한 것이 최대

        for(int i=3; i<=n; i++) {   // 세번째 잔부터 마지막 잔까지
            /* 현재 잔을 골랐을 떄의 최대값은 다음 2가지 경우 중 하나이다
            XOO -> 3번째전 잔까지의 최대 + 1번쨰 전 + 현재
            OXO -> 2번째전 잔까지의 최대 + 현재 */
            dp[i] = Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]);

            /* 현재 잔을 고르지 않은 경우도 있으므로
            1번째전 잔까지의 최대와 현재 잔을 골랐을 떄의 최대 중 큰 값이
            현재 잔까지의 최대가 된다 */
            dp[i] = Math.max(dp[i-1], dp[i]);
        }

        System.out.println(dp[n]);  // dp 배열의 마지막 값이 최대로 마실수 있는 포도주 양
    }
}
