package week8.week8_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BrokenBarrierException;

public class 국회의원선거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//후보 수
		int my=Integer.parseInt(br.readLine());//내 득표수
		int cnt=0;
		int[] candidate=new int [N-1];
		for(int i=0;i<N-1;i++) {
			candidate[i]=Integer.parseInt(br.readLine());
		}
		while (true) {
			int max=0;
			int idx=0;
			for(int i=0;i<N-1;i++) {
				if(candidate[i]>max) {
					max=candidate[i];
					idx=i;
				}
			}
			if(max>=my) {
				candidate[idx]--;
				my++;
				cnt++;
			}
			else {
				break;
			}
					
		}
		System.out.println(cnt);
		
		
		
	}

}
