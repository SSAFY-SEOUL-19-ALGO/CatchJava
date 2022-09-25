package week6.week6_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 1번
public class Yonsei_TOTO {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            List<Integer> subject = new ArrayList<>(); // 내림차순
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            if (p < l) {
                pq.add(1); // 마일리지 제일 조금 넣기
                continue;
            }
            for (int j = 0; j < p; j++) {
                subject.add(Integer.parseInt(input[j]));
            }
            subject.sort(Collections.reverseOrder()); // 내림차순 정렬
            pq.add(subject.get(l - 1)); // 최소한으로 마일리지 넣어서 들어가기
        }

        int answer = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            int val = pq.poll();

            if (val + sum > m) break;
            sum += val;
            answer++;
        }

        System.out.println(answer);
    }
}

// 2번 - 맞았습니다. (출력문 하나를 더 써놓고 틀려서... 이거 자체가 틀린줄;;) - 이게 4ms 좀 더 빠름
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            PriorityQueue<Integer> subject = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            if (p < l) {
                pq.add(1); // 마일리지 제일 조금 넣기
                continue;
            }
            for (int j = 0; j < p; j++) {
                subject.add(Integer.parseInt(input[j]));
            }
            for (int j = 0; j < l - 1; j++) subject.poll();
            pq.add(subject.poll()); // 제일 큰 값 빼기
        }
        int answer = 0;
        int sum = 0;
        while(!pq.isEmpty()) {
            int val = pq.poll();
            if (val + sum > m) break;
            sum += val;
            answer++;
        }
        System.out.println(answer);
    }
}
 */