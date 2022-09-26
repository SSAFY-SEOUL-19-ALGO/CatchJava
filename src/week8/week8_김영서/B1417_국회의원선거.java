package week8.week8_김영서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
 
public class B1417_국회의원선거 {
    static class Info{
        int number, vote;
 
        public Info(int number, int vote) {
            this.number = number;
            this.vote = vote;
        }
    }
    
    static int N;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
 
            @Override
            public int compare(Info o1, Info o2) {
                return (o1.vote-o2.vote)*-1;
            }
        });
        
        N = Integer.parseInt(br.readLine());
        
        Info dasom = new Info(1, Integer.parseInt(br.readLine()));
        for(int i=2;i<=N;i++) {
            pq.add(new Info(i, Integer.parseInt(br.readLine())));
        }
        
        int count=0;
        while(true) {
            if(pq.isEmpty()||dasom.vote>pq.peek().vote) break;
            
            Info temp = pq.poll();
            dasom.vote=dasom.vote+1;
            pq.add(new Info(temp.number, temp.vote-1));
            count++;
        }
        
        System.out.println(count);
 
    }
 
}
