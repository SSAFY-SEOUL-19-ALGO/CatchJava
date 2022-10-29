package week11.week11_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 1. 사용하려는 전기 용품의 콘센트가 꽂혀있는 경우  
// 2. 꽂혀있지 않은 경우
// 		비어있는 곳에 꽂기
//		나중에 사용하지 않을 거 빼고 지금 거 꽂기
//		제일 나중에 사용할 거 빼고 지금 거 꽂기 - ㄹㅇ 맨 마지막에 사용하는 것이 아니라 처음 나오는 순서가 제일 늦은 경우 
public class 멀티탭_스케줄링 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 멀티탭 구멍의 수 
		int K = Integer.parseInt(input[1]); // 전기 용품의 총 사용횟수 
		
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Set<Integer> set = new HashSet<>();
		
		int answer = 0;

		for (int i = 0; i < K; i++) {
			if (!set.contains(arr[i])) { // 꽂혀있지 않은 경우 
				if (set.size() >= N) {
					List<Integer> list = new ArrayList<>(); // 나중에 사용할 거 확인 때문에 
					List<Integer> remain = new ArrayList<>(set); // 나중에라도 사용하지 않을 것들 
					for (int j = i; j < K; j++) { // 다음 것들 확인 
						if (set.contains(arr[j]) && !list.contains(arr[j])) {
							list.add(arr[j]); // 나중에 사용함 
							remain.remove((Object) arr[j]); // 이후에 사용할 것들 -> Object로 한 이유 : arr[j]가 int 형이기 때문에 index로 인식하기 때문 
						}
					}
					
					if (list.size() == N) {
						set.remove(list.remove(list.size() - 1));
					} else {
						// 나중에 사용 안하는 것들 제거 
						set.remove(remain.get(0)); 
					}
					
					answer++;
				} 
				set.add(arr[i]);
			}
		}
		
		System.out.println(answer);
	}

}
