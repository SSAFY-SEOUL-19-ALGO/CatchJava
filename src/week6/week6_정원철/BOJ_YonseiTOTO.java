package week6.week6_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_YonseiTOTO {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String st[]=br.readLine().split(" ");
		
		int numOfSubject=Integer.parseInt(st[0]); // 과목수를 입력
		int totalMileage=Integer.parseInt(st[1]); // 소모할 마일리지수를 입력
		ArrayList<Integer>compareMileage= new ArrayList<>();  // 소모될 마일리지를 담을 리스트
		int subCnt=0; //과목수를 카운터할 변수
		int mileTotal=0; // 과목당 마일리지를 더해가며 준비될 마일리지와 비교할 변수
		for(int i=0; i<numOfSubject; i++) {
			st=br.readLine().split(" ");
			
			int appStu=Integer.parseInt(st[0]); // 신청인원 변수
			int limitStu=Integer.parseInt(st[1]); // 수강제한 인원 변수
			

			Integer [] arr=new Integer[appStu]; // 수강인원의 배팅 마일리지를 담을 배열
			st=br.readLine().split(" ");
			for(int j=0; j<appStu; j++) {
				arr[j]=Integer.parseInt(st[j]); // 배팅? 마일리지를 담음
			}
			
			Arrays.sort(arr,Collections.reverseOrder()); // 내림 차순으로 정리를함
			//System.out.println("배열"+Arrays.toString(arr));
			if(appStu<limitStu) { // 일단 수강제한 인원보다 적게 신청을 하게되면 최소금액을 제출해도 가능하므로 소모 리스트에 1을 추가
				compareMileage.add(1);
			}else if(appStu>=limitStu ) { // 수강제한 인원보다 많거나 같으면 내림차순에서 커트라인에 서있는 사람과 같은 금액을 내면 신청되므로 제한인원 인덱스에 있는 마일리지 추가
				 compareMileage.add(arr[limitStu-1]);
			}
					
		}
		//System.out.println("첫째"+compareMileage);
		Collections.sort(compareMileage); // 소모 마일리지 리스트를 오름차순 정렬, 적은걸 먼저 넣어야 최대로 들을수있음
		//System.out.println("둘째"+compareMileage);
		for(int i=0; i<compareMileage.size(); i++) {
			mileTotal+=compareMileage.get(i); // 더해가면서
			if(mileTotal<totalMileage) { // 소모할 마일리지수와 비교해가며 과목수 카운터
				subCnt++;
				continue;
			}else if(mileTotal==totalMileage) { // 같아도 끝
				subCnt++;
				break;
			}else { // 넘어가도 끝!
				break;
			}
			
		}
		System.out.println(subCnt);
	}

}
