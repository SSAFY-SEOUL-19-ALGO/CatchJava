package week6.week6_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1초이기 때문에 정렬을 쓰지 않고 해보기로 생각..!
// 제일 큰 값을 제외하고는 다 나누기를 진행해야함
public class 에너지_드링크 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        float answer = 0;
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < N; i++) {
            if (max < arr[i]) max = arr[i]; // 제일 큰 값을 넣어두기 위함
            answer += (float) arr[i] / 2; // 반을 나눠서 저장
        }

        answer += (float) max / 2; // 제일 큰 값의 반은 이미 저장이 되어 있기 때문에, 나머지 반을 저장

        System.out.println(answer);
    }
}