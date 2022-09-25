package week7.week7_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ14501_퇴사 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for(int i=0; i<N; i++) {
            String[] st = br.readLine().split(" ");
            T[i] = Integer.parseInt(st[0]);
            P[i] = Integer.parseInt(st[1]);
        }

        int max = 0;    // 최대값 초기화
        for(int flag=1, caseCnt=1<<N; flag<caseCnt; flag++) {   // 부분집합 비트마스킹 사용
            int days = 0;   // 누적 상담일수
            int profit = 0; // 누적 금액
            for(int i=0; i<N; i++) {    // 선택된 일정을 확인하기 위해 모든 인덱스 반복
                if(days <= i) { // 현재 날짜가 상담 가능한 날짜라면
                    if((flag & 1<<i) != 0 && i + T[i] <= N) {    // 부분집합으로 선택된 일정이면서 퇴사전에 끝나는 일정이면
                        days += T[i];   // 누적일수를 더함
                        profit += P[i]; // 누적 금액을 더함
                    } else {
                        days++; // 일정을 안했으면 그냥 하루 증가
                    }
                }
            }
            max = Math.max(max, profit);    // 최대 금액 갱신
        }
        System.out.println(max);
    }
}
