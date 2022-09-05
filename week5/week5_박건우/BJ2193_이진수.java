package week5_박건우;


import java.io.*;

public class BJ2193_이진수 {
    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];  // dp[i]는 i번째 자리의 수
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        bw.write(dp[N]+"\n");
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        BJ2193_이진수 main = new BJ2193_이진수();
        main.solution();
    }
}



