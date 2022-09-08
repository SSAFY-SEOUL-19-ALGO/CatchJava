package week5.week5_박건우;

import java.io.*;

public class BJ11047_동전0 {
    public void solution() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[];
        s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        int cnt = 0;
        int[] coins = new int[N];

        for(int i = 0; i < N; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        //Arrays.sort(coins);
        for(int i = N-1; i >= 0; i--){
            if(K / coins[i] > 0){
                cnt += K / coins[i];
                K = K  % coins[i];
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
    public static void main(String[] args) throws IOException {
        BJ11047_동전0 main = new BJ11047_동전0();
        main.solution();
    }
}
