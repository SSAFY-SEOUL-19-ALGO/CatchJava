package week4.week4_정원철;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_문자열집합조합하기 {
	static String resultSrc="";
	static ArrayList<String>result=new ArrayList<>();
	static ArrayList<char[]> list= new ArrayList<>();
	static ArrayList<String> result_temp= new ArrayList<>();
	//static StringBuilder s
	static void combination(char[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
	
    static void print(char arr[], boolean[] visited, int n) {
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	//System.out.println(arr[i]);
            	resultSrc=resultSrc.concat(String.valueOf(arr[i]));
            }
        }
        
       // System.out.println(sb);
        //resultSrc=sb.toString();
    	result.add(resultSrc);
        //System.out.println(resultSrc);
    	resultSrc="";
    }
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		

		char []test;
		for (int i=0; i<3; i++) {
			test=sc.next().toCharArray();
			list.add(test);
		}
		int k= sc.nextInt();
		
		for (int i=0; i<3; i++) {
			
			boolean visited[] =new boolean[list.get(i).length];
			combination(list.get(i), visited, 0, list.get(i).length, k);
			
		}
		
		
		Collections.sort(result);
		String t=result.remove(0);
		int dupleCnt=1;
		for (int i=0; i<result.size(); i++) {
			if(t.equals(result.get(i)) && dupleCnt==1) {
				result_temp.add(result.get(i));
				dupleCnt++;	
			}else if(!t.equals(result.get(i))) {
				dupleCnt=1;
				t=result.get(i);
			}
		}
		
		if(result_temp.size()==0) {
			System.out.println(-1);
		}else {
			for(int i=0; i<result_temp.size(); i++) {
				System.out.println(result_temp.get(i));
			}
			
		}
		//System.out.println(result);
		
	}

}
