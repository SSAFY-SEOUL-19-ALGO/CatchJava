package week6.week6_박건우;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BJ12018_Yeonsei {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt;

        ipt = br.readLine().split(" ");
        int N = Integer.parseInt(ipt[0]);
        int point = Integer.parseInt(ipt[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        int[] subjects = new int[N];
        int part;   // 과목의 수강신청자 수
        int lim;    // 과목의 수강제한 인원 수
        int[] candli;   // 과목의 마일리지 투입 배열

        for(int r =  0; r < N; r++){
            ipt = br.readLine().split(" ");
            part = Integer.parseInt(ipt[0]);
            lim = Integer.parseInt(ipt[1]);
            candli = new int[part];

            ipt = br.readLine().split(" ");
            for(int i = 0; i < part; i++){
                candli[i] = Integer.parseInt(ipt[i]);
            }

            Arrays.sort(candli);
            // 신청 정원보다 신청자가 적으면 1점만 넣어도 된다, 아니면 간신히 신청 할 만큼만
            pq.offer(part > lim ? candli[part-lim] : 1);
        }

        int cnt = 0;
        while(!pq.isEmpty() && point >= pq.peek()){
            point = point - pq.poll();
            cnt++;
        }
        bw.write(cnt+"\n");
        bw.flush();
    }
}