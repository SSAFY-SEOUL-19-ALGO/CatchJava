package week1.week1_김보라;

import java.util.ArrayList;
 
public class P12906_같은숫자는싫어 {
	static int[] arr= {1,1,3,3,0,1,1};
	
	public static void main(String[] args) {
		/*시간초과
        ArrayList<Integer> a=new ArrayList<>();
		
        for(int i=0;;i++){
            if(i==arr.length-1&&arr[i]==arr[i-1]){		//이게 생각보다 실행시간이 많이걸리나봐
                a.add(arr[i]);
                break;
            }
            if(arr[i]==arr[i+1])
                continue;
            else
            	a.add(arr[i]);
        }
        int[] answer= new int[a.size()];
        for(int i = 0; i<a.size(); i++) {
        	answer[i]=a.get(i);
        }
        */
		
		
		ArrayList<Integer> a=new ArrayList<>();
		
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1])
                continue;
            else
            	a.add(arr[i]);
        }
        a.add(arr[arr.length-1]);
        
        int[] answer= new int[a.size()];
        for(int i = 0; i<a.size(); i++) {
        	answer[i]=a.get(i);
        }
        
        
	}
}
