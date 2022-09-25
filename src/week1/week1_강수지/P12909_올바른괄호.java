package week1.week1_강수지;

import java.util.*;

public class P12909_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> tmp = new Stack<>(); //stack add pop 사용 !
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(tmp.size()!=0){
                if(c==')'){
                tmp.pop();
                }else{
                    tmp.add(c);
                }
            } else{
                tmp.add(c);
            }
            if (tmp.isEmpty()==true){
                answer = true;
            } else{
                answer = false;
            }
        }

        return answer;
    }
}
