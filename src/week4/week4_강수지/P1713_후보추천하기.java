package week4.week4_강수지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1713_후보추천하기 {
	static class student{
		int no, rec, old; // 학생번호 추천수 오래된순

		public student(int no, int rec, int old) {
			super();
			this.no = no;
			this.rec = rec;
			this.old = old;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine()); // 사진틀 수
		int R = Integer.parseInt(bf.readLine()); // 추천 횟수
		
		StringTokenizer st = new StringTokenizer(bf.readLine()); // 추천 받은 학생들
		PriorityQueue<student> pick = new PriorityQueue<>(new Comparator<student>() {

            @Override
            public int compare(student o1, student o2) {
                if (o1.rec == o2.rec) return o1.old - o2.old; // 2. 추천수 같은 경우 시간순
                return o1.rec - o2.rec; // 1. 추천수
            }

        }); // 사진틀에 추가된 사람들을 받을때  !
		
		int[] vote = new int[101]; // *************투표 수 저장 배열 초기화
		
		int older = 1; // 시간 ..
		while(st.hasMoreTokens()) { // 추천 횟수만큼
			int num = Integer.parseInt(st.nextToken()); // 현재 추천 받은 학생 번호
			
			if (vote[num] != 0) { // *************이미 추천 받았던 학생인 경우
	            student[] tmp = new student[pick.size()];
	            for (int i = 0; i < tmp.length; i++) {
	               tmp[i] = pick.poll();
	            }
	            pick.clear(); // pick 우선순위 큐를 비우고
	             
	            for(student s: tmp) { // 원래 pick 에 들어있던 원소 수 만큼 반복하며
	               if(s.no == num) { //  이미 추천받은 친구가 나오면
	                   s.rec++; // 원래 있었던 친구의 추천수 +1
	                   vote[num]++; // *************학생 번호 인덱스에 추가
	               }
	               pick.offer(s); // 나머지는 그냥 다시 옮겨 넣기
	            }
	         }

			else if(pick.size()>=N) { // 사진틀이 꽉찬 경우
				student cur = pick.poll(); // 빼
				vote[cur.no] = 0; // 초기화
                vote[num]++; // ************* 새로운 학생 번호 인덱스에 추가 
				pick.offer(new student(num, 1, older++)); // 새로운 친구 추가
			}
			else { // 추천 받은적 없는 뉴페이스라면
				vote[num]++; // *************학생 번호 인덱스에 추가 
				pick.offer(new student(num, 1, older++)); // 큐에 그냥 추가 !
			}
		} // recommend end
		
		int[] result = new int[N]; // 결과 출력
		int idx = 0; 
		while(!pick.isEmpty()) {
			result[idx++] = pick.poll().no; //학생 번호를 저장 ..
		}
		
		// 오름 차순 출력을 위해
		Arrays.sort(result);
		
		for(int e:result) {
			if(e!=0) System.out.print(e+" ");
		}
		
	} // main end

}

// 우선순위 큐를 사용해서 풀고 싶어 .. 안녕 !

//public static void main(String[] args) throws IOException {
//
//	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//	int N = Integer.parseInt(bf.readLine()); // 사진틀 수
//	List<Integer> pick = new ArrayList<Integer>(); // 후보 친구들
//	
//	int R = Integer.parseInt(bf.readLine()); // 추천 횟수
//	StringTokenizer st = new StringTokenizer(bf.readLine()," ");
//	int[] reco = new int[R]; // 추천받은 친구들의 번호
//	for (int i = 0; i < R; i++) {
//		reco[i] = Integer.parseInt(st.nextToken());
//	} // 입력 완료
//	
//	int[] student = new int[101]; // 최대 학생은 100까지 있으므로 학생 추천수
//	for (int i = 0; i < R; i++) { // 추천 횟수만큼 반복
//		if(student[reco[i]]==0) { // 추천받은적 없는 친구일때
//			if(pick.size()<N) { // 사진틀에 게시할 수 있는 경우
//				pick.add(reco[i]);
//				student[reco[i]]++;
//			}
//			else { // 사진틀이 꽉찬 경우
//				// 추천 수가 가장 작은 학생
//				// 이 조건이 2명이상이면 가장 오래 된 학생 삭제 !
//				int min = 0;
//				int minstd = Integer.MAX_VALUE;
//				int minidx = 0;
//				for (int j = 0; j < pick.size(); j++) { // 지금 사진틀의 사람들 중 가장 추천 수가 적은 사람 !
//					int std = pick.get(j);
//					if(minstd>student[std]) {
//						minstd = student[std];
//						min = std;
//						minidx = j;
//					}
//				}
//				student[min] = 0; // 추천 수 초기화
//				pick.remove(minidx); // 안녕 ..
//				pick.add(reco[i]); // 삭제한 자리에 새로 추천받은 친구를 넣어준다
//				student[reco[i]]++; // 추천 수를 세어준다
//			}
//		}else { // 사진틀에 이미 있는 경우
//			student[reco[i]]++; // 추천 수만 세어준다
//		}
//	}
//	
//	// 학생 번호 오름차순으로 정렬하기 위해서 
//	pick.sort(new Comparator<Integer>() {
//		@Override
//		public int compare(Integer o1, Integer o2) {
//			return o1-o2;
//		}
//	});
//	
//	for (int i = 0; i < pick.size(); i++) {
//		System.out.print(pick.get(i)+" ");
//	}
//}