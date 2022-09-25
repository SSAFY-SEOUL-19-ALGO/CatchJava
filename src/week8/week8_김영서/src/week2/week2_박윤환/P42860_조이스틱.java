package week2.week2_박윤환;

public class P42860_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        // 이동횟수, 초기 값으로 오른쪽으로만 갔을 떄의 값으로 초기화
        int move = name.length() - 1;

        // 이름 크기만큼 반복
        for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);    // 해당 위치의 글자
            // 다음 알파벳 순서와 이전 알파벳 순서 중 더 적은 횟수를 더한다
            answer += Math.min(c-'A', 'Z'-c+1);

            int idx = i + 1;

            // 현재의 위치 이후부터 끝까지 'A'가 연속으로 나온다면 해당 인덱스 저장
            while(idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }

            // 1. 오른쪽으로 쭉 이동하는 횟수
            // 2. 오른쪽으로 이동하다가 왼쪽으로 이동하는 횟수
            // 3. 왼쪽으로 이동하다가 오른쪽으로 이동하는 횟수
            // 1, 2, 3 중 가장 작은 최소값을 move에 저장
            move = Math.min(move, 2*i + name.length() - idx);
            move = Math.min(move, 2*(name.length() - idx) + i);

        }

        answer += move;     // 최종 이동 횟수를 더한다

        return answer;
    }
}
