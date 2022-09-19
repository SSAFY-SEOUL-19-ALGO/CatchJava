package week6.week6_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B12018_yonseitoto {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int mileage = nm[1];
		int success = 0;

		ArrayList<Integer> todo = new ArrayList<>();
		for (int i = 0; i < nm[0]; i++) {
			int[] pl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			// 신청한 인원수가 더 적으면 1만 넣어도 가능
			if (pl[0] < pl[1]) {
				if (mileage - 1 >= 0) {
					success++;
					mileage -= 1;
				}
				br.readLine();
				// 신청한 인원수가 정원과 같거나, 정원보다 많으면 막차타기. 가장 적게 넣은 마일리지와 같게 만들기
			} else {
				int[] otherM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				Arrays.sort(otherM);
				//Arrays.sort(otherM,reverseOrder());
				//pl[1]명까지 추가 가능. (전체 인원-pl[1])의 인덱스에 해당하는 값이 마일리지 컷
				todo.add(otherM[pl[0] - pl[1]]);
			}
		} // 신청 과목
		Collections.sort(todo);

		// 마일리지가 적은 순부터 넣기. 남은 마일리지보다 더 많이 필요하면 break.
		for (int i : todo) {
			if (mileage >= i) {
				mileage -= i;
				success++;
			} else {
				break;
			}
		}
		System.out.println(success);

	}// main
}// class
