package week1.week1_박윤환;

class P42584_주식가격 {
    public int[] solution(int[] prices) {
        int n = prices.length;  // 주식 가격 배열의 크기
        int[] answer = new int[n];  // 주식 가격 배열의 크기와 같은 정답 배열 생성
        int now = 0;    // 비교할 가격
        for(int i=0; i<n; i++) {    // 주식 가격 배열을 탐색
            now = prices[i];    // 비교할 가격에 지금 시점의 가격 저장
            int cnt = 0;    // 떨어진 기간 카운트를 0으로 초기화
            for(int j=i+1; j<n; j++) {  // 지금 시점 이후의 주식 가격 배열 탐색
                if(now > prices[j]) {   // 비교할 가격보다 떨어졌다면
                    cnt++;  // 카운트 상승
                    break;  // 가격이 떨어졌으므로 비교 종료
                } else {    // 떨어지지 않았다면
                    cnt++;  // 카운트 계속 상승
                }
            }
            answer[i] = cnt;    // 비교가 끝나면 지금 시점의 가격에 대한 카운트 값을 저장
        }
        return answer;
    }
}