package week11.week11_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public class BOJ_멀티탭스케줄링 {
	
	static int holeNum, usingNum;
	static int multiTap[];
	static HashSet<Integer> schedule;
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String st[] =br.readLine().split(" ");
		schedule=new HashSet<>();
		holeNum=Integer.parseInt(st[0]);
		usingNum=Integer.parseInt(st[1]);
		multiTap=new int[usingNum];
		
		st=br.readLine().split(" ");
		for(int i=0; i<usingNum; i++) {
					multiTap[i]=Integer.parseInt(st[i]);
		}
		
		
		// 멀티탭이 다 찼을때 남아잇는 번호의 물건중 가장 적게나오는 번호를  골라가며 풀이
		int cnt = 0;
		for(int i = 0; i < usingNum; i++) {
			
			if(schedule.contains(multiTap[i])) 
				continue;
			
			if (schedule.size() < holeNum) {
				schedule.add(multiTap[i]);
				continue;
			}
		
			int max = Integer.MIN_VALUE, choice = -1;
			for (int num : schedule) {
				int tmp = 0;	
				for (int j = i + 1; j < usingNum; j++) {
					if (num == multiTap[j]) {
						break;
					}
					tmp++;
				}
				if (tmp > max) {
					choice = num;
					max = tmp;
				}

			}
			schedule.remove(choice);
			schedule.add(multiTap[i]);

			cnt++;
		}
		
		System.out.println(cnt);
		}
	}


