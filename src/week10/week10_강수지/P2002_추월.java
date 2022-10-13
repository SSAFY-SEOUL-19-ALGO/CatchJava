package week10.week10_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P2002_추월 { // 발표 !
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 차의 대수
		
		HashMap<String, Integer> start = new HashMap<>(); 
		for (int i = 0; i < N; i++) {
			start.put(bf.readLine(), i+1);
		} // 차1 : 1, 차2: 2 ... 3 4 5 
		
		// 나오는 차는 앞에 받은 key만 저장하자 !
		int[] out = new int[N];
		for (int i = 0; i < N; i++) {
			String s =  bf.readLine();
			out[i] = start.get(s);
		} // 입력 완료
		
		int ans = 0;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) { // 앞뒤로 비교해나가면서
				if(out[i]>out[j]) { // 추월하는 경우 !
					ans++;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
}
