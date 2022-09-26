package week8.week8_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1417_국회위원선거 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 사람 수

		int cnt = 0; // 매수할 사람의 수
		
		int[] p = new int[N];
		for(int i=0; i < N; i++) {
			p[i] = Integer.parseInt(bf.readLine());
		} // 입력 완료
		
		while(true){
            int maxp =0; // 가장 득표수가 큰 사람
            for(int i=0;i<N;i++){
                if(p[i]>=p[maxp])
                    maxp = i;
            }
            if(maxp ==0){
                break;
            }

            p[0]++; // 다솜이 매수 성공
            p[maxp]--; // 가장 득표수 많은 사람걸 뺏기
            cnt++;
        }
        System.out.println(cnt);
    }
}