package week12.week12_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1091_카드섞기 {
    static int N;
    static int[] P, S, ori, tmp;

    static boolean cycle() {
        for(int i=0; i<N; i++) {
            if(P[i] != ori[i]) return false;
        }
        return true;
    }

    static boolean check() {
        for(int i=0; i<N; i++) {
            if(P[i] != (i % 3)) return true;
        }
        return false;
    }

    static void shuffle() {
        tmp = Arrays.copyOf(P, N);
        for(int i=0; i<N; i++) {
            P[S[i]] = tmp[i];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        P = new int[N];
        S = new int[N];
        ori = new int[N];
        tmp = new int[N];

        String[] st = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            P[i] = ori[i] = Integer.parseInt(st[i]);
        }

        st = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            S[i] = Integer.parseInt(st[i]);
        }

        int cnt = 0;
        while(check()) {
            cnt++;
            shuffle();
            if(cycle()) {
                cnt = -1;
                break;
            }
        }

        System.out.println(cnt);
    }
}
