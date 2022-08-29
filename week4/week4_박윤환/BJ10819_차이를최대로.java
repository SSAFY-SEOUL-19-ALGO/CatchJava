package week4_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ10819_차이를최대로 {

    static int N, max;
    static int[] input, numbers;

    // 비트마스킹을 이용한 순열
    static void perm(int cnt, int flag) {
        if(cnt == N) {  // N개를 골랐다면
            int result = equation(numbers); // 재나열된 배열로 식의 결과를 구한다
            max = Math.max(max, result);    // 결과값과 최대값 비교 갱신
            return;
        }
        for(int i=0; i<N; i++) {
            if((flag & 1<<i) == 0) {    // 해당 위치의 숫자를 사용하지 않았다면
                numbers[cnt] = input[i];    // 선택
                perm(cnt+1, flag | 1<<i);   // 다음 수 선택
            }
        }
    }

    // 주어진 식
    static int equation(int[] arr) {
        int size = arr.length;
        int sum = 0;
        for(int i=0; i<size-1; i++) {   // 배열의 마지막 인덱스 전까지
            sum += Math.abs(arr[i] - arr[i+1]); //  |A[i] - A[i+1]|
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 숫자의 개수
        input = new int[N];     // 입력된 숫자를 저장할 배열
        numbers = new int[N];   // 순서를 재나열하여 저장할 배열
        String[] st = br.readLine().split(" ");

        for(int i=0; i<N; i++) {
            input[i] = Integer.parseInt(st[i]); // 입력값 저장
        }

        perm(0, 0); // 비트마스킹을 사용한 순열

        System.out.println(max);

    }
}
