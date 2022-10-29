package week11.week11_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 멀티탭_스케줄링 {
	static int N;// 구멍 수 , 물건갯수
	static int[] hole, plug, freq;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		hole = new int[Integer.parseInt(st[0])];
		N = Integer.parseInt(st[1]);
		plug = new int[N];
		freq = new int[N + 1];
		st = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			plug[i] = Integer.parseInt(st[i]);
			freq[plug[i]]++;// 빈도수체크
		}
		int cnt = 0;
		int result = 0;
		for (int i = 0; i < N; i++) {// 채워넣자
			boolean plag = false;
			for (int j = 0; j < hole.length; j++) {
				if (hole[j] == plug[i]) {//이미 꽂혀있다면 동작할 필요 X
					plag = true;
					freq[plug[i]]--;
					break;
				}
			}
			if (plag == true) {
				continue;
			}
			if (cnt < hole.length) {//자리가 비었다
				hole[cnt] = plug[i];//빈자리에 꽂고 끝
				freq[plug[i]]--;
				cnt++;
			} else {//꽉채웠다 -> 교체 필요
				//현재 꽂혀있는 기구 중 사용안하는 기구를 제거
				//모두 사용한다면 가장 나중에 사용하는 기구를 제거
				
				for (int j = 0; j < hole.length; j++) {// 전체 홀을 탐색
					if(freq[hole[j]]==0) {//현재 기구가 재사용이 없다
						hole[j]=plug[i];//교체
						freq[plug[i]]--;
						plag=true;
						break;
					}
				}
				if(!plag) {//모든기구가 재사용된다->가장 늦게 사용되는기구를 제거
					//복사본을 만들자...
					int last=check(i);//제일 늦게 나오는 애
					for(int k=0;k<hole.length;k++) {
						if(hole[k]==last) {
							hole[k]= plug[i];//빈자리에 꽂고 끝
							freq[plug[i]]--;
						}
					}
				}
				
			
				result++;
			}
		}

		System.out.println(result);
	}

	private static int check(int i) {
		int copy_cnt=hole.length;
		int[]copy_hole=new int[copy_cnt];
		
		for(int j=0;j<copy_cnt;j++) {
			copy_hole[j]=hole[j];
		}
		for(int j=i;j<N;j++) {
			for(int k=0;k<hole.length;k++) {
				if(copy_hole[k]==plug[j]) {//재사용된다.
					copy_hole[k]=0;
					copy_cnt--;
				}
			}
			if(copy_cnt==1) {
				int last=0;
				for(int k=0;k<hole.length;k++) {
					last+=copy_hole[k];
				}
				return last;
			}
		}
		return 0;
	}

}
