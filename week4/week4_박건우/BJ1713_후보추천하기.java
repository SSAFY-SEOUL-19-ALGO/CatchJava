package week4_박건우;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BJ1713_후보추천하기 {
	static int N, M;
	static int[] students = new int[101];	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new  StringBuilder();
		String[] ipt;
		int student, num;
		
		// N, M 입력받기
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		ArrayList<Student> stdli = new ArrayList<>();
		ipt = br.readLine().split(" ");	// 추천학생 번호들 입력받기
		for(int i = 0; i < M; i++) {
			student = Integer.parseInt(ipt[i]);
			if(students[student] > 0) {
				students[student] += 1;
				for(int j = 0; j < stdli.size(); j++) {
					if(stdli.get(j).num == student) {
						stdli.get(j).total += 1;
						break;
					}
				}
			} else {
				if(stdli.size() >= N) {
					Collections.sort(stdli);
					num = stdli.get(0).num;
					students[num] = 0;
					stdli.remove(0);
				}
				stdli.add(new Student(student, 1, i));
				students[student] = 1;
			}
		}
		for(int i = 0; i < 101; i++) {
			if(students[i] != 0)
				bw.write(i + " ");
		}
		
		bw.write("\n");
		bw.flush();
	}
}

class Student implements Comparable<Student>{
	int num;
	int total;
	int time;
	public Student(int num, int total, int time) {
		super();
		this.num = num;
		this.total = total;
		this.time = time;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.total == o.total) {
			return this.time - o.time;
		} else if(this.total < o.total) return -1;
		else return 1;
	}
}