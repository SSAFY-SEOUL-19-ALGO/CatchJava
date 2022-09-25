package week7.week7_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P13164_행복유치원 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s[] = bf.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 원생의 수
		int K = Integer.parseInt(s[1]); // 조의 개수
		
		int[] std = new int[N];
		String s1[] = bf.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			std[i] = Integer.parseInt(s1[i]);
		}// input end
		
		int[] diff = new int[N-1];
		
		for (int i = 0; i < N-1; i++) {
			diff[i] += std[i+1]-std[i];
		} // 연속된 두 학생의 키 차이 저장
		
		Arrays.sort(diff); // 작은 키 차이를 위해 정렬
		
		int cost = 0; // 티셔츠 만드는 비용
		// N-1-(K-1) 정렬된 키차이 배열의크기 - K 개의 조를 만들때 
		for (int i = 0; i < N-K; i++) {
			cost += diff[i];
		}
		System.out.println(cost); 
		
	} // main end

}

// 시간 초과 ..
//public class P13164_행복유치원 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String s[] = bf.readLine().split(" ");
//		int N = Integer.parseInt(s[0]); // 원생의 수
//		int K = Integer.parseInt(s[1]); // 조의 개수
//		
//		int[] std = new int[N];
//		String s1[] = bf.readLine().split(" ");
//		for (int i = 0; i < N; i++) {
//			std[i] = Integer.parseInt(s1[i]);
//		}// input end
//		
//		int cost = 0; // 티셔츠 만드는 비용
//
//		for (int i = 0; i < N-1; i+=(K-1)) { // k-1 번 나누니까 ..
//			cost += std[i+1]-std[i];
//		}
//		
//		System.out.println(cost);
//		
//	} // main end
//
//}