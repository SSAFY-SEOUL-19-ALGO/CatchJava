package week1_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 기능_개발 {

    static final int FIN = 100; // 작업 완료 퍼센트 

    // 프로그래머스용
    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        int time = 0;
        int count = 0;
        for (int i = 0; i < progresses.length; i++) {
            if ((progresses[i] + time * speeds[i]) >= FIN) {
                count++;
            } else {
                if (count != 0) {
                    list.add(count);
                }
                count = 1;
                time += Math.ceil(((FIN - (progresses[i] + time * speeds[i])) / (double)speeds[i]));
            }
        }

        if (count != 0) {
            list.add(count);
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] progresses = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 작업 진도 입력 받기  
        int[] speeds = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 작업 속도 입력 받기 

        ArrayList<Integer> list = new ArrayList<>(); // 작업이 완료된 개수 넣기 

        int time = 0; // 작업 시간 
        int count = 0; // 기능 개발 완료된 작업의 개수 
        for (int i = 0; i < progresses.length; i++) {
            if ((progresses[i] + time * speeds[i]) >= FIN) { // 현재 작업 진도 + 현재 진행된 작업 시간 * 작업 속도 
                count++;
            } else {
                if (count != 0) { // 작업이 완료되지 않았는데 기능 개발 완료된 작업이 있을 경우 리스트에 넣고 작업 개수 초기화 
                    list.add(count);
                }
                count = 1;
                time += Math.ceil(((FIN - (progresses[i] + time * speeds[i])) / (double)speeds[i])); // 작업 시간 추가 
            }
        }

        if (count != 0) { // 아직 list에 넣지 않은 기능 개발 완료된 작업이 있을 경우 리스트에 넣기 
            list.add(count);
        }

        int[] answer = list.stream().mapToInt(i -> i).toArray(); // 리스트를 int 배열로 변환 

        sb.append(Arrays.toString(answer)); // 출력 
        System.out.print(sb);
    }

}