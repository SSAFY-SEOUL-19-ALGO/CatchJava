package week10.week10_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ2002_추월 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<N; i++) {
            map.put(br.readLine(), i);  // 차번호를 key, 현재 순서를 value로 map생성
        }
        int[] out = new int[N]; // 나오는 차량 배열
        for(int i=0; i<N; i++) {
            out[i] = map.get(br.readLine());    // 나오는 차량 순서대로 그 차량이 터널에 들어갔을때의 순서를 배열에 저장
        }
        int cnt = 0;    // 추월한 차량 수
        for(int i=0; i<N; i++) {    // 모든 차량 반복
            for(int j=i+1; j<N; j++) {  // 지금보다 뒤의 차량들 반복
                if(out[i] > out[j]) {   // 뒤의 차량들 중에 진입 순서가 먼저였던 차가 하나라도 있으면
                    cnt++;  // 추월한 것이므로 카운트 증가
                    break;  // 현재 차가 추월한 것을 카운트 했으므로 다음 차량으로
                }
            }
        }

        System.out.println(cnt);

    }
}
