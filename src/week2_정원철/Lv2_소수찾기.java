package week2_정원철;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.rtf.RTFEditorKit;

public class Lv2_소수찾기 {
    
	static HashSet<Integer> testSet=new HashSet<>();
	
	public static void forComb(String src, String org) {
		// 첫번째, 현재 조합을 set에 추가한다.
		if(!src.equals("")) {
			testSet.add(Integer.valueOf(src));
		}
		
		// 두번째, 남은 숫자 중한개를 더해 새로운 조합을 만든다.
		for (int i=0; i<org.length(); i++) {
			forComb(src+org.charAt(i),org.substring(0,i)+org.substring(i+1) );
		}
		
		// *substring 사용법
		// 1. substring(n)=> n-1 인덱스 포함 그 이후 문자열이 됨
		// ex. 0123456789 -> 56789
		// 2. substring(start, end) => start는 진짜 그 해당 인덱스 번호 부터, end는 end-1 인덱스까지 뽑아냄
		// 문자열의 길이가 13인데 end에 14를 넣게되면 예외처리
		
	}
	
	public static boolean isPrime(int n) {
		// 0,1은 소수가 아님
		
		if(n==0 || n==1)
			return false;
		
		int chk=(int)Math.sqrt(n);
		
		for (int i=2; i<=chk; i++) {
			if(n%i==0) {
				return false;
			}
		}

		return true;
	}
	
	
	public static int solution(String numbers) {
        //1. 모든 조합의 숫자를 만들어냄
        forComb("", numbers);
        
       
       // System.out.println(testSet);
        //2. 소수의 개수를 샌다, for 문이랑 같다.
        int cnt=0;
        Iterator<Integer> it=testSet.iterator();
        while(it.hasNext()) {
        	int num=it.next();
        	if(isPrime(num)) {
        		cnt++;
        	}
        }
        
        
      
        return cnt;
    }
    
    
    
	public static void main(String[] args) {
		//숫자들의 조합을 찾고 -> 중복되는 조합을 제거하고 -> 소수인지 판단을 하는 메커니즘으로 돌아간다.
		//숫자가 소수인지 판단할때는 일단 그 수에 루트를 씌웠을때까지만 판단하면된다.
	
	
		System.out.println(solution("17"));

		
	}


}
