package week8.week8_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1417_국회의원선거 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] candidate = new int[N];
        int max = 0;    // 가장 많은 추천수
        int maxIdx = 0; // 가장 많은 추천수를 받은 후보
        for(int i=0; i<N; i++) {
            candidate[i] = Integer.parseInt(br.readLine());
            if(i > 0) { // 다솜이를 제외하고
                if(max < candidate[i]) { // 가장 큰 추천수를 받은 후보라면
                    max = candidate[i]; // 가장 많은 추천수 갱신
                    maxIdx = i; // 후보 번호 갱신
                }
            }
        }

        int cnt = 0;    // 매수해야하는 사람 수
        while(candidate[0] <= max) {    // 다솜이의 추천수가 최대 추천수보다 같거나 작으면 반복
            candidate[0]++; // 다솜이 추천수 증가
            max = --candidate[maxIdx];  // 가장 많은 추천수의 후보를 찍으려던 사람을 매수
            cnt++;  // 매수하는 사람 증가
            for(int i=1; i<N; i++) {    // 다시 최대 추천수의 후보 갱신
                if(max < candidate[i]) {
                    max = candidate[i];
                    maxIdx = i;
                }
            }
        }
        System.out.println(cnt);    // 매수하는 사람 수 출력
    }
}
