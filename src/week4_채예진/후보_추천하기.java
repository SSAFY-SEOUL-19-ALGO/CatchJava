package week4_채예진;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 후보_추천하기 {
	
	static class Student implements Comparable<Student> {
		
		int student;
		int index;
		int count;
		
		Student(int student, int index, int count) {
			this.student = student;
			this.index = index;
			this.count = count;
		}

		@Override
		public int compareTo(Student o) {
			if (this.count != o.count) return this.count - o.count; // 추천받은 횟수 작은 순 
			return this.index - o.index; // 일찍 들어온 순 
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt(); // 사진틀의 개수 
		int cnt = sc.nextInt(); // 전체 학생의 총 추천 횟수 

		int[] students = new int[101]; // 학생 숫자 확인  
		List<Student> list = new ArrayList<>(); // 사진틀, 학생 번호와 추천받은 횟수 
		
		for (int i = 0; i < cnt; i++) {
			int cand = sc.nextInt();
			
			if (students[cand] == 0) { // 사진틀에 없을 경우 
				if (list.size() >= N) { // 비어있는 사진틀이 없는 경우 
					Collections.sort(list); // 추천 횟수 기준으로 정렬 
					Student student = list.remove(0); // 추천 횟수가 가장 적은 값 제거 
					students[student.student] = 0;
				}
				list.add(new Student(cand, i, 1)); // 현재 학생 사진틀에 게시 
				students[cand] = 1;
			} else { // 사진틀에 이미 있을 경우 
				students[cand]++;
				for (Student s: list) { // 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우 
					if (s.student == cand) { 
						s.count++;// 추천받은 횟수 증가 
						break;
					}
				}
			}
		}
		
		int[] result = new int[N];
		int resCnt = 0;
		for (Student s: list) {
			result[resCnt++] = s.student;
		}
		Arrays.sort(result);; // 최종 후보의 학생번호를 증가하는 순서대로 정렬
		
		// 출력 
		for (int i = 0; i <101; i++) {
			if(students[i]!=0) {
				sb.append(i + " ");
			}
		}
		
		System.out.println(sb);
		
	}


}

/* 100까지 갔는데 틀렸다고 함 
 * 	static class Student implements Comparable<Student> {
		
		int student;
		int index;
		int count;
		
		Student(int student, int index, int count) {
			this.student = student;
			this.index = index;
			this.count = count;
		}

		@Override
		public int compareTo(Student o) {
			if (this.count != o.count) return this.count - o.count; // 추천받은 횟수 작은 순 
			return this.index - o.index; // 일찍 들어온 순 
		}
		
	}
	
	static List<Student> list;
	
	static boolean find(int cand) { // 이미 리스트에 있는지 확인 

		for (Student s: list) { // 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우 
			if (s.student == cand) { 
				s.count++;// 추천받은 횟수 증가 
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt(); // 사진틀의 개수 
		int cnt = sc.nextInt(); // 전체 학생의 총 추천 횟수 

		list = new ArrayList<>(); // 사진틀, 학생 번호와 추천받은 횟수 
		
		for (int i = 0; i < cnt; i++) {
			int cand = sc.nextInt();
			
			if (list.size() < N) { // 사진틀이 비어있을 경우 추천받은 학생의 사진은 반드시 사진틀에 게시되어야 한다. 
				if (!find(cand)) list.add(new Student(cand, i, 1));
			} else { // 비어있는 사진틀이 없는 경우 
				if (!find(cand)) {
					Collections.sort(list); // 추천 횟수 기준으로 정렬 
					list.remove(0); // 추천 횟수가 가장 적은 값 제거 
					list.add(new Student(cand, i, 1)); // 현재 학생 사진틀에 게시 
				}
			}
		}
		
		int[] result = new int[N];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i).student;
		}
		Arrays.sort(result);; // 최종 후보의 학생번호를 증가하는 순서대로 정렬
		
		// 출력 
		for (int i = 0; i < N; i++) {
			sb.append(result[i] + " ");
		}
		
		System.out.println(sb);
		
	}

 */
