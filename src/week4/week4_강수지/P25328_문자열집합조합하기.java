package week4.week4_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P25328_문자열집합조합하기 {
	static int K;
	static char[] selected;
	static Map<String, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String X = bf.readLine(); // 문자열 입력
		String Y = bf.readLine();
		String Z = bf.readLine();

		K = Integer.parseInt(bf.readLine()); // 만들 문자열 개수
		selected = new char[K]; // 만들어진 조합
		
		map = new HashMap<>(); // 나 이거 처음 써봐 ..아닌가
		PriorityQueue<String> ans = new PriorityQueue<>(); // 오름차순 출력을 위해 사용
		
		// 각 문자열로 조합 만들기
		comb(0, 0, X);
		comb(0, 0, Y);
		comb(0, 0, Z);
		
		for (String key: map.keySet()) {
			int tmp = map.get(key); // 해당 문자열의 횟수가
			if(tmp>=2) { // 2 이상이면 우선순위 큐에 저장
				ans.offer(key);
			}
		}
		
		if(ans.isEmpty()) { // 저장된 문자열이 없다면
			System.out.println(-1);
		}else {
			while(!ans.isEmpty()) { // 문자열이 존재하면 큐가 빌때까지 출력
				System.out.println(ans.poll());
			}
		}
		
	} // main end
	private static void comb(int cnt, int start, String s) {
		if(cnt==K) { // 만들 조합의 수만큼 골랐으면 문자열을 만들기
			String pick = String.valueOf(selected);
			Integer count = map.get(pick); // 해당 문자열이 나왔던 횟수 확인
			if(count==null) { // 첫 등장이라면
				map.put(pick, 1); // 문자열과 나온 횟수를 1로 저장
			}else { // map 에 원래 있었다면
				map.put(pick, count+1); // 기존횟수 +1
			}
//			map.merge(pick, 1, Integer::sum); // 문자열과 기존 횟수+1 .. 윤환님 땡큐 ..
			return;
		}

		for(int i=start;i<s.length();i++) {
			selected[cnt] = s.charAt(i); // 고르고
			comb(cnt+1, i+1, s); // 다음 자리
		}
	}
}
