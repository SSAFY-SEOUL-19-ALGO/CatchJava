package week2_김영서;
import java.util.HashSet;

public class P42839_소수찾기 {

    HashSet<Integer> returnNum = new HashSet<>();
    HashSet<Integer> answer = new HashSet<>();
    //순열만들기
    public void perm(String num,String rec){
        if(!num.equals("")){
            returnNum.add(Integer.parseInt(num));
        }
        for(int i=0;i<rec.length();i++) {
        	if(!num.equals("")) {
        		returnNum.add(Integer.parseInt(num));
        	}
        	perm(num+rec.charAt(i),rec.substring(0,i)+rec.substring(i+1));
        }
    }
    
    public int solution(String numbers) {
        //순열만들기
        perm("",numbers);

        //소수인지 확인하기 -> 아리스토테네스의 체
        for(Integer i: returnNum) {
        	boolean check=true;
        	//0과 1은 소수가 아니다
        	if(i ==1 || i ==0) continue;
        	//제곱근으로 나눴을때 나눠지면 소수가 아니다
        	int limit = (int)Math.sqrt(i);
        	for(int n=2;n<=limit;n++) {
        		if(i%n == 0) {
        			check = false;
        			continue;
        		}
        	}
        	if(check ==true) {
            	answer.add(i);//answer++;    
        	}
        }

        return answer.size();
    }
}
