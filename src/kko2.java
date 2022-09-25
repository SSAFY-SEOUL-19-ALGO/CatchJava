import java.util.*;

public class kko2 {
	public static void main(String[] args) {
		Solution solution;
//		solution.solution(commands);
	}
	class Solution {
	    public String[] solution(String[] commands) {
	        String[] answer = {};
	        ArrayList<String> anList=new ArrayList<>();
	        String [][]map = new String[50][50];
	        HashMap<String,ArrayList<int[]>>keyValue = new HashMap<>();
	        HashMap<Integer,int[][]>mset = new HashMap<>();
	        int mindex=1;

	        for(String str:commands){
	            String[]Sarr= str.split(" ");

	            switch(Sarr[0]){
	                case "UPDATE":
	                    //1.번으로 풀기
	                    if(isNumber(Sarr[1])){
	                        map[Integer.parseInt(Sarr[1])][Integer.parseInt(Sarr[2])]=Sarr[3];
	                        //map이 비어있을 때
	                        ArrayList<int[]>intLi = new ArrayList<>();
	                        intLi.add(new int[]{Integer.parseInt(Sarr[1]),Integer.parseInt(Sarr[2])});
//	                            keyValue.put(Sarr[3],new int[][]{{Integer.parseInt(Sarr[1]),Integer.parseInt(Sarr[2])}});
	 //                       System.out.println(keyValue.get(Sarr[3])); //
	                       if(keyValue.get(Sarr[3])!=null){
	                            ArrayList<int[]>remain= keyValue.get(Sarr[3]); //{2,2},{3,5},{4,6}+새값
	                            for(int[] tmp:remain){
	                                intLi.add(tmp);
	                            }
	                        }
	                        keyValue.put(Sarr[3],intLi);
	                    }else{//2번으로 풀기
	                        ArrayList<int[]>val= keyValue.get(Sarr[1]); //{2,2},{3,5},{4,6}
	                        for(int[] li:val){
	                            map[li[0]][li[1]]=Sarr[2];
	                        }
	                    }
	                break;
	                case "MERGE":
	                    map[Integer.parseInt(Sarr[1])][Integer.parseInt(Sarr[2])]=mindex+"";
	                    mset.put(mindex,new int[][]{{Integer.parseInt(Sarr[1]),Integer.parseInt(Sarr[2])},{Integer.parseInt(Sarr[3]),Integer.parseInt(Sarr[4])}});
	                    mindex++;                    
	                break;
	                case "UNMERGE":
	                    int mcheck = Integer.parseInt(map[Integer.parseInt(Sarr[1])][Integer.parseInt(Sarr[2])]);
	                    mset.get(mcheck);
	                    System.out.println(Arrays.toString(mset.get(mcheck)));
	                break;
	                case "PRINT":
	                    anList.add(map[Integer.parseInt(Sarr[1])][Integer.parseInt(Sarr[2])]);
	                break;

	            }
	        }
	        answer =new String[anList.size()];
	        int i=0;
	        for(String s:anList){
	            answer[i] = s;
	            i++;
	        }
//	        System.out.println(Arrays.toString(commands));
	        return answer;
	    }

	    private boolean isNumber(String s){
	        try{
	            Integer.parseInt(s);
	            return true;
	        }catch (Exception e){
	            return false;
	        }
	    }
	}
}
