package week7.week7_박건우;

import java.io.*;


public class BJ14501_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;
        int[][] tp; // time and price
        int rpt = Integer.parseInt(br.readLine());
        tp = new int[rpt + 1][2];
        int[] dp = new int[rpt +1];

        for(int r = 1; r <= rpt; r++){
            ipt = br.readLine().split(" ");
            tp[r][0] = Integer.parseInt(ipt[0]);
            tp[r][1] = Integer.parseInt(ipt[1]);

            dp[r] = tp[r][1];
        }

        for(int i = 2; i <= rpt; i++){
            for(int j = 1; j < i; j++){
                if(i - j >= tp[j][0]) { // 남아 있는 날에 상담을 추가할 수 있다면
                    // dp[i] = max(dp[i], tp[i][1] + dp[j], 현재까지 최대 값과 추가상담비 + 전까지 상담비 비교하기
                    dp[i] = Math.max(dp[i], tp[i][1] + dp[j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= rpt; i++){
            if(i + tp[i][0] <= rpt + 1){
                if(max < dp[i]) max = dp[i];
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }
}
