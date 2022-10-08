package week9.week9_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ11501_주식 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        for(int tc=1; tc<=T; tc++) {    // 테스트 케이스 반복
            int N = Integer.parseInt(br.readLine());    // 날의 수
            int[] prices = new int[N];  // N일 동안의 주식 가격
            String[] st = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                prices[i] = Integer.parseInt(st[i]);
            }
            int maxP = 0;   // 범위내 가장 비싼 주식 가격
            long totalPrice = 0; // 얻은 이윤
            for(int i=N-1; i>=0; i--) { // 뒤에서부터 탐색
                if(prices[i] > maxP) {  // 현재 주식 가격이 더 비싸다면
                    maxP = prices[i];   // 최대 가격 갱신
                } else {    // 현재 주식 가격이 작거나 같다면
                    totalPrice += maxP - prices[i]; // 최대 가격과의 차이를 이윤에 더함
                }
            }
            sb.append(totalPrice).append("\n");
        }
        System.out.println(sb);
    }
}
