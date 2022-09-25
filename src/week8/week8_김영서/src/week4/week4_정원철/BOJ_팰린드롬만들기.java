package week4.week4_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Queue;


public class BOJ_팰린드롬만들기 {

	static StringBuilder alpha=new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
	static int [] alphaNum=new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String test= br.readLine();
		char [] temp=test.toCharArray();
		// 알파벳 개수 측정
		for(int i=0; i<test.length(); i++) {
			alphaNum[alpha.indexOf(String.valueOf(test.charAt(i)))]++;
		}
		
		int oddCnt=0;
		int oddPoint=0;
		for(int i=0; i<26; i++) {
			if(alphaNum[i]%2!=0) {
				oddCnt++;
				oddPoint=i;
			}
			//홀수가 1개 넘으면 아웃
			if(oddCnt>1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}
		
		char oddAlpha=alpha.charAt(oddPoint);
		Arrays.sort(temp);
		Queue<Character> temp_list = new ArrayDeque<>();
		
		for(int i=0; i<test.length(); i++) {
			temp_list.add(temp[test.length()-1-i]);
		}
		
		ArrayList<Character> result_L= new ArrayList<>();
		ArrayList<Character> result_R= new ArrayList<>();
		char mid=' ';
		int chk=0;
		while(!temp_list.isEmpty()) {
			if(chk==0 && temp_list.peek()==oddAlpha && oddCnt!=0) {
				mid=temp_list.poll();
				chk++;
				continue;
			}
			result_L.add(0,temp_list.poll());
			result_R.add(temp_list.poll());	
		}
		
		int len=result_L.size();
		for(int i=0; i<len; i++) {
			System.out.print(result_L.get(i));
		}
		if(mid!=' ') System.out.print(mid);
		for(int i=0; i<len; i++) {
			System.out.print(result_R.get(i));
		}
		

		
		
	}

}
