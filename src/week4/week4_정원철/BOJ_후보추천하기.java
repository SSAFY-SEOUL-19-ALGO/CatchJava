package week4.week4_정원철;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BOJ_후보추천하기 {

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
		List<Integer> pictures=new LinkedList<>(); // 사진틀
		List<Integer> recCnt=new LinkedList<>(); // 인덱스 대비 받은 투표수
		
		for(int i=0; i<M; i++) {
			students.add(sc.nextInt()); // 추천학생 번호 쭉 입력
		}
		
		for(int i=0; i<M;i++) { 
			if(pictures.contains(students.get(i))) { // 사진틀에 추천학생이 존재하면
				
				for(int j=0; j<pictures.size(); j++) {
					if(students.get(i)==pictures.get(j)) {
						recCnt.set(j, recCnt.get(j)+1);
					}
				}
			}else {
				if(pictures.size()>=N) {
					for(int j=0; j<N; j++) {
						if(recCnt.get(j)==minCtr(recCnt)) {
							pictures.remove(j);
							recCnt.remove(j);
							break;
						}
					}
				}
				
				pictures.add(students.get(i));
				recCnt.add(1);
			}
		}
		
		Collections.sort(pictures);
		
		
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
		
		
		
		


