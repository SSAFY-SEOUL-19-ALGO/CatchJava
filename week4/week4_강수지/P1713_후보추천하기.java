package week4_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class P1713_후보추천하기 {

	public static void main(String[] args) throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 사진틀 수
		List<Integer> pick = new ArrayList<Integer>(); // 후보 친구들
		
		int R = Integer.parseInt(bf.readLine()); // 추천 횟수
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		int[] reco = new int[R]; // 추천받은 친구들의 번호
		for (int i = 0; i < R; i++) {
			reco[i] = Integer.parseInt(st.nextToken());
		} // 입력 완료
		
		int[] student = new int[101]; // 최대 학생은 100까지 있으므로 학생 추천수
		for (int i = 0; i < R; i++) { // 추천 횟수만큼 반복
			if(student[reco[i]]==0) { // 추천받은적 없는 친구일때
				if(pick.size()<N) { // 사진틀에 게시할 수 있는 경우
					pick.add(reco[i]);
					student[reco[i]]++;
				}
				else { // 사진틀이 꽉찬 경우
					// 추천 수가 가장 작은 학생
					// 이 조건이 2명이상이면 가장 오래 된 학생 삭제 !
					int min = 0;
					int minstd = Integer.MAX_VALUE;
					int minidx = 0;
					for (int j = 0; j < pick.size(); j++) { // 지금 사진틀의 사람들 중 가장 추천 수가 적은 사람 !
						int std = pick.get(j);
						if(minstd>student[std]) {
							minstd = student[std];
							min = std;
							minidx = j;
						}
					}
					student[min] = 0; // 추천 수 초기화
					pick.remove(minidx); // 안녕 ..
					pick.add(reco[i]); // 삭제한 자리에 새로 추천받은 친구를 넣어준다
					student[reco[i]]++; // 추천 수를 세어준다
				}
			}else { // 사진틀에 이미 있는 경우
				student[reco[i]]++; // 추천 수만 세어준다
			}
		}
		
		// 학생 번호 오름차순으로 정렬하기 위해서 
		pick.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for (int i = 0; i < pick.size(); i++) {
			System.out.print(pick.get(i)+" ");
		}
	}

}
