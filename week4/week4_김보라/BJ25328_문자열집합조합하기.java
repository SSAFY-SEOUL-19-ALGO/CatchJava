package week4_김보라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
//https://hianna.tistory.com/573

public class BJ25328_문자열집합조합하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String X = br.readLine();
		String Y = br.readLine();
		String Z = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		
		map=new HashMap<>();
		answer=new PriorityQueue<>();
		
		function(X,k, new boolean[X.length()],0);
		function(Y,k,new boolean[Y.length()],0);
		function(Z,k,new boolean[Z.length()],0);
		
		Set<String> key = map.keySet();
		
		for(String kk:key) {
			if(map.get(kk)>=2)
				answer.add(kk);
		}
		if(answer.isEmpty()) {
			System.out.println("-1");
			return;
		}
		
		while(!answer.isEmpty()) {
			sb.append(answer.poll()).append('\n');
		}
		System.out.println(sb);
		
	}
	static PriorityQueue<String> answer;
	static Map<String, Integer> map;
	static void function(String C, int k,  boolean visited[],  int start) {
		
		if(k==0) {
			String tmpstr="";
			for(int i = 0; i<visited.length; i++) {
				if(visited[i])
				tmpstr+=C.charAt(i);
			}
			if(map.containsKey(tmpstr)) {
				map.put(tmpstr, map.get(tmpstr)+1);
			}else {
				map.put(tmpstr, 1);
			}
			return;
		}
	
		
		for(int i = start; i<C.length(); i++) {
			visited[i]=true;
			function(C,k-1, visited, i+1);
			visited[i]=false;
		}
	}

}
	

	/*왜 출력초과?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String X = br.readLine();
		String Y = br.readLine();
		String Z = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		
		ans= new ArrayList<>();
		answer=new ArrayList<>();
		
		String tmp="";
		for(int x = 0; x<X.length(); x++) {
			for(int y = 0; y<Y.length(); y++) {
				if(X.charAt(x)==Y.charAt(y))
					tmp+=X.charAt(x);
			}
		}
		function(tmp,k,new boolean[tmp.length()],0);
		
		tmp="";
		for(int y = 0; y<Y.length(); y++) {
			for(int z = 0; z<Z.length(); z++) {
				if(Y.charAt(y)==Z.charAt(z))
					tmp+=Y.charAt(y);
			}
		}
		function(tmp,k,new boolean[tmp.length()],0);
		
		tmp="";
		for(int x = 0; x<X.length(); x++) {
			for(int z = 0; z<Z.length(); z++) {
				if(X.charAt(x)==Z.charAt(z))
					tmp+=X.charAt(x);
			}
		}
		function(tmp,k,new boolean[tmp.length()],0);
//		function(X,k, new boolean[X.length()],0);
//		function(Y,k,new boolean[Y.length()],0);
//		function(Z,k,new boolean[Z.length()],0);
		
		if(answer.size()==0) {
			System.out.println("-1");
			return;
		}
		Collections.sort(answer);
		for(int i = 0; i<answer.size(); i++) {
			sb.append(answer.get(i)).append('\n');
		}
		
		System.out.println(sb);
		
	}
	static ArrayList<String> ans;
	static ArrayList<String> answer;
	static void function(String C, int k,  boolean visited[],  int start) {
		
		if(k==0) {
			String tmpstr="";
			for(int i = 0; i<visited.length; i++) {
				if(visited[i])
				tmpstr+=C.charAt(i);
			}
//			if(!ans.contains(tmpstr)) {
//				ans.add(tmpstr);
//			}else if(!answer.contains(tmpstr)) {
//				answer.add(tmpstr);
//			}
			if(!answer.contains(tmpstr)) {
				answer.add(tmpstr);
			}
			return;
		}
	
		
		for(int i = start; i<C.length(); i++) {
			visited[i]=true;
			function(C,k-1, visited, i+1);
			visited[i]=false;
		}
	}

}*/
	/*조합이 문제가 아닌가?
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String X = br.readLine();
		String Y = br.readLine();
		String Z = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		
		ans= new ArrayList<>();
		answer=new ArrayList<>();
		
		function(X,k, new boolean[X.length()],0);
		function(Y,k,new boolean[Y.length()],0);
		function(Z,k,new boolean[Z.length()],0);
		
		Collections.sort(answer);
		for(int i = 0; i<answer.size(); i++) {
			sb.append(answer.get(i)).append('\n');
		}
		if(answer.size()==0) {
			sb.append("-1").append('\n');
		}
		System.out.println(sb);
		
	}
	static ArrayList<String> ans;
	static ArrayList<String> answer;
	static void function(String C, int k,  boolean visited[],  int start) {
		
		if(k==0) {
			String tmpstr="";
			for(int i = 0; i<visited.length; i++) {
				if(visited[i])
				tmpstr+=C.charAt(i);
			}
			if(!ans.contains(tmpstr)) {
				ans.add(tmpstr);
			}else if(!answer.contains(tmpstr)) {
				answer.add(tmpstr);
			}
			return;
		}
	
		
		for(int i = start; i<C.length(); i++) {
			visited[i]=true;
			function(C,k-1, visited, i+1);
			visited[i]=false;
		}
	}

}*/

	/*시간초과
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String X = br.readLine();
		String Y = br.readLine();
		String Z = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		
		ans= new ArrayList<>();
		answer=new ArrayList<>();
		
		function(X,k, new boolean[X.length()],0);
		function(Y,k,new boolean[Y.length()],0);
		function(Z,k,new boolean[Z.length()],0);
		
		Collections.sort(answer);
		for(int i = 0; i<answer.size(); i++) {
			sb.append(answer.get(i)).append('\n');
		}
		if(answer.size()==0) {
			sb.append("-1").append('\n');
		}
		System.out.println(sb);
		
	}
	static ArrayList<String> ans;
	static ArrayList<String> answer;
	static void function(String C, int k,  boolean visited[], int cnt) {
		
		if(k==0) {
			String tmpstr="";
			for(int i = 0; i<visited.length; i++) {
				if(visited[i])
				tmpstr+=C.charAt(i);
			}
			if(!ans.contains(tmpstr)) {
				ans.add(tmpstr);
			}else if(!answer.contains(tmpstr)) {
				answer.add(tmpstr);
			}
			return;
		}
		if(cnt==C.length()) {
			return;
		}
		
		visited[cnt]=true;
		function(C,k-1,visited,cnt+1);
		visited[cnt]=false;
		function(C,k,visited,cnt+1);
	}

}*/

	/*
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String X = br.readLine();
		String Y = br.readLine();
		String Z = br.readLine();
		
		int k = Integer.parseInt(br.readLine());
		
		ans= new ArrayList<>();
		answer=new ArrayList<>();
		
		function(X,k,new char[k], new boolean[X.length()],0);
		System.out.println(answer);
		function(Y,k,new char[k], new boolean[Y.length()],0);
		System.out.println(answer);
		function(Z,k,new char[k], new boolean[Z.length()],0);
		
		System.out.println(answer);
		
	}
	static ArrayList<String> ans;
	static ArrayList<String> answer;
	static void function(String C, int k, char[] tmp, boolean visited[], int cnt) {
		if(cnt==k) {
//			String tmp="";
//			for(int i = 0; i<visited.length; i++) {
//				if(visited[i]) {
//					tmp+=C.charAt(i);
//				}
//			}
//			if(!ans.contains(tmp)) {
//				ans.add(Arrays.toString(tmp));
//			}else {
//				if(!answer.contains(tmp))
//					answer.add(Arrays.toString(tmp));
//			}
			String tmpstr="";
			for(int i = 0; i<k; i++) {
				tmpstr+=tmp[i];
			}
			if(!ans.contains(tmpstr)) {
				ans.add(tmpstr);
			}else if(!answer.contains(tmpstr)) {
				answer.add(tmpstr);
			}
			return;
		}
		
		for(int i = 0; i<C.length(); i++) {
			if(!visited[i]) {
				tmp[cnt]=C.charAt(i);
				visited[i]=true;
				function(C,k,tmp,visited,cnt+1);
				visited[i]=false;
			}
		}
	}

}*/
