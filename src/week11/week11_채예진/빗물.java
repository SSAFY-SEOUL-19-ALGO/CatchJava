package week11.week11_채예진;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 빗물이 고이는 조건 
// 왼쪽에서 제일 높은 거, 오른쪽에서 제일 높은 거 찾아 그 중 작은 거에 맞추기 
public class 빗물 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int H = Integer.parseInt(input[0]); // 세로 길이 
		int W = Integer.parseInt(input[1]); // 가로 길이
		
		int[] arr = new int[W];
		input = br.readLine().split(" ");
		for (int w = 0; w < W; w++) {
			arr[w] = Integer.parseInt(input[w]);
		}
		
		int answer = 0;
		for (int w = 1; w < W; w++) {
			int current = arr[w];
			int start = arr[w];
			int end = arr[w];
			
			for (int i = w - 1; i >= 0; i--) { // 왼쪽에서 제일 높은 거 찾기 
				if (start < arr[i]) start = arr[i];
			}
			
			for (int j = w + 1; j < W; j++) { // 오른쪽에서 제일 높은 거 찾기 
				if (end < arr[j]) end = arr[j];
			}
			
			answer += Math.min(start, end) - current;
		}
		
		System.out.println(answer);
	}

}

// 처음에 한 생각: start에 배열 0번 넣고.. 거기보다 작으면 answer에 더하고.. 거기보다 크면... 또 빼기 해서 answer에 더하려고 했는데.. start가 제일 크다면.. 그것도 문제가 됨.. 다 더해놓고.. 갑자기 빼는 게 크흠..