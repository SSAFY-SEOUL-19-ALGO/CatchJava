package week11.week11_조민수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class 가르침 {
	static int N, K,result;
	static String[] word;
	static boolean[] check;// 단어 빈도수 체크

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		K = Integer.parseInt(st[1]);
		result=0;
		if(K<5) {
			System.out.println(0);//기본 단어가 5개기 때문에 아무것도 못읽음
			return;
		}
		if(K==26) {
			System.out.println(N);//전체 다 읽기 가능
			return;
		}
		
		check = new boolean[26];
		word=new String[N];
		check['a'-'a']=true;
		check['t'-'a']=true;
		check['c'-'a']=true;
		check['i'-'a']=true;
		check['n'-'a']=true;
		//필수 포함 단어는 true;
		for (int i = 0; i < N; i++) {
			word[i]= br.readLine();
		}
		comb(0,5);//5개는 골랐다
		System.out.println(result);
	}

	private static void comb(int start, int length) {
		// TODO Auto-generated method stub
		 if(length == K) {
	            int count = 0;
	            for(int i = 0; i < N; i++) { //뽑은 알파벳으로 몇개의 단어를 읽을 수 있는지 카운트.
	                boolean read = true;
	                for(int j = 0; j < word[i].length(); j++) {
	                    if(!check[word[i].charAt(j) - 'a']) {
	                        read = false;
	                        break;
	                    }
	                }
	                if(read) count++;
	            }
	            result = Math.max(result, count);
	            return;
	        }
	        
	        for(int i = start; i < 26; i++) {
	            if(check[i] == false) {
	            	check[i] = true;
	                comb(i, length + 1);
	                check[i] = false;
	            }
	        }
	    }
}
