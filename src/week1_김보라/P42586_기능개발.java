package week1_김보라;

import java.util.ArrayList;
 
public class P42586_기능개발 {
	static int[] progresses= {30,30,50,10};
	static int[] speeds= {100,100,50,40};
	
	public static void main(String[] args) {
		/*테스트케이스 2번 오류
		 * TODO : 반례 찾아주세요 ㅠㅠ
		ArrayList<Integer> ret=new ArrayList<>();
		int tmp=0;
		int pretmp=-1;
		//pretmp 오류 확인 케이스
		//static int[] progresses= {40,93,30,55,60,65};
		//static int[] speeds= {60,1,30,5,10,7};
		for(int i = 0; i<progresses.length; i++) {
			tmp=(int) Math.ceil((100-progresses[i])/(double)speeds[i]);
//			if(progresses[i]%speeds[i]!=0)	
//				tmp++;
			
			System.out.print(pretmp+" "+tmp+" ");
			if(pretmp>=tmp) {
				ret.set(ret.size()-1, ret.get(ret.size()-1)+1);
			}else {
				ret.add(1);
				pretmp=tmp;
			}
			System.out.println(ret.toString());
		}
		int[] answer = new int[ret.size()];
		for(int i = 0; i<ret.size(); i++) {
			answer[i]=ret.get(i);
			System.out.print(answer[i]+" ");
		}*/
		
		ArrayList<Integer> ret=new ArrayList<>();
		int tmp=-1;
		for(int i = 0; i<progresses.length; i++) {
			if(progresses[i]+speeds[i]*tmp>=100) {
				ret.set(ret.size()-1, ret.get(ret.size()-1)+1);
				continue;
			}
			tmp=(int) Math.ceil((100-progresses[i])/(double)speeds[i]);
			/*얘는 대체가능한 코드
			tmp=(100-progresses[i])/speeds[i];
            if((100-progresses[i])%speeds[i]!=0))
                tmp++;
            */
			
			ret.add(1);
		}
		
		int[] answer = new int[ret.size()];
		for(int i = 0; i<ret.size(); i++) {
			answer[i]=ret.get(i);
			System.out.print(answer[i]+" ");
		}
		
	}

}
