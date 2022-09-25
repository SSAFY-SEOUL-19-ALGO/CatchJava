package week2.week2_김보라;

import java.util.HashSet;
import java.util.Set;

public class P42839_소수찾기 {

	static String numbers= "\"17\"";
	
	public static void main(String[] args) {
		// int[] num=new int[numbers.length()-2];
		// Set<Integer> answer=new HashSet<>();
		// for(int i = 1; i<numbers.length()-1; i++) {
		// 	num[i-1]=numbers.charAt(i)-'0';
		// }
	    int[] num = new int[numbers.length()];
	    Set<Integer> answer= new HashSet<>();
	    for(int i = 0; i<numbers.length(); i++){
	        num[i]=numbers.charAt(i)-'0';
	    }
		for(int r = 1; r<=num.length; r++) {
			p(0,num, new boolean[num.length],new int[r],r,answer);
		}
		System.out.println(answer.size());
	}
	static void p(int cnt, int[] arr, boolean[] visited, int[] n, int r, Set<Integer> answer) {
		if(cnt==r) {
			int a = 0;
			for(int b : n) {
				a=a*10+b;
			}
			if(isPrime(a)) {
				answer.add(a);
			}
			return;
		}
		for(int i = 0; i<arr.length;i++) {
			if(visited[i])
				continue;
			visited[i]=true;
			n[cnt]=arr[i];
			p(cnt+1,arr,visited,n,r,answer);
			visited[i]=false;
		}
		
	}
	static boolean isPrime(int num) {	//소수인가?
		if(num<2)
			return false;
		for(int n = 2; n<num-1; n++) {
			if(num%n==0)
				return false;
		}
		return true;
	}
	/*
	public static void main(String[] args) {
		 HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);
        int count = 0;
        while(set.iterator().hasNext()){
            int a = set.iterator().next();
            set.remove(a);
            if(a==2) count++;
            if(a%2!=0 && isPrime(a)){
                count++;
            }
        }        
        return count;
    }

    public boolean isPrime(int n){
        if(n==0 || n==1) return false;
        for(int i=3; i<=(int)Math.sqrt(n); i+=2){
            if(n%i==0) return false;
        }
        return true;
    }

        public void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        //if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
          permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);

    }

	*/
}
