package week6.week6_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_에너지드링크 {
//	임의의 서로 다른 두 에너지 드링크를 고른다.
//	한쪽 에너지 드링크를 다른 쪽 에너지 드링크에 모두 붓는다. 단, 페인은 야근 후유증으로 인해 손이 떨려, 붓는 과정에서 원래 양의 절반을 바닥에 흘리게 된다.
//	다 붓고 남은 빈 에너지 드링크는 버린다.
//	1~3 과정을 에너지 드링크가 하나만 남을 때까지 반복한다.
//	10 9 6 3 2
//	10 4.5 3 1.5 1
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N= Integer.parseInt(br.readLine()); //에너지 드링크의 개수를 받을 변수
		ArrayList<Double> arr= new ArrayList<>(); //에너지 드링크들의 양을 받을 리스트
		
		String st[]=br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr.add(Double.parseDouble(st[i])); // 에너지 드링크의 양을 입력 받음
		}
		
		Collections.sort(arr,  Collections.reverseOrder()); // 내림 차순으로 에너지 드링크를 정렬함
		
		double result= arr.remove(0); // 첫 번째 가장 많은 양을 가진 에너지 드링크를 뽑아냄
		
		for(int i=0; i<arr.size(); i++) {
			//System.out.println(arr.get(i));
			result+=arr.get(i)/2; // 이후 가장 많은 드링크를 도착지로하여 남아있는 에너지드링크를 반을 나누고 더하는 과정을 반복
			//System.out.println(result);
		}
			
		System.out.println(result);
		
		// 결론은 큰 순서대로 나열하고 가장 큰수를 기준으로 나누고 더해서 가장큰 수를 만든다는 것인데, 답은 맞았지만 이게 진짜 완벽한 해일까..
	}

}
