package week1_강수지;

import java.util.*;

public class P12906_같은숫자는싫어 {
	public int[] solution(int []arr) {
        ArrayList<Integer> tmp = new ArrayList<>();
        
        int start = arr[0];
        tmp.add(start);
        for(int i=1; i<arr.length;i++){
            if(start!=arr[i]){
                tmp.add(arr[i]);
                start = arr[i];
            }
         }
        
        int[] answer = new int[tmp.size()];
        
         for(int j=0;j< tmp.size();j++){
             answer[j] = tmp.get(j);
         }

        return answer;
    }
}
