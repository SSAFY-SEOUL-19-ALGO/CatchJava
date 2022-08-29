package week1_정원철;

import java.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.plaf.SliderUI;

public class Lv1_같은숫자는싫어 {
	 public static int[] solution(int []arr) {
		//배열을 담을 ArrayList 선언
		ArrayList<Integer> test= new ArrayList<>();
		
		//첫 배열을 받아 비교대상을 temp에 저장
		int temp=arr[0];
		//ex) 7 -> 0 1 2 3 4 5 6
		
		//첫 리스트에 첫 원소를 이미 저장해놓았기에 인덱스 1부터 시작
		for (int i=1; i<arr.length; i++) {
			
			//temp에 저장된 이전 원소와 현 원소가 다르면 리스트에 삽입
			if (temp!=arr[i]) {
				test.add(temp);
			//temp를 현 원소로 교체하여 다음 원소와 비교할 준비
				temp=arr[i];
			}

			//마지막원소의 경우 위에서 체크를 이미하고 같든 다르든 저장 해야하기에 값을 같음, 마지막 원소 리스트에 삽입
			if (i==arr.length-1) {
				test.add(arr[i]);
			}
		}

		 // answer에 해당 리스트 올기고 저장 반환
		 int[] answer = new int[test.size()];
		 for (int i=0; i<test.size(); i++) {
			 answer[i]=test.get(i);
		 }
	        return answer;
	    }
	 	 
	 public static void main(String[] args) {
		 int[] arr1= {1,1,3,3,0,1,1};
		 int[] arr2= {4,4,4,0};
				
		 System.out.println(Arrays.toString(solution(arr1)));
 
	}
}
