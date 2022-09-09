package week6.week6_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ20115_에너지드링크 {
    /* 에너지 드링크를 섞을때 손실량이 발생하게 되므로
    * 가장 큰 최종 결과물을 얻기 위해서는 섞는 과정 중의 손실량을 최소로 해야한다
    * 그러기 위해서는 두 에너지드링크를 섞을때 절반으로 섞이는 에너지드링크의 양은 항상 작은 값이어야 한다. */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 에너지 드링크의 개수
        PriorityQueue<Double> pq = new PriorityQueue<>();   // 항상 작은 값을 절반으로 하기위해 우선순위큐 사용
        double result = 0;  // 결과값
        String[] st = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            double n = Double.parseDouble(st[i]);
            if(result < n) {
                result = n; // 가장 양이 많은 것은 절반으로 하면 안되므로 가장 많은 것부터 섞기 시작한다
            }
            pq.offer(n);
        }

        while(!pq.isEmpty()) {  // 우선순위큐가 빌떄까지
            if(pq.size() == 1) {    // 마지막 하나는 가장 많은 것이므로
                pq.poll();  // 그냥 꺼내고
                continue;   // 끝냄
            }
            double n = pq.poll();   // 우선순위큐에서 가장 작은 값을 꺼내고
            result += n/2;  // 절반으로 해서 결과값에 더한다
        }

        System.out.println(result);   // 결과물 출력
    }
}
