package week4.week4_정원철;

import java.util.Scanner;

public class BOJ_뒤집기 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StringBuilder sb=new StringBuilder(sc.next());
		int cnt=1;
		for (int i=0; i<sb.length()-1; i++) if(sb.charAt(i)!=sb.charAt(i+1)) cnt++;
		System.out.print(cnt/2);

	}

}
