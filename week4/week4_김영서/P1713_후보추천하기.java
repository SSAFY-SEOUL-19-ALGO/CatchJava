package week4_김영서;

import java.io.*;
import java.util.*;

public class P1713_후보추천하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int total = 0, now = 0, changeIdx = 0;
		int pictureNum = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int[] student = new int[pictureNum];
		int[] recommend = new int[pictureNum];
		int[] time = new int[pictureNum];

		total = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int x = 0; x < total; x++) {
			now = Integer.parseInt(st.nextToken());
			changeIdx = 0;

			for (int y = 0; y < pictureNum; y++) {
				// 사진틀이 비어있거나, 이미 게시된 경우
				if (student[y] == 0 || student[y] == now) {
					changeIdx = y;
					break;
				}
				// 추천 횟수가 더 적거나, 추천횟수가 같고 시간이 더 빠른 경우
				if (recommend[changeIdx] > recommend[y]
						|| (recommend[changeIdx] == recommend[y] && time[changeIdx] > time[y])) {
					changeIdx = y;
				}
			}

			if (student[changeIdx] != now) {
				student[changeIdx] = now;
				recommend[changeIdx] = 0;
				time[changeIdx] = x;
			}

			recommend[changeIdx]++;
		}

		Arrays.sort(student);

		for (int x : student) {
			if (x != 0)
				bw.write(String.valueOf(x) + " ");

		}
	}
}
