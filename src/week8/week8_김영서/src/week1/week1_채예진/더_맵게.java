package week1.week1_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue; // 우선순위 큐

class 더_맵게 {
    // 프로그래머스용
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int scov : scoville) {
            heap.add(scov);
        }

        while (heap.peek() <= K ) {
            if (heap.size() == 1) {
                return -1;
            }

            int a = heap.poll();
            int b = heap.poll();

            heap.add(a + (b * 2));
            answer++;
        }

        return answer;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] scoville = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int K = Integer.parseInt(reader.readLine());
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue(); // 우선순위 힙

        for (int scov : scoville) { // 힙에 값 저장
            heap.add(scov);
        }

        while (heap.peek() <= K ) { // 우선순위 힙이기 때문에 우선순위가 가장 높은 값 확인 
            if (heap.size() == 1) { // 1이면 섞지 않음 
                answer = -1;
                return;
            }

            int a = heap.poll(); // 가장 맵지 않은 거  
            int b = heap.poll(); // 두 번째로 맵지 않은 거 

            heap.add(a + (b * 2)); // 스코빌 계산 
            answer++;
        }

        System.out.println(answer);
    }
}