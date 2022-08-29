package week2_박윤환;

import java.util.*;

public class P42839_소수찾기 {
    static boolean[] visited;
    static int[] nums, subset;
    static Set<Integer> set;
    static int n;

    public int solution(String numbers) {
        set = new HashSet<>();  // 소수를 중복되지 않게 저장할 set
        n = numbers.length();   // 번호가 적힌 종이 조각 갯수
        nums = new int[n];      // 번호가 적힌 종이 조각을 담는 배열
        for (int i = 0; i < n; i++) {
            nums[i] = numbers.charAt(i) - '0';  // 번호를 배열에 저장
        }
        for (int r = 1; r <= n; r++) {   // 1개부터 n개까지 종이조각 중에서 번호를 고른다
            visited = new boolean[n];   // 선택됐는지 기록할 boolean 배열
            subset = new int[r];        // 선택한 번호들을 담을 배열
            perm(0, r);             // nPr 실행
        }

        return set.size();
    }

    // 순열 메소드
    static void perm(int cnt, int r) {  // cnt : 직전까지 뽑은 순열에 포함된 수의 개수
        if (cnt == r) {  // r개까지 다 뽑았다면
            int sum = 0;
            for (int s :
                    subset) {   // 앞의 수를 앞자리수로 하여 수를 조합
                sum = 10 * sum + s;
            }
            if (isPrime(sum)) {  // 해당 수가 소수라면
                set.add(sum);   // set에 저장
            }
            return;
        }

        for (int i = 0; i < n; i++) {    // 가능한 모든 수에 대해
            if (!visited[i]) {   // 선택된적이 없다면
                visited[i] = true;  // 선택했다고 체크
                subset[cnt] = nums[i];  // 선택된 수를 저장
                perm(cnt + 1, r); // 다음 수 선택

                visited[i] = false; // 사용했던 수에 대해 체크 해제
            }
        }
    }

    // 소수 판별 메소드
    static boolean isPrime(int n) {
        if (n < 2) {     // 2보다 작을 경우 소수가 아님
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {    // 2부터 판별할 수의 제곰근까지
            if (n % i == 0) {    // 판별할 수를 나눌 수 있다면
                return false;   // 소수가 아니다
            }
        }
        return true;    // 나눌 수 있는 수가 없었다면 소수이다
    }
}
