package week11.week11_박건우;

import java.io.*;

public class BJ1062_가르침 {
    static int ans;
    static boolean[] visited;
    static String[] words;
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        StringBuilder sb;

        ipt = br.readLine().split(" ");
        N = Integer.parseInt(ipt[0]);
        K = Integer.parseInt(ipt[1]);
        sb = new StringBuilder();

        words = new String[N];
        visited = new boolean[26];

        if(K < 5) {
            sb.append(0).append("\n");
            bw.write(sb.toString());
            bw.flush();
            return;
        } else if(K == 26){
            sb.append(N).append("\n");
            bw.write(sb.toString());
            bw.flush();
            return;
        }

        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        for (int i = 0; i < N; i++) {
            String str = br.readLine().replaceAll("anta|tica", "");
            words[i] = str;
        }

        check(0, 0);
        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }

    static void check(int alpha, int count){
        if(count == K - 5){
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                boolean flag = true;

                for (int j = 0; j < words[i].length(); j++) {
                    if(!visited[words[i].charAt(j) - 'a']){
                        flag = false;
                        break;
                    }
                }

                if(flag) tmp++;
            }
            ans = Math.max(tmp, ans);
            return;
        }

        for (int i = alpha; i < 26; i++) {
            if(!visited[i]){
                visited[i] = true;
                check(i, count + 1);
                visited[i] = false;
            }
        }
    }
}
