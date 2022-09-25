package week7.week7_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ13164_행복유치원 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);
        int[] height = new int[N];
        st = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            height[i] = Integer.parseInt(st[i]);
        }

        /* K개의 조를 만드는데 K-1개의 분단이 필요
        *  인접한 원생의 키차이가 최대가 되는 부분에 분단이 생겨야 최소
        *  그러므로 차이를 구해서 차이가 큰 K-1개를 제외한 나머지의 합을 구하면 된다*/
        PriorityQueue<Integer> diff = new PriorityQueue<>();    // 차이를 우선순위큐에 담는다
        for(int i=0; i<N-1; i++) {
            diff.offer(height[i+1] - height[i]);
        }

        int result = 0;
        // 차이가 큰 K-1개를 제외하고 차이합을 구해야하므로 우선순위큐의 앞에서부터 (N-1)-(K-1)개의 차이합을 구함
        for(int i=0; i<N-K; i++) {
            result += diff.poll();
        }

        System.out.println(result);
    }
}
