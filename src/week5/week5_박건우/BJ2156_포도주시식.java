package week5.week5_박건우;


import java.io.*;

public class BJ2156_포도주시식 {
    public static void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int wine[] = new int[N];
        int dp[] = new int[N+1];

        for(int i = 0; i < N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wine[0];

        if(N <= 1){
            bw.write(dp[1]+"\n");
            bw.flush();
            return;
        }
        dp[2] = dp[1] + wine[1];

        if(N <= 2){
            bw.write(dp[2]+"\n");
            bw.flush();
            return;
        }

        for(int i = 3; i <= N; i++){
            dp[i] = dp[i-3] + wine[i-2] + wine[i-1];    // 첫 잔은 안 마시고 연속으로 두 잔 마심
            dp[i] = Math.max(dp[i], dp[i-2] + wine[i-1]);   // 두 번째 잔은 안 마시고, 1, 3번 잔을 마심
            dp[i] = Math.max(dp[i], dp[i-1]);  // 첫 번째, 두 번째 잔을 마심
        }

        bw.write(dp[N]+"\n");
        bw.flush();
    }

    public static void main(String[] args) throws IOException, IOException {
        BJ2156_포도주시식 main = new BJ2156_포도주시식();
        main.solution();
    }
}
