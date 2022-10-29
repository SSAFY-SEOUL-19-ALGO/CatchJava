package week11.week11_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ1700_멀티스케줄링 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);    // 멀티탭 구멍 개수
        int K = Integer.parseInt(st[1]);    // 전기용품 사용 횟수
        int[] plug = new int[N];    // 플러그 배열
        int[] products = new int[K];    // 전기용품 사용 순서
        Map<Integer, Integer> map = new HashMap<>();    // 사용할 전기 제품들

        st = br.readLine().split(" ");
        for(int i=0; i<K; i++) {
            products[i] = Integer.parseInt(st[i]);  // 사용순서 기록
            map.merge(products[i], 1, Integer::sum);    // 사용할 전기 제품들을 map에 저장
        }
        int result = 0; // 플러그를 뽑은 횟수
        Loop:
        for(int i=0; i<K; i++) {    // 플러그에 꽂은 개수 이후부터 전기용품 사용 탐색
            map.merge(products[i], -1, Integer::sum);   // 현재 제품은 사용할 제품 map에서 개수 줄임
            if(map.get(products[i]) == 0) map.remove(products[i]);  // 개수가 0개가 됐으면 아예 삭제
            for(int j=0; j<N; j++) {    // 플러그에 꽂힌 제품 탐색
                if(plug[j] == 0) {  // 플러그가 비어 있다면
                    plug[j] = products[i];  // 빈자리에 제품을 꽂고
                    continue Loop;  // 다음 제품으로
                } else if(plug[j] == products[i]) {    // 이미 꽂혀 있다면
                    continue Loop;  // 다음 사용할 제품으로
                }
            }
            for(int j=0; j<N; j++) {    // 플러그 탐색
                if(map.get(plug[j]) == null) {  // 나중에 사용하지 않는 제품이 꽂혀 있다면
                    plug[j] = products[i];  // 그 위치에 지금 제품을 꽂음
                    result++;   // 뽑은 횟수 증가
                    continue Loop;  // 다음 제품으로
                }
            }
            int n = 0;  // 나중에 사용하는 제품의 순서
            int m = 0;  // 뽑을 제품의 플러그에서 위치
            for(int j=0; j<N; j++) {    // 플러그 탐색
                for(int k=i+1; k<K; k++) {  // 현재 제품 이후 탐색
                    if(plug[j] == products[k]) {    // 이미 꽂힌 제품을 처음 찾았을 때
                        if(n < k) { // 그 순서가 더 크다면
                            n = k;  // 그 제품 순서를 저장
                            m = j;  // 뽑을 제품 위치 저장
                        }
                        break;  // 다음 플러그 위치 탐색
                    }
                }
            }
            plug[m] = products[i];  // 꽂힌 플러그중 나중에 사용하는 제품에 현재 제품을 꽂음
            result++;   // 뽑은 횟수 증가
        }

        System.out.println(result); // 뽑은 횟수 출력
    }
}
