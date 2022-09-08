package week5.week5_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class BOJ_폰호석만 {
	
	//문자열을 가능한 모든 진법에 대해서 시도! 서로 같은 숫자가 있는지 확인!
	//수가 적어서 크게 시간신경은 안써도될듯 진법변환 전부-> 문제조건에 맞게 답을 도출

	static long convert(String s, long B) {
		long result=0;
		
		for(int i=0; i<s.length(); i++) {
			long num=0;
			
			if('0'<=s.charAt(i) && s.charAt(i)<='9') {
				num=s.charAt(i)-'0';
			}else if('a'<=s.charAt(i) && s.charAt(i)<='z') {
				num=s.charAt(i)-'a'+10;
			}
			
			if(num>=B) return -1;
			if((Long.MAX_VALUE-num)/B<result) return -1;
			result=result*B+num;
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		String a,b;
		a=st[0];
		b=st[1];
		
		ArrayList<Long> A=new ArrayList();
		ArrayList<Long> B=new ArrayList();
		
		for(long i=2; i<=36; i++) {
			A.add(convert(a, i));
			B.add(convert(b, i));
		}
		
		int cnt=0;
		long x=0;
		
		int ai=0, bi=0;
		
		for(int i=0; i<A.size(); i++) {
			if(A.get(i)==-1) continue;
			
			for(int j=0; j<B.size(); j++) {
				if(A.get(i)==B.get(j) && i!=j) {
					cnt++;
					x=A.get(i);
					ai=i;
					bi=j;
				}
			}
		}
		
		if(cnt==0) System.out.println("Impossible");
		else if(cnt>1) System.out.println("Multiple" );
		else System.out.println(x+ " " + (ai+2)+" "+ (bi+2));

	}

}
