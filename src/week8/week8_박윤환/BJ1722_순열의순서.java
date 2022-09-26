package week8.week8_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1722_순열의순서 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fact = new long[N+1];
        boolean[] isUsed = new boolean[N+1];
        fact[0] = 1;
        for(int i=1; i<=N; i++) {
            fact[i] = fact[i-1] * i;
        }
        String[] st = br.readLine().split(" ");
        int prob = Integer.parseInt(st[0]); // 2번쨰 줄의 첫번쨰는 소문제 번호
        switch (prob) { // 소문제 번호에 따라 다른 결과
            case 1: // 1일 경우
                long k = Long.parseLong(st[1]);    // 뒤의 입력은 k
                int[] result = new int[N+1];
                for(int i=1; i<=N; i++) {
                    for(int j=1; j<=N; j++) {
                        if(!isUsed[j]) {
                            if(fact[N-i] < k) {
                                k -= fact[N-i];
                            } else {
                                result[i] = j;
                                isUsed[j] = true;
                                break;
                            }
                        }
                    }
                }
                for(int i=1; i<=N; i++) {
                    System.out.print(result[i] + " ");
                }
                break;
            case 2: // 2일 경우
                long cnt = 1;
                for(int i=1; i<=N; i++) {
                    int n = Integer.parseInt(st[i]);
                    isUsed[n] = true;
                    for(int j=1; j<n; j++) {
                        if(!isUsed[j]) {
                            cnt += fact[N-i];
                        }
                    }
                }
                System.out.println(cnt);
                break;
        }
    }
}
