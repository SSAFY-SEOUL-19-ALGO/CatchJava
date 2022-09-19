package week6.week6_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class P12018_YonseiToTo {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		int n = Integer.parseInt(s[0]); // 과목 수
		int m = Integer.parseInt(s[1]); // 마일리지

		int[] min = new int[n]; // 각 과목별 수강신청 최소 마일리지

		for (int i = 0; i < n; i++) { // 과목 수 만큼

			String[] s1 = bf.readLine().split(" ");
			int p = Integer.parseInt(s1[0]); // 신청한 사람
			int l = Integer.parseInt(s1[1]); // 수강 가능 인원
			int[] mile = new int[p]; // 마일리지 ..

			String[] s2 = bf.readLine().split(" ");
			for (int j = 0; j < p; j++) { // 신청한 사람들의 마일리지
				mile[j] = Integer.parseInt(s2[j]);
			}// 입력 완료

			if(p<l) {
				 min[i] = 1; // 신청인원이 수강 인보다 작으면 수강 가능 +1
				 continue;
			}else {
				reverseSort(mile); // 내림차순 정렬
				min[i] = mile[l-1];
			}
		}

			Arrays.sort(min); //마일리지 작게 해야지 많이 들으니까 다시 오름차순
			int sum = 0; // 마일리지 합
			int cnt = 0; // 수강신청 가능
			for (int j = 0; j < n; j++) {
				// 주어진 마일리지 만큼 더해주기 ..
				sum += min[j];

				if(sum>m) break;
				cnt++;
			}
			System.out.println(cnt);

	} // main end


	public static void reverseSort(int[] arr) { // 내림차순 정렬
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

}