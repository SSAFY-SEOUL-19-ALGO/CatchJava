package week7.week7_김영서;
 
import java.util.*;
import java.io.*;
 
public class B13164_행복유치원 {
    static int atoi(String str){
        return Integer.parseInt(str);
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> diff = new ArrayList<>();
        int N = atoi(st.nextToken()); // 사람 인원 수
        int K = atoi(st.nextToken()); // 그룹 수
 
        st = new StringTokenizer(br.readLine());
 
        while(st.hasMoreTokens()){
            al.add(atoi(st.nextToken()));
        }
 
        for(int i = 0; i < al.size() - 1; i++){
            diff.add(al.get(i+1) - al.get(i)); //인접에 대한 차를 구함
        }
 
        Collections.sort(diff); // 오름차순
 
        int result = 0;
 
        for(int i = 0; i < N-K; i++){
            result += diff.get(i);
        }
 
        System.out.print(result);
    }
}