package week9.week9_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_주식 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
		//  얘도 계속 틀리다가 받는 타입 int-> long으로 받아줘서 통과
			
			List<Integer> list=new ArrayList<>();
			int N= Integer.parseInt(br.readLine());
			
			String st[]=br.readLine().split(" ");
			for (int j=0 ; j<N; j++) {
				list.add(Integer.parseInt(st[j]));
			}
			
			long max=0;
			long total=0;
			for (int j=0; j<N; j++) {
				System.out.println(" :"+list.get(list.size()-1-j));
				if(max<list.get(list.size()-1-j)) {
					max=list.get(list.size()-1-j);
					continue;
				}
				
				total+=max-list.get(list.size()-1-j);
			}
			
			System.out.println(total);
		}
			
			
// 어떤 반례를 도저히 못찾겠다...
//		List<Integer> originList=new ArrayList<>();
//		
//		int N= Integer.parseInt(br.readLine());
//		
//		String st[]=br.readLine().split(" ");
//		for (int j=0 ; j<N; j++) {
//			originList.add(Integer.parseInt(st[j]));
//		}
//		
//		int idx=0;
//		int buyCnt=0;
//		long buyCoin=0;
//		long getCoin=0;
//		int point=originList.indexOf(Collections.max(originList));
//		int chk=1;
//
//		for(int j=0; j<N; j++) {
//			if(j==point) {
//				getCoin+=buyCnt*originList.get(point)-buyCoin;
//				buyCnt=0;
//				buyCoin=0;
//				//System.out.println("getcointest: "+getCoin);
//				if(j+1<N) {
//					originList.set(j, -1);
//					point=originList.indexOf(Collections.max(originList.subList(j+1, originList.size())));
//					//System.out.println(originList);
//					//System.out.println("point:" + point);
//					continue;
//				}
//				
//			}
//			
//			buyCoin+=originList.get(j);
//			buyCnt++;
//			//System.out.println(buyCoin+" : "+ buyCnt);
//		}
//		
//		System.out.println(getCoin);
//		//System.out.println("======================");		



		
	}

}
