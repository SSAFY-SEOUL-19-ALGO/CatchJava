package week3_박윤환;

public class P43165_타겟넘버 {
    static int N, trg, answer;
    static int[] nums;

    // 다음 수를 양수 or 음수로 하나씩 고르면서 깊이 우선 탐색
    static void dfs(int cur, int sum) {
        if(cur == N) {  // 모든 수의 부호를 다 정했으면
            if(sum == trg) { // 합이 타겟넘버와 같으면
                answer++;   // 정답 개수 증가
            }
            return;
        }

        int now = nums[cur];     // 현재 숫자
        dfs(cur+1, sum+now);    // 현재 수를 양수로 더하고 다음 수 탐색
        dfs(cur+1, sum-now);    // 현재 수를 음수로 더하고 다음 수 탐색

    }

    public int solution(int[] numbers, int target) {
        answer = 0;
        nums = numbers; // static 멤버에 저장
        trg = target;   //  static 멤버에 저장
        N = numbers.length; // 주어진 수의 개수

        dfs(0, 0); // 주어진 수 처음부터 시작

        return answer;
    }

    public static void main(String[] args) {
        P43165_타겟넘버 sol = new P43165_타겟넘버();

        System.out.println(sol.solution(new int[] {1, 1, 1, 1, 1}, 3));
        System.out.println(sol.solution(new int[] {4, 1, 2, 1}, 4));
    }
}
