package week1_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 주식_가격 {

    // 프로그래머스용
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i] += 1;

                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = in.readLine().split(" ");
        int[] intArr = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray(); // 주식 가격이 담긴 배열 

        int[] answer = new int[arr.length];

        for (int i = 0; i < intArr.length - 1; i++) { // 하나를 기준으로 가격이 떨어진 것까지의 길이 측정 
            for (int j = i + 1; j < intArr.length; j++) {
                answer[i] += 1;

                if (intArr[i] > intArr[j]) {
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
