package week2.week2_박윤환;

public class P42842_카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown + yellow;     // brown격자 + yellow격자 = 전체 격자수

        // 가로 혹은 세로의 길이가 최소 3이상 total의 제곱근 이하이므로 그만큼 반복
        for(int i=3; i<=Math.sqrt(total); i++) {
            int l = total / i;  // 전체 격자수를 작은 값으로 나누면 가로 길이
            int s = i;      // i는 세로 길이

            // 가로와 세로의 길이가 전체 격자수와 같으면서
            // 가로길이 * 2 + (세로길이-2) * 2 = brown격자수 이면 조건이 성립하므로
            if(l * s == total && 2*l+2*(s-2) == brown) {
                answer = new int[] {l, s};  // 조건에 맞는 가로와 세로를 정답에 저장
                break;
            }
        }

        return answer;
    }

}
