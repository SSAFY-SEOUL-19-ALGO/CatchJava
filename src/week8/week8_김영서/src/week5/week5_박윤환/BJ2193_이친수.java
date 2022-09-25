package week5.week5_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ2193_이친수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 이친수의 규칙 대로 1자리수 부터 자리수를 올려가며 나타내 보면 다음과 같다
        [1] [10] [100, 101] [1000, 1001, 1010] [10000, 10001, 10010, 10100, 10101]
        각 자리수에서 가능한 이친수의 개수는 자리수가 증가함에 따라
        피보나치 수열과 같은 양상을 보인다는 것을 알 수 있다. */

        if(N == 1) {    // 1자리수 일경우 이친수는 1 하나 이므로
            System.out.println(1);  //1을 출력하고
            System.exit(0); // 프로그램 종료
        }

        long[] dp = new long[N+1];  // 자리수가 커지면서 이친수의 개수가 int범위를 벗어나므로 long배열로 선언
        dp[1] = 1;  // 1자리수는 1 하나
        dp[2] = 1;  // 2자리수는 10 하나

        for(int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];  // 피보나치 수열과 동일
        }

        System.out.println(dp[N]);
    }
}
