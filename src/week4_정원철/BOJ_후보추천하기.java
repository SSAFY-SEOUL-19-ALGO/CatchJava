package week4_정원철;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_후보추천하기 {
	// 이문제 너무 짜증나
	// 첫번째 도전 우선순위큐 실패
	// 두번째 배열만 사용해서 풀이 실패
	// 배열로 풀이를하면 기간에 관련된 고려가 안됐었음...
	
	// 다 리스트로 사용
	
	
	//가장 적은 추천수를 가지고있는 후보의 값을 
	static int minCtr(List<Integer> arr) {
		int min = arr.get(0);
		int minIndex = 0;

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) < min) {
				min = arr.get(i);
				minIndex = i;
			}
		}

		return min;
	}

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt(); // 사진틀의 개수
		int M=sc.nextInt(); // 투표 수
		
		List<Integer> students=new LinkedList<>(); // 추천 번호
		List<Integer> recCnt=new LinkedList<>(); // 인덱스 <-> 받은 투표수(추천)
		
		List<Integer> pictures=new LinkedList<>(); // 사진틀
		
		// 리스트를 요소마다 따로 만들어서 각 인덱스에 대비되게 사용
		
		
		
		for(int i=0; i<M; i++) {
			students.add(sc.nextInt()); // 추천학생 번호 쭉 입력
		}
		
		
		//<<main process start>>
		
		for(int i=0; i<M;i++) { 
			//경우를 세가지로두고 움직임
			//1. 사진틀에 학생이 이미 존재하는경우 -> 확인 후 추천수만 늘림
			if(pictures.contains(students.get(i))) { // (1) 사진틀에 추천학생이 존재하면
				
				for(int j=0; j<pictures.size(); j++) { // (1)-1 사진틀의 후보수 만큼 탐색
					if(students.get(i)==pictures.get(j)) { //(1)-2 추천번호가 같다면
						recCnt.set(j, recCnt.get(j)+1); //(1)-3 그때 해당 번호의 학생 추천 카운트 ++
					}									
				}
				
			}else { // (2) 사진틀의 개수(N갠)를 넘어가거나 이미 차있는 상태라면(넣을 후보자가 사진틀에 포함되지 않고)
				if(pictures.size()>=N) { 
					for(int j=0; j<N; j++) { // (2)-1 사진틀의 수 탐색을 반복
						if(recCnt.get(j)==minCtr(recCnt)) { // (2)-2 최소 추천수를 가진 사람의 인덱스를 가져옴
							pictures.remove(j); // (2)-3 해당 후보 사진 삭제하고
							recCnt.remove(j); // (2)-4 해당 후보 추천수도 삭제
							break;
						}
					}
				}
				
				pictures.add(students.get(i)); // (3) 기존 사진틀에 포함되지도 않고 사진틀의 개수를 다 차지 하지 않고있다면 해당학생
												// 사진틀에 추가
				recCnt.add(1); // 해당 위치에 카운터도 추가
			}
		}
		
		
		Collections.sort(pictures); //(4) 사진에 들어간 후보자들 오름차순으로 정렬
		
		
		for(int i=0; i<pictures.size(); i++) {
			System.out.print(pictures.get(i)+" ");
		}

	}
		
}
		
//		Scanner sc=new Scanner(System.in);
//		int N=sc.nextInt();
//		int M=sc.nextInt();
//		
//		//int student[]=new int[M];
//		int studentBoard[][]=new int[N][3];
//		int student[]=new int[M-N];
//		
//		ArrayList<Integer> arr=new ArrayList<>();
//
//loop:		for (int i = 0; i < M; i++) {
//			
//			int src=sc.nextInt();
//			
//			if(i<N) {
//				for(int j=0; j<N; j++) {
//					if(src==studentBoard[j][0]) {
//						studentBoard[j][0]=src;
//						studentBoard[j][1]++;
//						break loop;
//					}	
//				}
//				
//				studentBoard[i][0]=src;
//				studentBoard[i][1]=0;
//				studentBoard[i][2]=N-i;
//				continue;
//			}
//			
//			student[i-N]=src;
//			
//		}
//		
//
//		out: for(int i=0; i<M-N; i++) {
//			int numChk=0;
//			for(int j=0; j<N; j++) {
//			
//				if(studentBoard[j][0]==student[i]) {
//					studentBoard[j][1]++;
//				}else if(studentBoard[j][0]!=student[i]) {
//					numChk++;
//					if(numChk==N) { // 다 다르면 두가지 경우로 나뉨, 0으로 비어있는 곳이 있을때, 아니면 다
//									// 채워져 있는데 기간별로 체크해서 나가리
//						
//						// 다 다르고 0이 있을때 (빈칸)
//						for(int x=0; x<N; x++) {
//							if(studentBoard[x][0]==0) {
//								studentBoard[x][0]=student[i];
//								studentBoard[x][1]=0;
//								studentBoard[x][2]=1;
//								break out;
//							}
//						}
//						
//						int min=Integer.MAX_VALUE;
//						int position=0;
//						//다 다른데 꽉 채워져 있을때
//						for(int x=0; x<N; x++) {							
//							if(studentBoard[x][1]<min) {
//								position=x;
//							}
//						}
//						studentBoard[position][0]=student[i];
//						studentBoard[position][1]=0;
//						studentBoard[position][2]=1;
//						
//					}
//				}
//				
//				
//			}
//		}
//		
//		
//		
//		for(int i=0; i<N; i++) {
//		System.out.print(studentBoard[i][0]+" ");
//	}
		
		
		
//		for (int i = 0; i < M; i++) {
//		
//
//		studentBoard[i][0]=arr2.get(i);
//		studentBoard[i][1]=0;
//		studentBoard[i][2]=N-i;
//	}
//		


////		int temp=0;
////		for(int i=0; i<M; i++) {
////			if(i<N) {
////				
////				if(arr.contains(studentBoard[i][0])) {
////					studentBoard[arr.indexOf(studentBoard[i][0])][1]++; // ��õī��Ʈ
////				}else {
////					studentBoard[i][0]=sc.nextInt(); // ����
////					studentBoard[i][1]=0; // ��õī��Ʈ
////					studentBoard[i][2]=N-i;// ������¥
////					arr.add(studentBoard[i][0]);
////					temp=studentBoard[i][0];
////					//System.out.println(arr);
////				}
////				
////			
////
////			}else {
////				student[i-N][0]=sc.nextInt();
////				student[i-N][1]=0;
////				student[i-N][2]=0;
////		
////			}
////		}
////		
////		for(int i=0; i<N; i++) {
////			System.out.print(studentBoard[i][0]+" ");
////		}
//		
//		
////		for(int i=0; i<M-N; i++) {
////			int numCnt=0;
////			for(int j=0; j<N; j++) {
////				
////				if(student[i][0]!=studentBoard[j][0]) {
////					numCnt++;
////				}
////				
////				
////				
////			}
////			
////	
////			
////		}
		
		
		
		


